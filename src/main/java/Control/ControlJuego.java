/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Cuadro;
import Model.Linea;
import View.FrmEjercerTurno;

/**
 *
 * @author Serva
 */
public class ControlJuego {

    private Linea[][] lineas;
    private Cuadro[][] cuadros;
    private int gridSize = 3;
    private String jugadorActual = "X";
    private FrmEjercerTurno vista;

    public ControlJuego(FrmEjercerTurno vista) {
        this.vista = vista;
        lineas = new Linea[gridSize * 2 + 1][gridSize * 2 + 1];
        cuadros = new Cuadro[gridSize][gridSize];

        for (int i = 0; i < gridSize * 2 + 1; i++) {
            for (int j = 0; j < gridSize * 2 + 1; j++) {
                if (i % 2 == 0 && j % 2 == 1 || i % 2 == 1 && j % 2 == 0) {
                    lineas[i][j] = new Linea();
                }
            }
        }

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                cuadros[i][j] = new Cuadro();
            }
        }
    }

    public void seleccionarLinea(int x, int y, String respuestaRed) {
        if (!lineas[x][y].estaMarcada()) {
            lineas[x][y].marcar();
            boolean cuadroCompletado = comprobarCuadro(x, y);
            vista.actualizarTablero(x, y, cuadroCompletado, jugadorActual);

            if (!cuadroCompletado) {
                cambiarTurno();
            }
        }
    }

    private boolean comprobarCuadro(int x, int y) {
        int i = x / 2;
        int j = y / 2;
        if (i < gridSize && j < gridSize) {
            if (cuadros[i][j].verificarCompleto(lineas, i, j)) {
                cuadros[i][j].asignarJugador(jugadorActual);
                return true;
            }
        }
        return false;
    }

    private void cambiarTurno() {
        jugadorActual = jugadorActual.equals("X") ? "O" : "X";
    }
}
