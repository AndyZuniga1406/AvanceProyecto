/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador.de.fut;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author DELL
 */
public class Temporada {
    private ArrayList<Equipo> equipos;
    private Jugador jugador;

    public Temporada() {
        this.equipos = new ArrayList<>();
        equipos.add(new Equipo("Real Madrid"));
        equipos.add(new Equipo("Barcelona"));
        equipos.add(new Equipo("Atletico Madrid"));
        equipos.add(new Equipo("Sevilla"));
        equipos.add(new Equipo("Villareal"));
        equipos.add(new Equipo("Betis"));
    }

    public void agregarJugador(String nombre, int numeroCamisa, String posicion) {
        this.jugador = new Jugador(nombre, numeroCamisa, posicion);
    }

    public void simularLiga(String equipoSeleccionado) {
        Random random = new Random();
        ArrayList<String> partidosSimulados = new ArrayList<>();

        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getNombre().equals(equipoSeleccionado)) {
                for (int j = 0; j < equipos.size(); j++) {
                    if (i != j) {
                        int golesEquipoSeleccionado = random.nextInt(6);
                        int golesRival = random.nextInt(6);
                        partidosSimulados.add(equipoSeleccionado + " " + golesEquipoSeleccionado + " - " + golesRival + " " + equipos.get(j).getNombre());

                        if (golesEquipoSeleccionado > golesRival) {
                            equipos.get(i).setPuntos(equipos.get(i).getPuntos() + 3);
                        } else if (golesEquipoSeleccionado < golesRival) {
                    }
                }
            }
        }
    }
}        
}
