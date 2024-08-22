package co.com.grupoexito.octopia.interactions;

import co.com.grupoexito.octopia.questions.ObtenerValorIdiomaOctopiaOperador;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.grupoexito.octopia.ui.PaginaPrincipalOperadorOctopia.*;

public class CambiarIdiomaOctopiaOperador implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {


        String valorEncabezado = actor.asksFor(ObtenerValorIdiomaOctopiaOperador.delElemento());
        System.out.println("El valor del idioma es: " + valorEncabezado);

        if (!valorEncabezado.equals("Pedidos")) {
            actor.attemptsTo(
                    Click.on(MENU_PERFIL_PORTAL_OPERADOR),
                    Click.on(MENU_LENGUAJE_PORTAL_OPERADOR).afterWaitingUntilEnabled(),
                    Click.on(BOTON_IDIOMA_ESPANOL_PORTAL_OPERADOR)
            );
        }
    }

    public static Performable aEspanol(){
        return new CambiarIdiomaOctopiaOperador();
    }
}
