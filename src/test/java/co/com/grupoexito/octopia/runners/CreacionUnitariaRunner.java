package co.com.grupoexito.octopia.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/CreacionUnitaria.feature",
        glue = "co/com/grupoexito/octopia/stepDefinitions",
        tags = "@CreacionOfertaUnitaria",
        publish = false
)
public class CreacionUnitariaRunner {
}

