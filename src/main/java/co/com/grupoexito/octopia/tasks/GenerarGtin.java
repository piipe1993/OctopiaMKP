package co.com.grupoexito.octopia.tasks;

import co.com.grupoexito.octopia.interactions.CerrarVentanaEmergente;
import co.com.grupoexito.octopia.interactions.ConsultarGtin;
import co.com.grupoexito.octopia.interactions.GenerarCodigoGtin;
import co.com.grupoexito.octopia.questions.ObtenerGtin;
import co.com.grupoexito.octopia.questions.ObtenerValorCampo;
import co.com.grupoexito.octopia.ui.PaginaDigitoGtin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static co.com.grupoexito.octopia.ui.PaginaDigitoGtin.BOTON_LOGIN;
import static co.com.grupoexito.octopia.ui.PaginaDigitoGtin.*;
import static co.com.grupoexito.octopia.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GenerarGtin implements Task {

    private WebDriver browser;
    private String respuestaToken;
    private int cantidadGtin;

    public GenerarGtin(WebDriver browser, String respuestaToken, int cantidadGtin) {
        this.browser = browser;
        this.respuestaToken = respuestaToken;
        this.cantidadGtin = cantidadGtin;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {


        String codigo;
        String ultimoDigito;
        String gtin;
        Long gtinNumerico;
        String respuestaApiProductos;
        List<String> listaGtin = new ArrayList<>();
        PaginaDigitoGtin paginaGtin = new PaginaDigitoGtin();


        browser.manage().window().maximize();

        actor.can(
                BrowseTheWeb.with(browser)
        );

        for (int i = 0 ; i<cantidadGtin; i++){

            do{

                actor.attemptsTo(
                        GenerarCodigoGtin.aleatoriamente());

                codigo = actor.recall(CODIGO_ALEATORIO);
                System.out.println("ESTE ES EL CODIGO " + codigo);

                actor.attemptsTo(
                        NavegarA.laPagina(paginaGtin),
                        WaitUntil.the(BOTON_LOGIN, isVisible()),
                        Scroll.to(CAJA_TEXTO_ID_NUMBER_GTIN),
                        SendKeys.of(codigo).into(CAJA_TEXTO_ID_NUMBER_GTIN),
                        Click.on(BOTON_CALCULAR)
                );

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                actor.attemptsTo(
                        CerrarVentanaEmergente.delPopUp(),
                        CerrarVentanaEmergente.delPopUp());


                ultimoDigito = actor.asksFor(ObtenerGtin.ultimoDigito());
                System.out.println("ESTE ES EL ULTIMO DIGITO: " + ultimoDigito);
                gtin = codigo + ultimoDigito;
//                gtinNumerico = Long.parseLong(gtin);
                actor.attemptsTo(
                        ConsultarGtin.enApiProductos(respuestaToken,gtin));

                respuestaApiProductos = actor.recall(RESPUESTA_GTIN_API_PRODUCTOS);

            } while (!respuestaApiProductos.equals("{\"itemsPerPage\":0,\"items\":[]}"));

            listaGtin.add(gtin);
        }

        System.out.println("LA LISTA DE GTINES ES: " + listaGtin);

        actor.remember(LISTA_GTIN,listaGtin);


    }

    public static GenerarGtin conElDigito(WebDriver browser, String respuestaToken, int cantidadGtin) {

        return instrumented(GenerarGtin.class, browser, respuestaToken, cantidadGtin);
    }
}
