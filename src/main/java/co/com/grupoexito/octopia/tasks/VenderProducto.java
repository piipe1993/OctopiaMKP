package co.com.grupoexito.octopia.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.grupoexito.octopia.ui.PaginaInicioOctopiaVendedores.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VenderProducto implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(MENU_PRODUCTOS_PORTAL_VENDEDORES,isVisible()),
                Click.on(MENU_PRODUCTOS_PORTAL_VENDEDORES),
                WaitUntil.the(MENU_VENDER_PRODUCTO_PORTAL_VENDEDORES,isVisible()),
                Click.on(MENU_VENDER_PRODUCTO_PORTAL_VENDEDORES)
        );

    }


    public static Performable delProducto() {
        return new VenderProducto();
    }
}
