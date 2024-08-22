package co.com.grupoexito.octopia.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static co.com.grupoexito.octopia.ui.PaginaProductosOctopiaVendedores.CAMPO_BUSQUEDA_PRODUCTOS_PORTAL_OCTOPIA;
import static co.com.grupoexito.octopia.ui.PaginaProductosOperadorOctopia.BARRA_BUSCAR_PRODUCTOS_PORTAL_OPERADOR;
import static co.com.grupoexito.octopia.utils.Constantes.GTIN_PRODUCTO_API_PRODUCTOS;
import static co.com.grupoexito.octopia.utils.Constantes.LISTA_GTIN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AceptarProductosMasivosOperador implements Task {

    private WebDriver browser;

    public AceptarProductosMasivosOperador(WebDriver browser) {
        this.browser = browser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        List<String> listaGtin = new ArrayList<>();
        listaGtin = actor.recall(LISTA_GTIN);

        for ( String elemento : listaGtin){

            actor.attemptsTo(
                    AceptarProductosOctopiaOperador.conGtin(elemento)
            );

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            browser.navigate().refresh();

            actor.attemptsTo(
                    Clear.field(BARRA_BUSCAR_PRODUCTOS_PORTAL_OPERADOR)
            );
        }
    }


    public static AceptarProductosMasivosOperador conGtin (WebDriver browser) {
        return instrumented(AceptarProductosMasivosOperador.class, browser);
    }
}
