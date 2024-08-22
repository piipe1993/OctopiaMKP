package co.com.grupoexito.octopia.tasks;

import co.com.grupoexito.octopia.interactions.CerrarNavegador;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

import static co.com.grupoexito.octopia.ui.PaginaCrearProductosMasivos.BOTON_CERRAR;
import static co.com.grupoexito.octopia.ui.PaginaCrearProductosMasivos.*;
import static co.com.grupoexito.octopia.ui.PaginaInicioOctopiaVendedores.*;
import static co.com.grupoexito.octopia.utils.Constantes.RUTA_ARCHIVO_EXCEL_PRODUCTOS_MASIVOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearProductosMasivamente implements Task {


    private String rutaArchivo;

    public CrearProductosMasivamente(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Path excelFile = Paths.get(rutaArchivo);

        try{
            actor.attemptsTo(
                    WaitUntil.the(MENU_PRODUCTOS_PORTAL_VENDEDORES,isVisible()),
                    Click.on(MENU_PRODUCTOS_PORTAL_VENDEDORES),
                    Click.on(MENU_CREAR_PRODUCTOS_MASIVAMENTE_PORTAL_VENDEDORES),
                    WaitUntil.the(ELEMENTO_API_OCTOPIA_BANNER_INFERIOR,isVisible()),
                    Upload.theFile(excelFile).to(BOTON_EXAMINAR_CARGA_ARCHIVO_PRODUCTOS),
                    Click.on(BOTON_ACEPTAR_CARGA_ARCHIVO_PRODUCTOS)

                    );

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            actor.attemptsTo(WaitUntil.the(BOTON_CERRAR,isVisible()),
                    Click.on(BOTON_CERRAR));

        } catch (NoSuchElementException e) {
            System.out.println("No es posible interactuar con el elemento: " + e.getMessage());
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CerrarNavegador.justoAhora();
    }




    public static Performable conElArchivo(String rutaArchivo) {
        return instrumented(CrearProductosMasivamente.class, rutaArchivo);
    }
}
