package net.salesianos.entradaDatos;

import javax.swing.JOptionPane;

public class EntradaDatos {

    public static String pedirTexto(String mensaje) {
        String texto;
        do {
            texto = JOptionPane.showInputDialog(null, mensaje);
            if (texto == null) {
                JOptionPane.showMessageDialog(null, "No puedes cancelar aquí.");
            } else {
                texto = texto.trim();
            }
        } while (texto == null || texto.isEmpty());
        return texto;
    }
    public static int pedirEntero(String mensaje) {
        while (true) {
            try {
                String dato = JOptionPane.showInputDialog(null, mensaje);
                if (dato == null) {
                    JOptionPane.showMessageDialog(null, "No puedes cancelar aquí.");
                    continue;
                }
                return Integer.parseInt(dato);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes escribir un número entero.");
            }
        }
    }
    public static int pedirPuntuacion(String mensaje) {
        int puntuacion;
        do {
            puntuacion = pedirEntero(mensaje);
            if (puntuacion < 1 || puntuacion > 5) {
                JOptionPane.showMessageDialog(null, "La puntuación debe estar entre 1 y 5.");
            }
        } while (puntuacion < 1 || puntuacion > 5);
        return puntuacion;
    }
}
