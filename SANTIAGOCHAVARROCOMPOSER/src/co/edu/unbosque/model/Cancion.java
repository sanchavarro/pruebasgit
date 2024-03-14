package co.edu.unbosque.model;

import java.io.*;
import java.util.Random;
import javax.swing.*;
import co.edu.unbosque.model.persistence.PropiedadesCancion;

public class Cancion {
    private PropiedadesCancion files = new PropiedadesCancion();
    private String[] sustantivos = new String[]{"mami", "bebe", "princesa", "bandida", "loquilla"};
    private String[] sujetos = new String[]{" te quiero ", "yo puedo ", "yo vengo a ", "voy a "};
    private String[] verbos = new String[]{"prenderla", "encenderla", "amarte", "ligar", "jugar"};
    private String[] adjetivos = new String[]{"suave", "lento", "rápido", "fuerte"};
    private String[] tiempo = new String[]{"hasta el amanecer", "toda la noche", "hasta que salga el sol", "todo el día"};
    private String[] descriptivos = new String[]{"sin anestesia", "sin compromiso", "cara a cara", "sin miedo"};

    private String cancion = " ";

    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                int numeroEstrofas = pedirNumeroEstrofas();
                int frasesPorEstrofa = pedirFrasePorEstrofa();
                generarCancion(numeroEstrofas, frasesPorEstrofa);
                break;
            case 2:
                mostrarCancionGenerada(); // Muestra la canción generada primero
                preguntarGuardarCancion(); // Luego pregunta si se desea guardar
                break;
            case 3:
                abrirCancion();
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Saliendo del programa.", "Salir",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    private int pedirNumeroEstrofas() {
        String input = JOptionPane.showInputDialog(null, "Seleccione la cantidad de estrofas:", "Ingrese un número", JOptionPane.QUESTION_MESSAGE);

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    private int pedirFrasePorEstrofa() {
        String input = JOptionPane.showInputDialog(null, "Ingrese la cantidad de frases por estrofa:", "Ingrese un número", JOptionPane.QUESTION_MESSAGE);

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public void generarCancion(int estrofas, int frasesPorEstrofa) {
        cancion = "";
        for (int j = 0; j < estrofas; j++) {
            for (int k = 0; k < frasesPorEstrofa; k++) {
                cancion += sustantivos[new Random().nextInt(sustantivos.length)] + " " +
                        sujetos[new Random().nextInt(sujetos.length)] + "" +
                        verbos[new Random().nextInt(verbos.length)] + " " +
                        adjetivos[new Random().nextInt(adjetivos.length)] + " " +
                        tiempo[new Random().nextInt(tiempo.length)] + " " +
                        descriptivos[new Random().nextInt(descriptivos.length)] + "\n";
            }
            cancion += "\n";
        }
    }

    public void mostrarCancionGenerada() {
        JOptionPane.showMessageDialog(null, cancion, "Canción Generada", JOptionPane.INFORMATION_MESSAGE);
    }

    public void preguntarGuardarCancion() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea guardar la canción?", "Guardar Canción", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            guardarCancion();
        } else {
            JOptionPane.showMessageDialog(null, "Saliendo del programa.", "Salir", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void guardarCancion() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoGuardar = fileChooser.getSelectedFile();
            guardarCancionEnArchivo(archivoGuardar);
            mostrarMensajeExito(archivoGuardar.getAbsolutePath());
        }
    }

    public void guardarCancionEnArchivo(File rutaArchivo) {
        if (rutaArchivo != null) {
            try (FileWriter writer = new FileWriter(rutaArchivo)) {
                writer.write(cancion);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostrarMensajeExito(String rutaArchivo) {
        JOptionPane.showMessageDialog(null, "La canción se ha guardado exitosamente en: " + rutaArchivo,
                "Guardado exitoso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void abrirCancion() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoCancion = fileChooser.getSelectedFile();
            mostrarCancion(archivoCancion);
        }
    }

    public void mostrarCancion(File archivoCancion) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCancion))) {
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            JOptionPane.showMessageDialog(null, contenido.toString(), "Canción", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo de canción.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


