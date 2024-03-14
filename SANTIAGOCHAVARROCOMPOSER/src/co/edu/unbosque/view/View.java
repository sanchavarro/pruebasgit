package co.edu.unbosque.view;

import javax.swing.JOptionPane;
import co.edu.unbosque.model.Cancion;

public class View {

    public void mostrarMenu(Cancion cancion) {
        int opcion;
        do {
            String input = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:\n1. definir parametros \n2. crear cancion.\n3. leer cancion.\n4.salir",
                    "Menú", JOptionPane.QUESTION_MESSAGE);
            try {
                opcion = Integer.parseInt(input);
                if (opcion >= 1 && opcion <= 4) { 
                    cancion.ejecutarOpcion(opcion);
                } else {
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                opcion = 0;
            }
        } while (opcion != 4); 
    }
}
    

	

