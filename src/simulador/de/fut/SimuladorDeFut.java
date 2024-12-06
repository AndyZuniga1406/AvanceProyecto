/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulador.de.fut;


import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;



/**
 *
 * @author DELL
 */
public class SimuladorDeFut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Temporada temporada = new Temporada();

        String nombreJugador = JOptionPane.showInputDialog("Introduce tu nombre de jugador:");

        int numeroCamisa = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu número de camiseta:"));

        String posicion = JOptionPane.showInputDialog("Introduce tu posición:");

        temporada.agregarJugador(nombreJugador, numeroCamisa, posicion);

        String[] equipos = {"Real Madrid", "Barcelona", "Atletico Madrid", "Sevilla", "Villareal", "Betis"};
        String equipoSeleccionado = (String) JOptionPane.showInputDialog(null, "Elige tu equipo:", "Seleccionar equipo",
                JOptionPane.QUESTION_MESSAGE, null, equipos, equipos[0]);

        temporada.simularLiga(equipoSeleccionado);
    }    
}    
