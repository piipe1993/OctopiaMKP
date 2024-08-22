package co.com.grupoexito.octopia.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.grupoexito.octopia.ui.PaginaInicioOctopiaVendedores.ENCABEZADO_PORTAL_VENDEDORES;

public class ObtenerValorIdiomaOctopiaVendedores implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        return ENCABEZADO_PORTAL_VENDEDORES.resolveFor(actor).getText();
    }

    public static ObtenerValorIdiomaOctopiaVendedores delElemento() {
        return new ObtenerValorIdiomaOctopiaVendedores();
    }
}
