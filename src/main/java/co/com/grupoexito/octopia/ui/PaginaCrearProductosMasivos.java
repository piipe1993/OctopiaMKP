package co.com.grupoexito.octopia.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaCrearProductosMasivos extends PageObject {


    public static final Target ELEMENTO_API_OCTOPIA_BANNER_INFERIOR = Target.the("Elemento Banner inferior de la pagina").locatedBy("//A[@href='https://developer.octopia-io.net/'][text()='API Octopia']/self::A");
    public static final Target BOTON_EXAMINAR_CARGA_ARCHIVO_PRODUCTOS = Target.the("Botón EXAMINAR para cargar archivo productos").locatedBy("//INPUT[@accept='.xls,.xlsx,.xlsm,.xlsb']/self::INPUT");

    public static final Target BOTON_ACEPTAR_CARGA_ARCHIVO_PRODUCTOS = Target.the("Botón EXAMINAR para cargar archivo productos").located(By.name("uploadFile"));
    public static final Target BOTON_CERRAR = Target.the("Botón Cerrar")
            .locatedBy("//button[contains(text(),'Cerrar') and @data-dismiss='modal']");
}
