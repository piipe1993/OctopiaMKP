package co.com.grupoexito.octopia.tasks;

import co.com.grupoexito.octopia.models.VtexInfoProducto.ProductInformation;
import co.com.grupoexito.octopia.models.productos.ProductList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.restassured.http.ContentType;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.internal.mapping.Jackson1Mapper;
import io.restassured.internal.mapping.Jackson2Mapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.lang.reflect.Type;

import static co.com.grupoexito.octopia.utils.Constantes.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ConsultarProductoEnVtex implements Task {

    private String ambiente;
    private String eanProducto;

    public ConsultarProductoEnVtex(String eanProducto) {

        this.eanProducto = eanProducto;
    }

    public static Performable conEAN(String eanProducto) {
        return new ConsultarProductoEnVtex(eanProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Consumimos servicio VTEX- AMBIENTE EXITO para obetener información de la oferta y el producto


        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String respuestaVtexExito;
        actor.whoCan(CallAnApi.at(BASE_URL_VTEX_EXITO));
        actor.attemptsTo(Get.resource("/sku/stockkeepingunitbyean/" + eanProducto)
                .with(requestSpecification
                        -> requestSpecification.contentType(ContentType.JSON)
                        .header("X-VTEX-API-AppKey", APP_KEY_EXITO)
                        .header("X-VTEX-API-AppToken", APP_TOKEN_EXITO)
                ));

        respuestaVtexExito = lastResponse().getBody().asString();
        System.out.println("---------------------------------------------\n"+ respuestaVtexExito);

        io.restassured.mapper.ObjectMapper mapper = new Jackson2Mapper(((type, charset) -> {
            com.fasterxml.jackson.databind.ObjectMapper om = new ObjectMapper().findAndRegisterModules();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            om.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
            return om;
        }));

        ProductInformation productInformation = lastResponse().as(ProductInformation.class, (io.restassured.mapper.ObjectMapper) mapper);


        System.out.println("Body Api VTEX - Ambiente EXITO = " + productInformation);

        // Consumimos servicio VTEX- AMBIENTE CARULLA para obetener información de la oferta y el producto

        actor.whoCan(CallAnApi.at(BASE_URL_VTEX_CARULLA));
        String respuestaVtexCarulla;
        actor.attemptsTo(Get.resource("/sku/stockkeepingunitbyean/" + eanProducto)
                .with(requestSpecification
                        -> requestSpecification.contentType(ContentType.JSON)
                        .header("X-VTEX-API-AppKey", APP_KEY_CARULLA)
                        .header("X-VTEX-API-AppToken", APP_TOKEN_CARULLA)
                ));


        respuestaVtexCarulla = lastResponse().getBody().asString();
        System.out.println("Body Api VTEX - Ambiente CARULLA = " + respuestaVtexCarulla);

    }


}
