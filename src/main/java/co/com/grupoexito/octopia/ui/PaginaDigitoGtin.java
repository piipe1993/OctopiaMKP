package co.com.grupoexito.octopia.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://www.gs1us.org/tools/check-digit-calculator")
public class PaginaDigitoGtin extends PageObject {


    public static final Target BOTON_LOGIN = Target.the("Botón de Login")
            .located(By.cssSelector("a[aria-label='Login']"));

    public static final Target CAJA_TEXTO_ID_NUMBER_GTIN = Target.the("Caja de texto ID Number del GTIN")
            .located(By.id("FormsEditField14"));

    public static final Target BOTON_CALCULAR = Target.the("Botón calcular")
            .located(By.id("FormsButton16"));

    public static final Target CAJA_TEXTO_ULTIMO_DIGITO_GTIN = Target.the("Caja de texto ID Number")
            .located(By.id("FormsEditField15"));


    public static final Target BOTON_LIMPIAR = Target.the("Botón limpiar")
            .located(By.id("FormsEditField15"));





}
