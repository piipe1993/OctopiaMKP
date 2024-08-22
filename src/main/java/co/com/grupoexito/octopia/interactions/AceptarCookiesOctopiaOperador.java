package co.com.grupoexito.octopia.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.grupoexito.octopia.ui.PaginaPrincipalOperadorOctopia.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AceptarCookiesOctopiaOperador implements Interaction {



    @Override
    public <T extends Actor> void performAs(T actor) {


        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                WaitUntil.the(BOTON_ACEPTAR_COOKIES_PORTAL_OPERADOR, isVisible()),
                Click.on(BOTON_ACEPTAR_COOKIES_PORTAL_OPERADOR).afterWaitingUntilEnabled()
        );

    }


    public static AceptarCookiesOctopiaOperador delPortal(){

        return new AceptarCookiesOctopiaOperador();
    }
}
