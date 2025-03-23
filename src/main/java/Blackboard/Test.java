/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Blackboard;

/**
 *
 * @author Serva
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear el Blackboard
        Blackboard blackboard = new Blackboard();
        BlackboardControl control = new BlackboardControl(blackboard);
        
        // Agregar una fuente de conocimiento de prueba
        blackboard.addKnowledgeSource(new KnowledgeSource() {
            @Override
            public void update(Blackboard blackboard) {
                System.out.println("Cambio detectado en el Blackboard: " + blackboard.get("estadoJuego"));
            }
        });
        
        // Probar iniciar sesión
        control.iniciarSesion("Jugador1", "password123");
        System.out.println("Usuario en Blackboard: " + blackboard.get("usuario"));
        
        // Probar iniciar partida
        control.iniciarPartida();
        System.out.println("Estado del juego: " + blackboard.get("estadoJuego"));
        
        // Probar ejercer turno
        control.ejercerTurno("Jugador1", 5);
        System.out.println("Último movimiento registrado: " + blackboard.get("ultimoMovimiento"));
    }
}