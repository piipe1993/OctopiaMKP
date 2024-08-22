package co.com.grupoexito.octopia.tasks;

import co.com.grupoexito.octopia.interactions.AceptarCookiesOctopiaVendedores;
import co.com.grupoexito.octopia.interactions.CambiarIdiomaOctopiaVendedores;
import co.com.grupoexito.octopia.interactions.CerrarNavegador;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static co.com.grupoexito.octopia.ui.PaginaCrearProductosMasivos.*;
import static co.com.grupoexito.octopia.ui.PaginaProductosOctopiaVendedores.CAMPO_BUSQUEDA_PRODUCTOS_PORTAL_OCTOPIA;
import static co.com.grupoexito.octopia.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearOfertaMasiva implements Task {

    private WebDriver browser;

    public CrearOfertaMasiva(WebDriver browser) {
        this.browser = browser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        List<String> listaGtin = new ArrayList<>();
        listaGtin = actor.recall(LISTA_GTIN);



        for (String elemento : listaGtin){
            actor.attemptsTo(
                    VenderProducto.delProducto(),
                    CrearOferta.conInformacionProducto(elemento, elemento)
            );
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



        for (String elementoGtin : listaGtin){
            actor.attemptsTo(
                    ConsultarProductos.conElProducto(elementoGtin, browser, 40),
                    Clear.field(CAMPO_BUSQUEDA_PRODUCTOS_PORTAL_OCTOPIA)
            );
            browser.navigate().refresh();

            actor.attemptsTo(
                    Clear.field(CAMPO_BUSQUEDA_PRODUCTOS_PORTAL_OCTOPIA)
            );

        }



    }


    public static CrearOfertaMasiva conGtin (WebDriver browser){

        return instrumented(CrearOfertaMasiva.class, browser);
    }
}
