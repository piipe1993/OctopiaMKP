package co.com.grupoexito.octopia.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class PaginaProductosOperadorOctopia extends PageObject {

    public static final Target BARRA_BUSCAR_PRODUCTOS_PORTAL_OPERADOR = Target.the("Barra para buscar productos").located(By.cssSelector("input[placeholder='Buscar por identificador o GTIN']"));
    public static final Target BOTON_BUSCAR_PRODUCTOS_PORTAL_OPERADOR = Target.the("Botón buscar productos").located(By.cssSelector("button[data-test-id='submit-button-searchbar']"));
    public static final Target BOTON_ACEPTAR_PRODUCTOS_PORTAL_OPERADOR = Target.the("Botón aceptar productos").located(By.cssSelector("button[data-test-id='product-action-iconButton-ACCEPTED']"));
}
