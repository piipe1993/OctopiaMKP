package co.com.grupoexito.octopia.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.grupoexito.octopia.ui.PaginaInicioOctopiaVendedores.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IniciarSesionOctopiaVendedor implements Task {

    private String usuario;
    private String contrasena;

    public IniciarSesionOctopiaVendedor(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                SendKeys.of(usuario).into(CAMPO_USUARIO_PORTAL_VENDEDORES),
                SendKeys.of(contrasena).into(CAMPO_CONTRASENA_PORTAL_VENDEDORES),
                Click.on(BOTON_INICIAR_SESION_PORTAL_VENDEDORES),
                WaitUntil.the(ENCABEZADO_PORTAL_VENDEDORES, isVisible())
        );


    }

    public static IniciarSesionOctopiaVendedor conCredenciales(String usuario, String contrasena) {
        return instrumented(IniciarSesionOctopiaVendedor.class, usuario, contrasena);
    }

}
