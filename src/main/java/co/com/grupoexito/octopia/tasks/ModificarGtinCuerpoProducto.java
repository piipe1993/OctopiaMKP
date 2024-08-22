package co.com.grupoexito.octopia.tasks;

import co.com.grupoexito.octopia.models.productos.Product;
import co.com.grupoexito.octopia.models.productos.ProductList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static co.com.grupoexito.octopia.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;



public class ModificarGtinCuerpoProducto implements Task {

    private String rutaArchivo;
    private String tipoProducto;



    public ModificarGtinCuerpoProducto(String rutaArchivo, String tipoProducto) {
        this.rutaArchivo = rutaArchivo;
        this.tipoProducto = tipoProducto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        List<String> listaGtin = new ArrayList<>();

        listaGtin = actor.recall(LISTA_GTIN);
        long nuevoGtin = Long.parseLong(listaGtin.get(0));
        String nuevaReferenciaProducto = listaGtin.get(0); //SE ESTÁ DEJANDO LA REFERENCIA DEL PRODUCTO IGUAL QUE EL GTIN
        String nuevaReferenciaGtin = listaGtin.get(0); //SE ESTÁ DEJANDO LA REFERENCIA DEL GTIN IGUAL QUE EL GTIN


        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(rutaArchivo));


            JsonNode productsNode = rootNode.path("products");
            if (productsNode.isArray() && productsNode.size() > 0) {
                JsonNode primerProducto = productsNode.get(0);
                if (primerProducto.has("gtin")) {
                    ((ObjectNode) primerProducto).put("gtin", nuevoGtin);
                } else {
                    System.out.println("EL CAMPO 'gtin' NO EXISTE EN EL PRIMER PRODUCTO.");
                    return;
                }
            } else {
                System.out.println("NO SE ENCONTRARON PRODUCTOS EN EL JSON.");
                return;
            }


            JsonNode sellerProductReferenceNode = rootNode
                    .path("products")
                    .get(0)
                    .path("sellerProductReference");

            if (sellerProductReferenceNode.isTextual()) {
                ((ObjectNode) rootNode.path("products").get(0)).put("sellerProductReference", nuevaReferenciaProducto);
            } else {
                System.out.println("EL CAMPO 'sellerProductReference' NO ES DE TIPO TEXTO.");
                return;
            }



            if(tipoProducto.equals("Variante")){
                if (productsNode.isArray() && productsNode.size() > 0) {
                    JsonNode gtinReferenceNode = productsNode.get(0);
                    if (gtinReferenceNode.has("gtinReference")) {
                        ((ObjectNode) gtinReferenceNode).put("gtinReference", nuevaReferenciaGtin);
                    } else {
                        System.out.println("EL CAMPO 'gtin' NO EXISTE EN EL PRIMER PRODUCTO.");
                        return;
                    }
                } else {
                    System.out.println("NO SE ENCONTRARON PRODUCTOS EN EL JSON.");
                    return;
                }
            }




            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
            objectWriter.writeValue(new File(rutaArchivo), rootNode);

            System.out.println("Se ha actualizado el valor de 'gtin' en el archivo JSON.");

        } catch (IOException e) {
            e.printStackTrace();
        }





    }


    public static ModificarGtinCuerpoProducto conElGtin (String rutaArchivo, String tipoProducto){
        return instrumented(ModificarGtinCuerpoProducto.class, rutaArchivo, tipoProducto);
    }
}
