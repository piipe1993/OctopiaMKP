package co.com.grupoexito.octopia.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://auth.octopia.com/auth/realms/maas/protocol/openid-connect/auth?client_id=INTERNATIONAL-SALES-CHANNEL_SALES-CHANNEL-BACK-OFFICE&redirect_uri=https%3A%2F%2Foperator.octopia.com%2F%23%2Forders&state=9b1a64f7-a597-4691-9730-997456b4f2ed&response_mode=fragment&response_type=code&scope=openid&nonce=46bd2879-a966-4501-b492-b1d98cadc538&code_challenge=PODgsBJtnvI9UtSamBQmT0xbgO35dU4dwbNYox1IfCo&code_challenge_method=S256")

public class PaginaInicioOperadorOctopia extends PageObject {

    public static final Target CAMPO_USUARIO_PORTAL_OPERADOR = Target.the("Ingrese el usuario").located(By.id("username"));
    public static final Target CAMPO_CONTRASENA_PORTAL_OPERADOR = Target.the("Ingrese la contraseña").located(By.id("password"));
    public static final Target BOTON_INICIAR_SESION_PORTAL_OPERADOR = Target.the("Inicie sesión").located(By.name("login"));
}
