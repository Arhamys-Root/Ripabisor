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
    public static void mostrarRestaurantes(Lista service) {
        if (service.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay restaurantes guardados.");
            return;
        }

        service.ordenarPorPuntuacionDesc();

        StringBuilder sb = new StringBuilder("LISTA DE RESTAURANTES\n\n");

        for (int i = 0; i < service.getLista().size(); i++) {
            sb.append("ÍNDICE: ").append(i).append("\n");
            sb.append(service.getLista().get(i).toString()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
        public static void eliminarRestaurante(Lista service) {
        if (service.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay restaurantes para eliminar.");
            return;
        }

        mostrarRestaurantes(service);

        int indice = EntradaDatos.pedirEntero("Introduce el índice del restaurante a eliminar:");

        if (indice < 0 || indice >= service.getLista().size()) {
            JOptionPane.showMessageDialog(null, "Índice no válido.");
            return;
        }

        service.eliminar(indice);
        JOptionPane.showMessageDialog(null, "Restaurante eliminado correctamente.");
    }
}
