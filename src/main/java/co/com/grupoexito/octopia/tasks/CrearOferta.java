package co.com.grupoexito.octopia.tasks;

import co.com.grupoexito.octopia.interactions.SeleccionarProducto;
import co.com.grupoexito.octopia.questions.ObtenerMensajePublicacionOferta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.grupoexito.octopia.ui.PaginaCrearOferta.*;
import static co.com.grupoexito.octopia.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearOferta implements Task {



    private String gtin;
    private String referencia;

    public CrearOferta(String gtin, String referencia) {
        this.gtin = gtin;
        this.referencia = referencia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String mensajeExito;

        actor.attemptsTo(
                SeleccionarProducto.paraLaOferta(gtin),
                WaitUntil.the(CAMPO_REFERENCIA_PORTAL_VENDEDORES, isVisible()),
                SendKeys.of(referencia).into(CAMPO_REFERENCIA_PORTAL_VENDEDORES),
                SendKeys.of(INVENTARIO_DISPONIBLE).into(CAMPO_INVENTARIO_DISPONIBLE_PORTAL_VENDEDORES),
                SendKeys.of(PRECIO_PRODUCTO).into(CAMPO_PRECIO_PORTAL_VENDEDORES),
                SendKeys.of(PRECIO_TACHADO).into(CAMPO_PRECIO_TACHADO_PORTAL_VENDEDORES),
                SendKeys.of(DESCRIPCION).into(CAMPO_COMENTARIOS_PORTAL_VENDEDORES),
                SendKeys.of(GASTOS_ENTREGA_THD).into(CAMPO_SEGUIMIENTO_GASTOS_PORTAL_VENDEDORES),
                SendKeys.of(GASTOS_ENTREGA_COMPLEMENTARIOS_THD).into(CAMPO_SEGUIMIENTO_GASTOS_COMPLEMENTARIOS_PORTAL_VENDEDORES),
                SendKeys.of(GASTOS_ENTREGA_SHD).into(CAMPO_CERTIFICADO_GASTOS_PORTAL_VENDEDORES),
                SendKeys.of(GASTOS_ENTREGA_COMPLEMENTARIOS_SHD).into(CAMPO_CERTIFICADO_GASTOS_COMPLEMENTARIOS_PORTAL_VENDEDORES),
                SendKeys.of(PLAZO_PREPARACION).into(CAMPO_PLAZO_PREPARACION_PORTAL_VENDEDORES),
                Click.on(BOTON_PUBLICAR_OFERTA_PORTAL_VENDEDORES),
                WaitUntil.the(MENSAJE_EXITO_PORTAL_VENDEDORES, isVisible())

        );


//        String mensajeExito = actor.asksFor(Text.of(MENSAJE_EXITO_PORTAL_VENDEDORES).asString());
        mensajeExito = actor.asksFor(ObtenerMensajePublicacionOferta.delElemento());
        System.out.println("MENSAJE EXITO " + mensajeExito);

        actor.attemptsTo(
                Click.on(BOTON_CERRAR_OFERTA_PORTAL_VENDEDORES)
        );



    }

    public static CrearOferta conInformacionProducto (String gtin, String referencia) {

        return instrumented(CrearOferta.class, gtin, referencia);
    }
}
