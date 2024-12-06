/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador.de.fut;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

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
                            equipos.get(j).setPuntos(equipos.get(j).getPuntos() + 3);
                        } else {
                            equipos.get(i).setPuntos(equipos.get(i).getPuntos() + 1);
                            equipos.get(j).setPuntos(equipos.get(j).getPuntos() + 1);
                        }
                    }
                }
            }
        }

        String partidosTexto = "";
        for (String partido : partidosSimulados) {
            partidosTexto += partido + "\n";
        }
        JOptionPane.showMessageDialog(null, partidosTexto, "Resultados de la Liga", JOptionPane.INFORMATION_MESSAGE);

        String tablaTexto = "Tabla de posiciones al final de la liga:\n";
        equipos.sort((e1, e2) -> Integer.compare(e2.getPuntos(), e1.getPuntos()));

        for (Equipo equipo : equipos) {
            tablaTexto += equipo.getNombre() + ": " + equipo.getPuntos() + " puntos\n";
        }
        JOptionPane.showMessageDialog(null, tablaTexto, "Tabla de Posiciones", JOptionPane.INFORMATION_MESSAGE);

        if (equipos.get(0).getNombre().equals(equipoSeleccionado)) {
            JOptionPane.showMessageDialog(null, "¡Felicidades! " + equipoSeleccionado + " ha ganado la liga.", "Campeón de la Liga", JOptionPane.INFORMATION_MESSAGE);
            simularChampions(equipoSeleccionado);
        } else {
            JOptionPane.showMessageDialog(null, "Lo siento, " + equipoSeleccionado + " no ganó la liga.", "Resultado de la Liga", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void simularChampions(String equipoSeleccionado) {
        Random random = new Random();
        JOptionPane.showMessageDialog(null, "Simulando Champions League...", "Simulación Champions", JOptionPane.INFORMATION_MESSAGE);

        ArrayList<String> rondas = new ArrayList<>();
        rondas.add("Octavos de final");
        rondas.add("Cuartos de final");
        rondas.add("Semifinales");
        rondas.add("Final");

        for (String ronda : rondas) {
            JOptionPane.showMessageDialog(null, ronda, "Ronda de la Champions", JOptionPane.INFORMATION_MESSAGE);

            String rival = obtenerRivalChampions(equipoSeleccionado);

            int golesEquipo = random.nextInt(5);
            int golesRival = random.nextInt(5);

            String mensaje = equipoSeleccionado + " " + golesEquipo + " - " + golesRival + " " + rival;
            JOptionPane.showMessageDialog(null, mensaje, "Resultado " + ronda, JOptionPane.INFORMATION_MESSAGE);

            if (golesEquipo > golesRival) {
                JOptionPane.showMessageDialog(null, equipoSeleccionado + " avanza a la siguiente ronda.", "Avance a la siguiente ronda", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Lo siento, " + equipoSeleccionado + " ha sido eliminado.", "Eliminado de la Champions", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "¡Felicidades! " + equipoSeleccionado + " ha ganado la Champions League.", "Campeón de la Champions", JOptionPane.INFORMATION_MESSAGE);
    }

    public String obtenerRivalChampions(String equipoSeleccionado) {
        ArrayList<String> equiposDisponibles = new ArrayList<>();
        equiposDisponibles.add("Bayern Munich");
        equiposDisponibles.add("PSG");
        equiposDisponibles.add("Liverpool");
        equiposDisponibles.add("Manchester City");
        equiposDisponibles.add("Barcelona");
        equiposDisponibles.add("AC Milan");
        equiposDisponibles.add("Borrusia Dortmund");

        equiposDisponibles.remove(equipoSeleccionado);

        Random random = new Random();
        return equiposDisponibles.get(random.nextInt(equiposDisponibles.size()));
    }        
}
