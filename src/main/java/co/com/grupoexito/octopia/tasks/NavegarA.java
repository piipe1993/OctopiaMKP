package co.com.grupoexito.octopia.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavegarA implements Task {

    private PageObject paginaInicio;

    public NavegarA(PageObject paginaInicio) {

        this.paginaInicio = paginaInicio;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                Open.browserOn().the(paginaInicio));
    }


    public static NavegarA laPagina(PageObject paginaInicio) {

        return instrumented(NavegarA.class, paginaInicio);
    }
}
