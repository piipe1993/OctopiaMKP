package co.com.grupoexito.octopia.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class PaginaProductosOctopiaVendedores extends PageObject {

    public static final Target CATALOGO_PRODUCTOS_PORTAL_VENDEDORES = Target.the("Catalogo Productos").located(org.openqa.selenium.By.id("stockManagementMainContentLines"));
    public static final Target CAMPO_BUSQUEDA_PRODUCTOS_PORTAL_OCTOPIA = Target.the("Barra de búsqueda GTIN del producto").located(By.name("SearchBox.SearchTerm"));
    public static final Target BOTON_BUSCAR_PRODUCTOS_PORTAL_OCTOPIA = Target.the("Barra de búsqueda GTIN del producto").located(By.id("id_1__"));


    public static final Target ESTADO_OFERTA = Target.the("Estado de la oferta")
            .located(By.xpath("//td[@class='tNorm hidden-xs']/span[contains(@id, 'offerStateId')]"));


    public static final Target SUBESTADO_OFERTA = Target.the("Estado de la oferta")
            .located(By.xpath("//td[@class='tNorm hidden-xs']/span[contains(@id, 'salesChannelstatus')]"));

}


