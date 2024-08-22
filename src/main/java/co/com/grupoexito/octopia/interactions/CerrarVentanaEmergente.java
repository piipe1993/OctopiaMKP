package co.com.grupoexito.octopia.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CerrarVentanaEmergente implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = actor.usingAbilityTo(BrowseTheWeb.class).getDriver();

        // Crear una instancia de Actions
        Actions actions = new Actions(driver);

        // Presionar la tecla "Esc"
        actions.sendKeys("\uE00C").perform();



    }

    public static CerrarVentanaEmergente delPopUp() {
        return instrumented(CerrarVentanaEmergente.class);
    }
}
