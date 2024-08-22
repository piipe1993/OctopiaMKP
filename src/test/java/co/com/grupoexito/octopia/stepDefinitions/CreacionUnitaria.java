package co.com.grupoexito.octopia.stepDefinitions;

import co.com.grupoexito.octopia.exceptions.MensajeExcepciones;
import co.com.grupoexito.octopia.interactions.*;
import co.com.grupoexito.octopia.models.Credenciales;
import co.com.grupoexito.octopia.models.TipoProducto;
import co.com.grupoexito.octopia.tasks.*;
import co.com.grupoexito.octopia.ui.PaginaInicioOctopiaVendedores;
import co.com.grupoexito.octopia.ui.PaginaInicioOperadorOctopia;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static co.com.grupoexito.octopia.utils.Constantes.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class CreacionUnitaria {


    private Actor analistaExito = Actor.named("User");
    private PaginaInicioOctopiaVendedores octopiaVendedores = new PaginaInicioOctopiaVendedores();
    private PaginaInicioOperadorOctopia octopiaOperadores = new PaginaInicioOperadorOctopia();

    private String respuestaToken;
    private Credenciales credenciales;
    private String rutaArchivoProducto;

    {
        try {
            credenciales = new Credenciales("credenciales.properties");
        } catch (MensajeExcepciones e) {
            throw new RuntimeException(e);
        }
    }

    @Managed(driver = "chrome")
    private WebDriver browser;

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
    }


    @Given("El usuario cargue un producto y su oferta correspondiente dentro del portal vendedor")
    public void el_usuario_cargue_un_producto_y_su_oferta_correspondiente_dentro_del_portal_vendedor(List<Map<String, String>> tipoProducto) {




        /**CONEXIÓN CON LA API DE PRODUCTOS Y CREACIÓN DEL PRODUCTO*/
        TipoProducto tipologiaProducto = new TipoProducto(tipoProducto.get(0));
        rutaArchivoProducto = RUTA_ARCHIVO_CUERPO_CREAR_PRODUCTO + tipologiaProducto.getTipoProducto() + ".json";
        System.out.println(rutaArchivoProducto);


        analistaExito = Actor.named("Analista Exito");
        analistaExito = Actor.named("Analista Exito").whoCan(
                CallAnApi.at(BASE_URL_TOKEN)
        );
        analistaExito.attemptsTo(
                ObtenerToken.conCredenciales()
        );
        respuestaToken = lastResponse().getBody().asString();


        analistaExito.whoCan(
                CallAnApi.at(BASE_URL)
        );
        analistaExito.attemptsTo(
                GenerarGtin.conElDigito(browser, respuestaToken, CANTIDAD_GTIN_CARGA_UNITARIA)
        );
        analistaExito.attemptsTo(
                ModificarGtinCuerpoProducto.conElGtin(rutaArchivoProducto, tipologiaProducto.getTipoProducto())
        );

        analistaExito.attemptsTo(
                CrearProducto.conElToken(respuestaToken, rutaArchivoProducto)
        );


        /**CREACIÓN DE LA OFERTA*/
        browser.manage().window().maximize();
        analistaExito.can(
                BrowseTheWeb.with(browser));
        analistaExito.attemptsTo(
                NavegarA.laPagina(octopiaVendedores));

        analistaExito.attemptsTo(
                IniciarSesionOctopiaVendedor.conCredenciales(
                        credenciales.getProperty("portalOctopiaVendedores.usuario"),
                        credenciales.getProperty("portalOctopiaVendedores.contrasena")),
                AceptarCookiesOctopiaVendedores.delPortalOctopia(),
                CambiarIdiomaOctopiaVendedores.aEspanol(),
                VenderProducto.delProducto(),
                ObtenerCamposApiProducto.delCuerpo(rutaArchivoProducto)
        );

        analistaExito.attemptsTo(
                CrearOferta.conInformacionProducto(analistaExito.recall(GTIN_PRODUCTO_API_PRODUCTOS), analistaExito.recall(REFERENCIA_PRODUCTO_API_PRODUCTOS)),
                ConsultarProductos.conElProducto(analistaExito.recall(GTIN_PRODUCTO_API_PRODUCTOS), browser, TIEMPO_CONSULTA_REINTENTOS_PRODUCTOS),
                CerrarNavegador.justoAhora()
        );


        /**ACEPTAR PRODUCTOS EN EL PORTAL OPERADOR*/
        browser.manage().window().maximize();
        analistaExito.attemptsTo(
                NavegarA.laPagina(octopiaOperadores),
                IniciarSesionOctopiaOperador.conCredenciales(
                        credenciales.getProperty("portalOctopiaOperador.usuario"),
                        credenciales.getProperty("portalOctopiaOperador.contrasena")
                ),
                AceptarCookiesOctopiaOperador.delPortal(),
                CambiarIdiomaOctopiaOperador.aEspanol(),
                AceptarProductosOctopiaOperador.conGtin(analistaExito.recall(GTIN_PRODUCTO_API_PRODUCTOS))
        );

    }

    @When("se procesen y registren los datos en Dynamodb del producto unitario")
    public void se_procesen_y_registren_los_datos_en_dynamodb_del_producto_unitario() {

        analistaExito.whoCan(
                CallAnApi.at(BASE_URL)
        );
        analistaExito.attemptsTo(
                ConsultarIdProduct.conGtin(analistaExito.recall(GTIN_PRODUCTO_API_PRODUCTOS), respuestaToken),
                ConsultarPartitionKeyDynamo.conLosValores(PARTITION_KEY, 100037927)
        );

        System.out.println(Optional.ofNullable(analistaExito.recall(ID_PRODUCT_OCTOPIA)));
        analistaExito.attemptsTo(
                ConsultarIndiceDynamo.conLosValores("idProduct", analistaExito.recall(ID_PRODUCT_OCTOPIA)),
                ConsultarIndiceDynamo.conLosValores("idProduct", "AAAAA41883")

        );



    }

    @Then("se debe visualizar el producto y la oferta unitaria en estado activo en VTEX")
    public void se_debe_visualizar_el_producto_y_la_oferta_unitaria_en_estado_activo_en_vtex() {


        System.out.println(Optional.ofNullable(analistaExito.recall(GTIN_PRODUCTO_API_PRODUCTOS)));
//        analistaExito.attemptsTo(ConsultarProductoEnVtex.conEAN(analistaExito.recall(GTIN_PRODUCTO_API_PRODUCTOS)));
        analistaExito.attemptsTo(ConsultarProductoEnVtex.conEAN("9095347687299"));

    }
}
