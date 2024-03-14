package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Propiedades {

    private static final String PROPERTIES_FILE = "config.properties";

    public void guardarParametros(int estrofas, int frases) {
        Properties properties = new Properties();
        try (OutputStream output = new FileOutputStream(PROPERTIES_FILE)) {
            properties.setProperty("estrofas", String.valueOf(estrofas));
            properties.setProperty("frases", String.valueOf(frases));
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] leerParametros() {
        Properties properties = new Properties();
        int[] parametros = new int[2];
        try (InputStream input = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(input);
            parametros[0] = Integer.parseInt(properties.getProperty("estrofas", "0"));
            parametros[1] = Integer.parseInt(properties.getProperty("frases", "0"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parametros;
    }
}
