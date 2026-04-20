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
}