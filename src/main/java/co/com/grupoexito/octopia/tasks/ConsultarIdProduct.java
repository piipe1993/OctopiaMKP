package co.com.grupoexito.octopia.tasks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.io.File;

import static co.com.grupoexito.octopia.utils.Constantes.ID_PRODUCT_OCTOPIA;
import static co.com.grupoexito.octopia.utils.Constantes.SELLER_ID;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarIdProduct implements Task {


    private String gtin;
    private String respuestaToken;

    public ConsultarIdProduct(String gtin, String respuestaToken) {
        this.gtin = gtin;
        this.respuestaToken = respuestaToken;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {



        String accessToken = null;
        String finalAccessToken;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode respuestaNode = objectMapper.readTree(respuestaToken);
            accessToken = respuestaNode.get("access_token").asText();

            System.out.println("Valor del token: " + accessToken);

        } catch (Exception e) {
            e.printStackTrace();
        }


        finalAccessToken = accessToken;
        actor.attemptsTo(Get.resource("/products-integration-reports").with(
                requestSpecification -> requestSpecification
                        .header("Authorization", "Bearer " + finalAccessToken)
                        .header("SellerId", SELLER_ID)
                        .header("Accept-Language","es-ES")
                        .param("gtin",gtin)
        ));

        System.out.println("RESPUESTA PARA DYNAMO");
        System.out.println("STATUS CODE " + lastResponse().getStatusCode());
        System.out.println("CUERPO " + lastResponse().getBody().asString());



        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readTree(lastResponse().getBody().asString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        JsonNode itemsNode = rootNode.get("items");
        JsonNode firstItemNode = itemsNode.get(0);
        String productReference = firstItemNode.get("productReference").asText();
        System.out.println("Product Reference: " + productReference);

        actor.remember(ID_PRODUCT_OCTOPIA,productReference);

    }


    public static ConsultarIdProduct conGtin (String gtin, String respuestaToken){

        return instrumented(ConsultarIdProduct.class, gtin, respuestaToken);
    }
}
