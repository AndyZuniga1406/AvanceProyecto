/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador.de.fut;

/**
 *
 * @author DELL
 */
public class Jugador {
   private String nombre;
    private int numeroCamisa;
    private String posicion;

    public Jugador(String nombre, int numeroCamisa, String posicion) {
        this.nombre = nombre;
        this.numeroCamisa = numeroCamisa;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public String getPosicion() {
        return posicion;
    }
}
