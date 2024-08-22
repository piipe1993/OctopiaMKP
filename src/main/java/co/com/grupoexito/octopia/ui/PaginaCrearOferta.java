package co.com.grupoexito.octopia.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaCrearOferta extends PageObject {

    public static final Target CAMPO_REFERENCIA_PORTAL_VENDEDORES = Target.the("Ingrese la referencia del producto").located(By.id("SellerProductId"));
    public static final Target CAMPO_INVENTARIO_DISPONIBLE_PORTAL_VENDEDORES = Target.the("Ingrese el inventario disponible").located(By.id("OfferQuantity"));
    public static final Target CAMPO_PRECIO_PORTAL_VENDEDORES = Target.the("Ingrese el precio").located(By.id("OfferPriceName"));
    public static final Target CAMPO_PRECIO_TACHADO_PORTAL_VENDEDORES = Target.the("Ingrese el precio tachado").located(By.id("OfferStrikedPrice"));
    public static final Target CAMPO_COMENTARIOS_PORTAL_VENDEDORES = Target.the("Ingrese los comentarios").located(By.id("Comments"));
    public static final Target CAMPO_SEGUIMIENTO_GASTOS_PORTAL_VENDEDORES = Target.the("Ingrese los gastos de entrega THD").located(By.id("TRK_ShippingFee"));
    public static final Target CAMPO_SEGUIMIENTO_GASTOS_COMPLEMENTARIOS_PORTAL_VENDEDORES = Target.the("Ingrese los gastos de entrega complementarios THD").located(By.id("TRK_AddedShippingFee"));
    public static final Target CAMPO_CERTIFICADO_GASTOS_PORTAL_VENDEDORES = Target.the("Ingrese los gastos de entrega SHD").located(By.id("REG_ShippingFee"));
    public static final Target CAMPO_CERTIFICADO_GASTOS_COMPLEMENTARIOS_PORTAL_VENDEDORES = Target.the("Ingrese los gastos de entrega complementarios SHD").located(By.id("REG_AddedShippingFee"));
    public static final Target CAMPO_PLAZO_PREPARACION_PORTAL_VENDEDORES = Target.the("Ingrese los días de plazo de preparación").located(By.name("PreparationTime"));
    public static final Target BOTON_PUBLICAR_OFERTA_PORTAL_VENDEDORES = Target.the("Seleccione publicar oferta").located(By.id("js-AddOffer"));
    public static final Target MENSAJE_EXITO_PORTAL_VENDEDORES = Target.the("Mensaje de exito")
            .locatedBy("//div[@class='modal-content']//p[contains(text(),'La oferta se publica con éxito.')]");
    public static final Target BOTON_CERRAR_OFERTA_PORTAL_VENDEDORES = Target.the("Botón para cerrar el pop up de publicación de oferta").locatedBy("//*[@id=\"publishSuccesPopin\"]/div/div/div[3]/a");


}
