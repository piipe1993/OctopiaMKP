package co.com.grupoexito.octopia.tasks;

import co.com.grupoexito.octopia.models.productos.Product;
import co.com.grupoexito.octopia.models.productos.ProductList;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.io.File;
import java.io.IOException;

import static co.com.grupoexito.octopia.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;




public class ObtenerCamposApiProducto implements Task {

    private String rutaArchivo;

    public ObtenerCamposApiProducto(String rutaArchivo) {

        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String gtin = null;
        String referenciaProducto = null;
        File jsonFile = new File(rutaArchivo);

        ObjectMapper objectMapper = new ObjectMapper();
        ProductList productList = null;
        try {
            productList = objectMapper.readValue(jsonFile, ProductList.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Product product : productList.getProducts()) {
            gtin = String.valueOf(product.getGtin());
            referenciaProducto = String.valueOf(product.getSellerProductReference());
            System.out.println("GTIN: " + product.getGtin());
            System.out.println("Seller Product Reference: " + product.getSellerProductReference());
            break;
        }

        actor.remember(GTIN_PRODUCTO_API_PRODUCTOS, gtin);
        actor.remember(REFERENCIA_PRODUCTO_API_PRODUCTOS, referenciaProducto);

    }


    public static ObtenerCamposApiProducto delCuerpo (String rutaArchivo) {
        return instrumented(ObtenerCamposApiProducto.class, rutaArchivo);
    }
}
