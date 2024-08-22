package co.com.grupoexito.octopia.interactions;

import com.amazonaws.services.kafkaconnect.model.ScaleOutPolicy;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;


import static co.com.grupoexito.octopia.utils.Constantes.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarGtin implements Interaction {

    private String respuestaToken;
    private String gtin;



    public ConsultarGtin(String respuestaToken, String gtin) {
        this.respuestaToken = respuestaToken;
        this.gtin = gtin;
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
                        .param("gtin", gtin)
                        ));


        System.out.println("STATUS CODE " + lastResponse().getStatusCode());
        System.out.println("CUERPO " + lastResponse().getBody().asString());

        actor.remember(RESPUESTA_GTIN_API_PRODUCTOS,lastResponse().getBody().asString());


    }

    public static ConsultarGtin enApiProductos (String respuestaToken, String gtin){

        return instrumented(ConsultarGtin.class,respuestaToken,gtin);
    }
}
