package net.salesianos.restaurante;

public class Restaurante {
    private String nombre;
    private String ciudad;
    private String tipoCocina;
    private int puntuacion;

    public Restaurante(String nombre, String ciudad, String tipoCocina, int puntuacion) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipoCocina = tipoCocina;
        this.puntuacion = puntuacion;
    }
}
