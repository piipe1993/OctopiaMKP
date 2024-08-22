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

import static co.com.grupoexito.octopia.utils.Constantes.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class CreacionMasiva {

    private Actor analistaExito = Actor.named("User");
    private PaginaInicioOctopiaVendedores octopiaVendedores = new PaginaInicioOctopiaVendedores();
    private PaginaInicioOperadorOctopia octopiaOperadores = new PaginaInicioOperadorOctopia();
    private String respuestaToken;
    private Credenciales credenciales;
    private String rutaArchivo;

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

    @Given("El usuario cargue los archivos de productos y ofertas dentro del portal vendedor")
    public void el_usuario_cargue_los_archivos_de_productos_y_ofertas_dentro_del_portal_vendedor(List<Map<String, String>> tipoProducto) {


        TipoProducto tipologiaProducto = new TipoProducto(tipoProducto.get(0));
        rutaArchivo = RUTA_ARCHIVO_EXCEL_PRODUCTOS_MASIVOS + tipologiaProducto.getTipoProducto() + ".xlsm";
        System.out.println(rutaArchivo);



        /**CONEXIÓN CON LA API DE PRODUCTOS*/

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
                GenerarGtin.conElDigito(browser, respuestaToken, CANTIDAD_GTIN_CARGA_MASIVA)
        );


        analistaExito.attemptsTo(ModificarGtinArchivoExcel.conLaRuta(rutaArchivo));


        browser.manage().window().maximize();

        analistaExito.can(
                BrowseTheWeb.with(browser));

        analistaExito.attemptsTo(
                NavegarA.laPagina(octopiaVendedores),
                IniciarSesionOctopiaVendedor.conCredenciales(
                        credenciales.getProperty("portalOctopiaVendedores.usuario"),
                        credenciales.getProperty("portalOctopiaVendedores.contrasena")),
                AceptarCookiesOctopiaVendedores.delPortalOctopia(),
                CambiarIdiomaOctopiaVendedores.aEspanol(),
                CrearProductosMasivamente.conElArchivo(rutaArchivo),
                CrearOfertaMasiva.conGtin(browser),
//                CrearOfertaMasivaExcel.delArchivo(RUTA_ARCHIVO_EXCEL_OFERTAS_MASIVAS, browser),
                CerrarNavegador.justoAhora()
        );


        browser.manage().window().maximize();
        analistaExito.attemptsTo(
                NavegarA.laPagina(octopiaOperadores),
                IniciarSesionOctopiaOperador.conCredenciales(
                        credenciales.getProperty("portalOctopiaOperador.usuario"),
                        credenciales.getProperty("portalOctopiaOperador.contrasena")
                ),
                AceptarCookiesOctopiaOperador.delPortal(),
                CambiarIdiomaOctopiaOperador.aEspanol(),
                AceptarProductosMasivosOperador.conGtin(browser)
        );


    }

    @When("se procesen y registren los datos en Dynamodb")
    public void se_procesen_y_registren_los_datos_en_dynamodb() {

    }

    @Then("se deben visualizar los productos y ofertas en estado activo en VTEX")
    public void se_deben_visualizar_los_productos_y_ofertas_en_estado_activo_en_vtex() {

    }
}
