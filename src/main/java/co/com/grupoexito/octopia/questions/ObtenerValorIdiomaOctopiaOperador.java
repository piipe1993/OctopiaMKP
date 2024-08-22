package co.com.grupoexito.octopia.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.grupoexito.octopia.ui.PaginaPrincipalOperadorOctopia.ENCABEZADO_PORTAL_OPERADOR;

public class ObtenerValorIdiomaOctopiaOperador implements Question<String> {



    @Override
    public String answeredBy(Actor actor) {
        return ENCABEZADO_PORTAL_OPERADOR.resolveFor(actor).getText();
    }


    public static ObtenerValorIdiomaOctopiaOperador delElemento() {

        return new ObtenerValorIdiomaOctopiaOperador();
    }
}
