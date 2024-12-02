/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador.de.fut;


/**
 *
 * @author DELL
 */
public class Equipo {
    private String nombre;
    private int puntos;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }
}
