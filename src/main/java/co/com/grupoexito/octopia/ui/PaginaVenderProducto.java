package co.com.grupoexito.octopia.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaVenderProducto extends PageObject {

    public static final Target BARRA_BUSQUEDA_OCTOPIA_VENDEDORES = Target.the("Barra de búsqueda").located(By.id("productSearchTermInputId"));
    public static final Target BOTON_BUSQUEDA_OCTOPIA_VENDEDORES = Target.the("Botón búsqueda").located(By.id("productSearchSubmit"));
    public static final Target BOTON_VENDER_PRODUCTO_OCTOPIA_VENDEDORES = Target.the("Botón vender producto").located(By.id("btn_validate_mono"));

}
