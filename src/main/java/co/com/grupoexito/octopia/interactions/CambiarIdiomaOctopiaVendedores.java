package co.com.grupoexito.octopia.interactions;

import co.com.grupoexito.octopia.questions.ObtenerValorIdiomaOctopiaVendedores;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.grupoexito.octopia.ui.PaginaInicioOctopiaVendedores.IDIOMA_ESPANOL_PORTAL_VENDEDORES;
import static co.com.grupoexito.octopia.ui.PaginaInicioOctopiaVendedores.OPCION_IDIOMA_PORTAL_VENDEDORES;

public class CambiarIdiomaOctopiaVendedores implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {


        //String prueba = actor.asksFor(Text.of(ENCABEZADO_OCTOPIA_VENDEDORES).asString());
        //System.out.println("PRUEBA" + prueba);
        String valorEncabezado = actor.asksFor(ObtenerValorIdiomaOctopiaVendedores.delElemento());
        System.out.println("El valor del idioma es: " + valorEncabezado);

        if (!valorEncabezado.equals("Su tienda de venta")) {
            actor.attemptsTo(
                    Click.on(OPCION_IDIOMA_PORTAL_VENDEDORES),
                    Click.on(IDIOMA_ESPANOL_PORTAL_VENDEDORES)
            );
        }



    }


    public static Performable aEspanol() {

        return new CambiarIdiomaOctopiaVendedores();
    }
}
