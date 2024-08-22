package co.com.grupoexito.octopia.tasks;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.json.simple.JSONObject;

import java.io.File;

import static co.com.grupoexito.octopia.utils.Constantes.SELLER_ID;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class CrearProducto implements Task {

    private String respuestaToken;
    private String rutaArchivo;


    public CrearProducto(String respuestaToken, String rutaArchivo) {
        this.respuestaToken = respuestaToken;
        this.rutaArchivo = rutaArchivo;
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

        File cuerpoCrearProducto = new File(rutaArchivo);

        finalAccessToken = accessToken;
        actor.attemptsTo(Post.to("/products-integration").with(
                requestSpecification -> requestSpecification
                        .header("Authorization", "Bearer " + finalAccessToken)
                        .header("SellerId", SELLER_ID)
                        .header("Accept-Language","es-ES")
                        .body(cuerpoCrearProducto)));


        System.out.println("STATUS CODE " + lastResponse().getStatusCode());
        System.out.println("CUERPO " + lastResponse().getBody().asString());


    }

    public static CrearProducto conElToken(String respuestaToken, String rutaArchivo) {

        return instrumented(CrearProducto.class, respuestaToken, rutaArchivo);
    }

}
