package co.com.grupoexito.octopia.exceptions;

public class MensajeExcepciones extends Exception {
    public MensajeExcepciones(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
