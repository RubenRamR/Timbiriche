/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blackboard;

/**
 *
 * @author Serva
 */
public class BlackboardControl {

    private Blackboard blackboard;

    public BlackboardControl(Blackboard blackboard) {
        this.blackboard = blackboard;
    }

    public void iniciarSesion(String usuario, String contrasena) {
        System.out.println("Iniciando sesión para: " + usuario);
        blackboard.set("usuario", usuario);
    }

    public void iniciarPartida() {
        System.out.println("Iniciando nueva partida...");
        blackboard.set("estadoJuego", "en curso");
    }

    public void ejercerTurno(String jugador, int movimiento) {
        System.out.println("Turno de " + jugador + " con movimiento: " + movimiento);
        blackboard.set("ultimoMovimiento", movimiento);
    }
}
