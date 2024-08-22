package co.com.grupoexito.octopia.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.PageObjects;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://seller.octopia.com/external-login")
public class PaginaInicioOctopiaVendedores extends PageObject {

    public static final Target CAMPO_USUARIO_PORTAL_VENDEDORES = Target.the("Ingrese el usuario").located(By.id("username"));
    public static final Target CAMPO_CONTRASENA_PORTAL_VENDEDORES = Target.the("Ingrese la contraseña").located(By.id("password"));
    public static final Target BOTON_INICIAR_SESION_PORTAL_VENDEDORES = Target.the("Inicie sesión").located(By.name("login"));
    public static final Target ACEPTAR_COOKIES_PORTAL_VENDEDORES = Target.the("Seleccione aceptar cookies").located(By.id("footer_tc_privacy_button_2"));
    public static final Target MENU_PRODUCTOS_PORTAL_VENDEDORES = Target.the("Seleccionar menú productos").locatedBy("//a[@class='dropdown-toggle' and contains(text(),'Productos')]");
    public static final Target CONSULTAR_SUS_PRODUCTOS_PORTAL_VENDEDORES = Target.the("Enlace para consultar sus productos")
            .locatedBy("//a[@class='menu-link' and contains(text(),'Consultar sus productos')]");
    public static final Target ENCABEZADO_PORTAL_VENDEDORES = Target.the("Título de la tienda de venta")
            .locatedBy("//div[@class='home-title-block']//div[@class='home-title']");
    public static final Target OPCION_IDIOMA_PORTAL_VENDEDORES = Target.the("Opción de idioma - Español")
            .locatedBy("//a[@class='dropdown-toggle' and descendant::span[@class='frOn']]");
    public static final Target IDIOMA_ESPANOL_PORTAL_VENDEDORES = Target.the("Idioma Español")
            .locatedBy("//img[@alt='Español' and @title='Español']");
    public static final Target MENU_VENDER_PRODUCTO_PORTAL_VENDEDORES = Target.the("Seleccionar menú productos, vender producto").locatedBy("//a[@class='menu-link' and text()='Vender un producto']");

    public static final Target MENU_CREAR_PRODUCTOS_MASIVAMENTE_PORTAL_VENDEDORES = Target.the("Seleccionar menú Crear productos masivamente").locatedBy("#bs-navbar-collapse > ul > li.dropdown.open > ul > li:nth-child(2) > ul > li:nth-child(1) > a");

    public static final Target MENU_CONSULTAR_PRODUCTOS = Target.the("Menú consultar sus productos")
            .locatedBy("//a[@class='menu-link' and @href='/catalog/management/5hEkGb' and contains(text(),'Consultar sus productos')]");

    public static final Target MENU_VENDER_PRODUCTOS_MASIVAMENTE_PORTAL_VENDEDORES = Target.the("Seleccionar menú Vender productos masivamente").locatedBy("//a[@class='menu-link' and text()='Vender productos masivamente']");





}
