package co.com.grupoexito.octopia.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static co.com.grupoexito.octopia.ui.PaginaCrearOfertaMasiva.*;
import static co.com.grupoexito.octopia.ui.PaginaInicioOctopiaVendedores.*;
import static co.com.grupoexito.octopia.ui.PaginaProductosOctopiaVendedores.CAMPO_BUSQUEDA_PRODUCTOS_PORTAL_OCTOPIA;
import static co.com.grupoexito.octopia.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearOfertaMasivaExcel implements Task {
    private String RutaArchivoOfertas;
    private WebDriver browser;


    public CrearOfertaMasivaExcel(String rutaArchivoOfertas, WebDriver browser) {
        RutaArchivoOfertas = rutaArchivoOfertas;
        this.browser = browser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<String> listaGtin = new ArrayList<>();
        listaGtin = actor.recall(LISTA_GTIN);
        Path archivoExcel = Paths.get(RutaArchivoOfertas);

        actor.attemptsTo(
                WaitUntil.the(MENU_PRODUCTOS_PORTAL_VENDEDORES,isVisible()),
                Click.on(MENU_PRODUCTOS_PORTAL_VENDEDORES),
                WaitUntil.the(MENU_VENDER_PRODUCTOS_MASIVAMENTE_PORTAL_VENDEDORES, isVisible()),
                Click.on(MENU_VENDER_PRODUCTOS_MASIVAMENTE_PORTAL_VENDEDORES),
                WaitUntil.the(BOTON_CREAR_ACTUALIZAR_OFERTAS, isVisible()),
                Click.on(BOTON_CREAR_ACTUALIZAR_OFERTAS),
                Upload.theFile(archivoExcel).to(BOTON_SUBIR_ARCHIVO_OFERTA_MASIVA),
                Click.on(BOTON_ACEPTAR_OFERTA_MASIVA),
                Click.on(BOTON_CERRAR_OFERTA_MASIVA),
                Click.on(MENU_PRODUCTOS_PORTAL_VENDEDORES),
                Click.on(MENU_CONSULTAR_PRODUCTOS)

        );


        for (String elementoGtin : listaGtin){
            actor.attemptsTo(
                    ConsultarProductos.conElProducto(elementoGtin, browser, 20),
                    Clear.field(CAMPO_BUSQUEDA_PRODUCTOS_PORTAL_OCTOPIA)
            );

        }

    }

    public static CrearOfertaMasivaExcel delArchivo (String rutaArchivoOfertas, WebDriver browser){

        return instrumented(CrearOfertaMasivaExcel.class, rutaArchivoOfertas, browser);
    }
}
