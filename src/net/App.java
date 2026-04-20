package net;

import javax.swing.JOptionPane;

import net.salesianos.entradaDatos.EntradaDatos;
import net.salesianos.lista.Lista;
import net.salesianos.restaurante.Restaurante;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public static void anadirRestaurante(Lista service) {
        String nombre = EntradaDatos.pedirTexto("Introduce el nombre del restaurante:");
        String ciudad = EntradaDatos.pedirTexto("Introduce la ciudad:");
        String tipoCocina = EntradaDatos.pedirTexto("Introduce el tipo de cocina:");
        int puntuacion = EntradaDatos.pedirPuntuacion("Introduce la puntuación (1-5):");

        Restaurante restaurante = new Restaurante(nombre, ciudad, tipoCocina, puntuacion);
        service.anadir(restaurante);

        JOptionPane.showMessageDialog(null, "Restaurante añadido correctamente.");
    }
}
