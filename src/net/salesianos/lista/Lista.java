package net.salesianos.lista;

import net.salesianos.restaurante.Restaurante;
import java.util.ArrayList;
import java.util.Comparator;

public class Lista {
    private ArrayList<Restaurante> lista;

    public Lista() {
        lista = new ArrayList<>();
    }

    public void anadir(Restaurante restaurante) {
        lista.add(restaurante);
    }

    public ArrayList<Restaurante> getLista() {
        return lista;
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    public Restaurante obtener(int indice) {
        return lista.get(indice);
    }

    public void eliminar(int indice) {
        lista.remove(indice);
    }

    public void ordenarPorPuntuacionDesc() {
        lista.sort(Comparator.comparingInt(Restaurante::getPuntuacion).reversed());
    }
}
