package net;

import javax.swing.JOptionPane;

import net.salesianos.entradaDatos.EntradaDatos;
import net.salesianos.lista.Lista;
import net.salesianos.restaurante.Restaurante;

public class App {
    public static void main(String[] args) throws Exception {
        Lista service = new Lista();
        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    null,
                    "1. Añadir restaurante\n" +
                    "2. Editar restaurante\n" +
                    "3. Mostrar restaurantes\n" +
                    "4. Eliminar restaurante\n" +
                    "5. Salir\n\n" +
                    "Elige una opción:"
            );

            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "Debes salir desde la opción 5.");
                continue;
            }

            switch (opcion) {
                case "1":
                    anadirRestaurante(service);
                    break;
                case "2":
                    editarRestaurante(service);
                    break;
                case "3":
                    mostrarRestaurantes(service);
                    break;
                case "4":
                    eliminarRestaurante(service);
                    break;
                case "5":
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
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




    public static void editarRestaurante(Lista service) {
        if (service.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay restaurantes para editar.");
            return;
        }

        mostrarRestaurantes(service);

        int indice = EntradaDatos.pedirEntero("Introduce el índice del restaurante a editar:");

        if (indice < 0 || indice >= service.getLista().size()) {
            JOptionPane.showMessageDialog(null, "Índice no válido.");
            return;
        }

        Restaurante r = service.obtener(indice);

        String nombre = EntradaDatos.pedirTexto("Nuevo nombre:");
        String ciudad = EntradaDatos.pedirTexto("Nueva ciudad:");
        String tipoCocina = EntradaDatos.pedirTexto("Nuevo tipo de cocina:");
        int puntuacion = EntradaDatos.pedirPuntuacion("Nueva puntuación (1-5):");

        r.setNombre(nombre);
        r.setCiudad(ciudad);
        r.setTipoCocina(tipoCocina);
        r.setPuntuacion(puntuacion);

        JOptionPane.showMessageDialog(null, "Restaurante editado correctamente.");
    }
}
