package co.com.grupoexito.octopia.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.grupoexito.octopia.utils.Constantes.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ObtenerToken implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        String respuestaToken;
        actor.attemptsTo(Post.to("/auth/realms/maas/protocol/openid-connect/token").with(
                requestSpecification -> requestSpecification
                        .contentType(ContentType.URLENC)
                        .formParam("client_id", CLIENT_ID_API_PRODUCTOS)
                        .formParam("client_secret", CLIENT_SECRET_API_PRODUCTOS)
                        .formParam("grant_type", GRANT_TYPE_API_PRODUCTOS)

        ));

        respuestaToken = lastResponse().getBody().asString();
        System.out.println(respuestaToken);

    }

    public static Performable conCredenciales() {

        return new ObtenerToken();
    }
}
