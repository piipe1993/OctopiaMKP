package co.com.grupoexito.octopia.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.NoSuchElementException;

import static co.com.grupoexito.octopia.ui.PaginaPrincipalOperadorOctopia.*;
import static co.com.grupoexito.octopia.ui.PaginaProductosOperadorOctopia.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AceptarProductosOctopiaOperador implements Task {

    private String gtin;

    public AceptarProductosOctopiaOperador(String gtin) {
        this.gtin = gtin;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
        actor.attemptsTo(
                WaitUntil.the(MENU_PRODUCTOS_PORTAL_OPERADOR, isVisible()),
                DoubleClick.on(MENU_PRODUCTOS_PORTAL_OPERADOR),
                Click.on(MENU_PRODUCTOS_PORTAL_OPERADOR),
                WaitUntil.the(BARRA_BUSCAR_PRODUCTOS_PORTAL_OPERADOR, isVisible()),
                SendKeys.of(gtin).into(BARRA_BUSCAR_PRODUCTOS_PORTAL_OPERADOR),
                Click.on(BOTON_BUSCAR_PRODUCTOS_PORTAL_OPERADOR),
                WaitUntil.the(BOTON_ACEPTAR_PRODUCTOS_PORTAL_OPERADOR, isVisible()),
                Click.on(BOTON_ACEPTAR_PRODUCTOS_PORTAL_OPERADOR).afterWaitingUntilEnabled()

        );

        } catch (NoSuchElementException e) {
            System.out.println("Se ha producido una excepción: " + e.getMessage());
        }

    }


    public static AceptarProductosOctopiaOperador conGtin(String gtin) {
        return instrumented(AceptarProductosOctopiaOperador.class, gtin);
    }
}
