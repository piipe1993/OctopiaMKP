package co.com.grupoexito.octopia.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static co.com.grupoexito.octopia.ui.PaginaProductosOctopiaVendedores.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConsultarProductos implements Task {


    private String eanProducto;
    private WebDriver browser;
    private Integer tiempoConsulta;

    public ConsultarProductos(String eanProducto, WebDriver browser, Integer tiempoConsulta) {
        this.eanProducto = eanProducto;
        this.browser = browser;
        this.tiempoConsulta = tiempoConsulta;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {

        String estadoOferta,subEstadoOferta;
        int contador = 1;

        actor.attemptsTo(

                WaitUntil.the(CAMPO_BUSQUEDA_PRODUCTOS_PORTAL_OCTOPIA, isVisible()),
                SendKeys.of(eanProducto).into(CAMPO_BUSQUEDA_PRODUCTOS_PORTAL_OCTOPIA),
                Click.on(BOTON_BUSCAR_PRODUCTOS_PORTAL_OCTOPIA),
                WaitUntil.the(CATALOGO_PRODUCTOS_PORTAL_VENDEDORES, isVisible())
        );



        do{
            try {
                Thread.sleep(tiempoConsulta*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            browser.navigate().refresh();
            actor.attemptsTo(WaitUntil.the(CATALOGO_PRODUCTOS_PORTAL_VENDEDORES, isVisible()));
            estadoOferta = actor.asksFor(Text.of(ESTADO_OFERTA).asString());
            subEstadoOferta=actor.asksFor(Text.of(SUBESTADO_OFERTA).asString());
            System.out.println("estado y subestado oferta intento " + contador + ": "+ estadoOferta +": "+ subEstadoOferta);
            contador = contador++;

        } while (!estadoOferta.equals("Activa")&& !subEstadoOferta.equals("Pendiente"));


    }


    public static ConsultarProductos conElProducto(String eanProducto, WebDriver browser, Integer tiempoConsulta) {
        return instrumented(ConsultarProductos.class, eanProducto, browser, tiempoConsulta);
    }
}
