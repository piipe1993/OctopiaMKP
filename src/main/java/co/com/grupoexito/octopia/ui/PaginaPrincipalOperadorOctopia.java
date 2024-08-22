package co.com.grupoexito.octopia.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class PaginaPrincipalOperadorOctopia extends PageObject {

    public static final Target BOTON_ACEPTAR_COOKIES_PORTAL_OPERADOR = Target.the("Botón aceptar cookies").located(By.id("footer_tc_privacy_button"));
    public static final Target ENCABEZADO_PORTAL_OPERADOR = Target.the("Encabezado portal operador").located(By.id("react-admin-title"));
    public static final Target MENU_PERFIL_PORTAL_OPERADOR = Target.the("Menú perfil del usuario").located(By.cssSelector("div[data-test-id='dropdown-profil']"));
    public static final Target MENU_LENGUAJE_PORTAL_OPERADOR = Target.the("Menú lenguaje de la página").located(By.cssSelector("div[aria-label='common.language.fr']"));
    public static final Target BOTON_IDIOMA_ESPANOL_PORTAL_OPERADOR = Target.the("Seleccionar idioma español").located(By.cssSelector("li[data-test-id='es-language-item']"));
    public static final Target MENU_PRODUCTOS_PORTAL_OPERADOR = Target.the("Menú de productos").located(By.cssSelector("a[href='#/products']"));




}
