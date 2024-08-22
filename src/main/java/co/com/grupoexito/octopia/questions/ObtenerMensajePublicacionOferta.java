package co.com.grupoexito.octopia.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.grupoexito.octopia.ui.PaginaCrearOferta.MENSAJE_EXITO_PORTAL_VENDEDORES;
import static co.com.grupoexito.octopia.ui.PaginaInicioOctopiaVendedores.ENCABEZADO_PORTAL_VENDEDORES;

public class ObtenerMensajePublicacionOferta implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        return MENSAJE_EXITO_PORTAL_VENDEDORES.resolveFor(actor).getText();
    }

    public static ObtenerMensajePublicacionOferta delElemento (){
        return new ObtenerMensajePublicacionOferta();
    }
}
