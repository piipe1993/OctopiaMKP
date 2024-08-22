package co.com.grupoexito.octopia.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.grupoexito.octopia.ui.PaginaInicioOctopiaVendedores.ACEPTAR_COOKIES_PORTAL_VENDEDORES;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AceptarCookiesOctopiaVendedores implements Interaction {



    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                WaitUntil.the(ACEPTAR_COOKIES_PORTAL_VENDEDORES, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ACEPTAR_COOKIES_PORTAL_VENDEDORES)
        );
    }


    public static Performable delPortalOctopia (){

        return new AceptarCookiesOctopiaVendedores();
    }
}
