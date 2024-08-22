package co.com.grupoexito.octopia.models;

import co.com.grupoexito.octopia.exceptions.MensajeExcepciones;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Credenciales {

    private Properties properties;

    public Credenciales(String rutaCredenciales) throws MensajeExcepciones {
        properties = new Properties();
        cargarPropiedades(rutaCredenciales);
    }

    private void cargarPropiedades(String rutaCredenciales) throws MensajeExcepciones {
        try (FileInputStream input = new FileInputStream(rutaCredenciales);
             InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8)) {
            properties.load(reader);


        } catch (IOException e) {
            throw new MensajeExcepciones("Archivo no encontrado" + rutaCredenciales, e);

        }
    }

    public String getProperty(String rutaPropiedades) {
        return properties.getProperty(rutaPropiedades);
    }
}
