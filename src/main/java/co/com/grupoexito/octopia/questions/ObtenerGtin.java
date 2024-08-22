package co.com.grupoexito.octopia.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.grupoexito.octopia.ui.PaginaDigitoGtin.CAJA_TEXTO_ULTIMO_DIGITO_GTIN;

public class ObtenerGtin implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        return CAJA_TEXTO_ULTIMO_DIGITO_GTIN.resolveFor(actor).getAttribute("value");
    }

    public static ObtenerGtin ultimoDigito(){

        return new ObtenerGtin();
    }
}
