package co.com.grupoexito.octopia.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObtenerValorCampo implements Question<String> {

    private final Target target;

    public ObtenerValorCampo(Target target) {
        this.target = target;
    }

    public static ObtenerValorCampo delCampo(Target target) {
        return new ObtenerValorCampo(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        WebDriver driver = actor.usingAbilityTo(BrowseTheWeb.class).getDriver();
        return target.resolveFor(actor).getAttribute("value");
    }
}
