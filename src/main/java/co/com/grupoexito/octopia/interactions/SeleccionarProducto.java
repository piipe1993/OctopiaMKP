package co.com.grupoexito.octopia.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.grupoexito.octopia.ui.PaginaVenderProducto.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarProducto implements Interaction {


    private String gtin;


    public SeleccionarProducto(String gtin) {

        this.gtin = gtin;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BARRA_BUSQUEDA_OCTOPIA_VENDEDORES, isVisible()),
                SendKeys.of(gtin).into(BARRA_BUSQUEDA_OCTOPIA_VENDEDORES),
                Click.on(BOTON_BUSQUEDA_OCTOPIA_VENDEDORES),
                WaitUntil.the(BOTON_VENDER_PRODUCTO_OCTOPIA_VENDEDORES, isVisible()),
                Click.on(BOTON_VENDER_PRODUCTO_OCTOPIA_VENDEDORES)
        );


    }

    public static SeleccionarProducto paraLaOferta (String gtin){

        return instrumented(SeleccionarProducto.class, gtin);
    }
}
