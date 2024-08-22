package co.com.grupoexito.octopia.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

import static co.com.grupoexito.octopia.ui.PaginaInicioOperadorOctopia.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesionOctopiaOperador implements Task {

    private String usuario;
    private String contrasena;




    public IniciarSesionOctopiaOperador(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SendKeys.of(usuario).into(CAMPO_USUARIO_PORTAL_OPERADOR),
                SendKeys.of(contrasena).into(CAMPO_CONTRASENA_PORTAL_OPERADOR),
                Click.on(BOTON_INICIAR_SESION_PORTAL_OPERADOR));

    }



    public static IniciarSesionOctopiaOperador conCredenciales (String usuario, String contrasena){
        return instrumented(IniciarSesionOctopiaOperador.class,usuario,contrasena);
    }
}
