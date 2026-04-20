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
    public String getNombre() {
        return nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getTipoCocina() {
        return tipoCocina;
    }
    public int getPuntuacion() {
        return puntuacion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCiudad(String ciudad) {  
        this.ciudad = ciudad;
    }
    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
