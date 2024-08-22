package co.com.grupoexito.octopia.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.Random;

import static co.com.grupoexito.octopia.utils.Constantes.CODIGO_ALEATORIO;

public class GenerarCodigoGtin implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {


        int numeroAleatorio;


        StringBuilder codigo = new StringBuilder(12);
        Random random = new Random();
        int primerDigito = random.nextInt(9) + 1;
        codigo.append(primerDigito);

        for (int i = 1; i < 12; i++) {
            numeroAleatorio = (int) Math.floor(Math.random()*10);
            codigo.append(numeroAleatorio);
        }

        actor.remember(CODIGO_ALEATORIO, codigo.toString());

    }


    public static Performable aleatoriamente (){
        return new GenerarCodigoGtin();
    }
}
