/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Control.ControlJuego;
import Model.EstadoJuego;
import Model.Jugador;
import java.awt.*;
import javax.swing.*;

public class FrmJuego extends javax.swing.JFrame {

    private ControlJuego controlador;
    private JButton[][] botonesLineas;
    private JLabel[][] etiquetasCuadros;
    private int gridSize = 3;
    private JPanel panelJuego;
    private JLabel lblJugadorActual;
    private JLabel lblPuntuacionX;
    private JLabel lblPuntuacionO;
    private boolean miTurno = true; // Para simulación de red
    private String miJugador = "X"; // Para simulación de red
    private Jugador jugadorLocal;

    public FrmJuego(Jugador jugador) {
        this.jugadorLocal = jugador;
        initComponents();
        configurarInterfaz();
        controlador = new ControlJuego(this);
        mostrarDatosJugador();
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                iniciarJuego();
            }
        });

    }

    public FrmJuego() {
         initComponents();
        configurarInterfaz();
        controlador = new ControlJuego(this);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                iniciarJuego();
            }
        });
    }

    /**
     * Configura componentes adicionales de la interfaz
     */

     private void configurarInterfaz() {
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(new Color(255, 255, 255, 200));
        panelInfo.setLayout(new GridLayout(1, 3));

        lblJugadorActual = new JLabel("Turno: Jugador X", SwingConstants.CENTER);
        lblJugadorActual.setFont(new Font("Arial", Font.BOLD, 16));
        lblJugadorActual.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblPuntuacionX = new JLabel("Jugador X: 0", SwingConstants.CENTER);
        lblPuntuacionX.setFont(new Font("Arial", Font.BOLD, 14));

        lblPuntuacionO = new JLabel("Jugador O: 0", SwingConstants.CENTER);
        lblPuntuacionO.setFont(new Font("Arial", Font.BOLD, 14));

        panelInfo.add(lblPuntuacionX);
        panelInfo.add(lblJugadorActual);
        panelInfo.add(lblPuntuacionO);

        panelJuego = new JPanel();
        panelJuego.setBackground(new Color(255, 255, 255, 180));
        panelJuego.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setOpaque(false);
        panelCentral.add(panelInfo, BorderLayout.NORTH);
        panelCentral.add(panelJuego, BorderLayout.CENTER);

        JButton btnSalir = new JButton("Salir del juego");
        btnSalir.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "\u00bfSeguro que desea salir de la partida?",
                    "Confirmar salida", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
            }
        });
   

         jPanel1.setLayout(new BorderLayout());

        JPanel panelInferior = new JPanel();
        panelInferior.setOpaque(false);
        panelInferior.add(btnSalir);
        panelCentral.add(panelInferior, BorderLayout.SOUTH);

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(panelCentral, BorderLayout.CENTER);

        setTitle("Timbiriche - En partida");
        setSize(800, 700);
        setLocationRelativeTo(null);
    }
     
     private void mostrarDatosJugador() {
        if (jugadorLocal == null) return;

        JPanel panelJugador = new JPanel();
        panelJugador.setLayout(new BorderLayout());
        panelJugador.setBackground(Color.WHITE);
        panelJugador.setPreferredSize(new Dimension(150, 200));
        panelJugador.setBorder(BorderFactory.createTitledBorder("Jugador Local"));

        JLabel lblAvatar = new JLabel(jugadorLocal.getAvatar());
        lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblNombre = new JLabel(jugadorLocal.getNombreUsuario(), SwingConstants.CENTER);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        lblNombre.setForeground(jugadorLocal.getColor());

        panelJugador.add(lblAvatar, BorderLayout.CENTER);
        panelJugador.add(lblNombre, BorderLayout.SOUTH);

        jPanel1.add(panelJugador, BorderLayout.WEST);
    }
     
     


    /**
     * Método para iniciar el juego (simula conexión de red)
     */
    private void iniciarJuego() {
        // Simulamos recepción de datos iniciales del juego
        inicializarTablero();
        actualizarEstadoJuego(new EstadoJuego("X", 0, 0));
    }

    /**
     * Inicializa el tablero de juego
     */
    private void inicializarTablero() {
        panelJuego.removeAll();
        panelJuego.setLayout(new GridLayout(gridSize * 2 + 1, gridSize * 2 + 1, 2, 2));

        botonesLineas = new JButton[gridSize * 2 + 1][gridSize * 2 + 1];
        etiquetasCuadros = new JLabel[gridSize][gridSize];

        // Crea los puntos, líneas y cuadros
        for (int i = 0; i < gridSize * 2 + 1; i++) {
            for (int j = 0; j < gridSize * 2 + 1; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    // Punto (intersección)
                    JLabel punto = new JLabel("•");
                    punto.setHorizontalAlignment(SwingConstants.CENTER);
                    punto.setFont(new Font("Arial", Font.BOLD, 24));
                    punto.setOpaque(true);
                    punto.setBackground(new Color(50, 50, 50));
                    punto.setForeground(Color.WHITE);
                    panelJuego.add(punto);
                } else if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
                    // Línea horizontal o vertical
                    botonesLineas[i][j] = new JButton();
                    botonesLineas[i][j].setBackground(Color.LIGHT_GRAY);
                    botonesLineas[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

                    // Ajustamos dimensiones según orientación
                    if (i % 2 == 0) {
                        // Línea horizontal
                        botonesLineas[i][j].setPreferredSize(new Dimension(60, 10));
                    } else {
                        // Línea vertical
                        botonesLineas[i][j].setPreferredSize(new Dimension(10, 60));
                    }

                    // Captura la posición para el actionListener
                    final int x = i;
                    final int y = j;

                    botonesLineas[i][j].addActionListener(e -> {
                        // Solo permitimos acciones si es nuestro turno (simulación red)
                        if (miTurno) {
                            // Simulamos envío de la jugada a través de la red
                            String respuestaRed = simularRespuestaRed(x, y);
                            controlador.seleccionarLinea(x, y, respuestaRed);
                        } else {
                            JOptionPane.showMessageDialog(this,
                                    "Espera tu turno", "No es tu turno",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    });

                    panelJuego.add(botonesLineas[i][j]);
                } else if (i % 2 == 1 && j % 2 == 1) {
                    // Cuadro (espacio para marcar propietario)
                    int cuadroI = i / 2;
                    int cuadroJ = j / 2;
                    etiquetasCuadros[cuadroI][cuadroJ] = new JLabel();
                    etiquetasCuadros[cuadroI][cuadroJ].setHorizontalAlignment(SwingConstants.CENTER);
                    etiquetasCuadros[cuadroI][cuadroJ].setFont(new Font("Arial", Font.BOLD, 18));
                    etiquetasCuadros[cuadroI][cuadroJ].setOpaque(true);
                    etiquetasCuadros[cuadroI][cuadroJ].setBackground(new Color(230, 230, 230));
                    panelJuego.add(etiquetasCuadros[cuadroI][cuadroJ]);
                }
            }
        }

        panelJuego.revalidate();
        panelJuego.repaint();
    }

    /**
     * Método para simular respuesta de red al realizar una jugada
     *
     * @param x Coordenada x de la línea
     * @param y Coordenada y de la línea
     * @return Respuesta simulada del servidor
     */
    private String simularRespuestaRed(int x, int y) {
        // En una implementación real, aquí se enviaría la jugada al servidor
        // y se esperaría respuesta. Para simular, simplemente validamos localmente.

        // Simulamos una respuesta exitosa
        return "OK";
    }

    /**
     * Actualiza el tablero tras una jugada
     *
     * @param x Coordenada x de la línea jugada
     * @param y Coordenada y de la línea jugada
     * @param cuadroCompletado Indica si se completó un cuadro
     * @param jugador Jugador que realizó la jugada
     */
    public void actualizarTablero(int x, int y, boolean cuadroCompletado, String jugador) {
        // Marcar línea
        if (botonesLineas[x][y] != null) {
            botonesLineas[x][y].setBackground(Color.BLACK);
            botonesLineas[x][y].setEnabled(false);
        }

        // Si completó cuadro, actualizar el cuadro
        if (cuadroCompletado) {
            // Verificar cuadros adyacentes
            verificarYMarcarCuadro(x, y, jugador);
        }

        // Simulamos recepción de nuevo estado del juego
        int puntosX = contarPuntos("X");
        int puntosO = contarPuntos("O");

        // Actualizar estado del juego
        EstadoJuego nuevoEstado = new EstadoJuego(
                cuadroCompletado ? jugador : (jugador.equals("X") ? "O" : "X"),
                puntosX,
                puntosO
        );

        actualizarEstadoJuego(nuevoEstado);

        // Simular cambio de turno en modo red
        this.miTurno = nuevoEstado.getJugadorActual().equals(this.miJugador);

        // Verificar fin del juego
        if (puntosX + puntosO == gridSize * gridSize) {
            String ganador;
            if (puntosX > puntosO) {
                ganador = "Jugador X";
            } else if (puntosO > puntosX) {
                ganador = "Jugador O";
            } else {
                ganador = "Empate";
            }

            JOptionPane.showMessageDialog(this,
                    "Fin del juego\n" + ganador + " ha ganado!",
                    "Juego Terminado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Verifica y marca los cuadros completados
     *
     * @param x Coordenada x
     * @param y Coordenada y
     * @param jugador Jugador actual
     */
    private void verificarYMarcarCuadro(int x, int y, String jugador) {
        Color colorJugador = jugador.equals("X") ? Color.BLUE : Color.RED;

        // Para líneas horizontales
        if (x % 2 == 0) {
            // Verificar cuadro superior (si existe)
            int filaSuperior = (x / 2) - 1;
            int columna = y / 2;

            if (filaSuperior >= 0 && filaSuperior < gridSize) {
                if (controlador.comprobarCuadroUI(filaSuperior, columna)) {
                    etiquetasCuadros[filaSuperior][columna].setText(jugador);
                    etiquetasCuadros[filaSuperior][columna].setForeground(colorJugador);
                    etiquetasCuadros[filaSuperior][columna].setBackground(
                            jugador.equals("X") ? new Color(200, 220, 255) : new Color(255, 200, 200));
                }
            }

            // Verificar cuadro inferior (si existe)
            int filaInferior = x / 2;
            if (filaInferior < gridSize) {
                if (controlador.comprobarCuadroUI(filaInferior, columna)) {
                    etiquetasCuadros[filaInferior][columna].setText(jugador);
                    etiquetasCuadros[filaInferior][columna].setForeground(colorJugador);
                    etiquetasCuadros[filaInferior][columna].setBackground(
                            jugador.equals("X") ? new Color(200, 220, 255) : new Color(255, 200, 200));
                }
            }
        } // Para líneas verticales
        else {
            // Verificar cuadro izquierdo (si existe)
            int fila = x / 2;
            int columnaIzquierda = (y / 2) - 1;

            if (columnaIzquierda >= 0 && columnaIzquierda < gridSize) {
                if (controlador.comprobarCuadroUI(fila, columnaIzquierda)) {
                    etiquetasCuadros[fila][columnaIzquierda].setText(jugador);
                    etiquetasCuadros[fila][columnaIzquierda].setForeground(colorJugador);
                    etiquetasCuadros[fila][columnaIzquierda].setBackground(
                            jugador.equals("X") ? new Color(200, 220, 255) : new Color(255, 200, 200));
                }
            }

            // Verificar cuadro derecho (si existe)
            int columnaDerecha = y / 2;
            if (columnaDerecha < gridSize) {
                if (controlador.comprobarCuadroUI(fila, columnaDerecha)) {
                    etiquetasCuadros[fila][columnaDerecha].setText(jugador);
                    etiquetasCuadros[fila][columnaDerecha].setForeground(colorJugador);
                    etiquetasCuadros[fila][columnaDerecha].setBackground(
                            jugador.equals("X") ? new Color(200, 220, 255) : new Color(255, 200, 200));
                }
            }
        }
    }

    /**
     * Actualiza la interfaz con el estado actual del juego
     *
     * @param estado Objeto con el estado actual del juego
     */
    public void actualizarEstadoJuego(EstadoJuego estado) {
        lblJugadorActual.setText("Turno: Jugador " + estado.getJugadorActual());
        lblPuntuacionX.setText("Jugador X: " + estado.getPuntosX());
        lblPuntuacionO.setText("Jugador O: " + estado.getPuntosO());

        // Actualizar indicador visual de turno
        if (estado.getJugadorActual().equals("X")) {
            lblJugadorActual.setForeground(Color.BLUE);
        } else {
            lblJugadorActual.setForeground(Color.RED);
        }
    }

    /**
     * Cuenta los puntos de un jugador
     *
     * @param jugador Jugador ("X" u "O")
     * @return Número de cuadros del jugador
     */
    private int contarPuntos(String jugador) {
        int puntos = 0;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (etiquetasCuadros[i][j].getText().equals(jugador)) {
                    puntos++;
                }
            }
        }
        return puntos;
    }

    /**
     * Simula recibir una jugada del oponente a través de la red
     *
     * @param x Coordenada x
     * @param y Coordenada y
     */
    public void recibirJugadaRed(int x, int y) {
        // Este método sería llamado cuando se reciba una jugada del oponente
        // Para probar, podríamos llamarlo manualmente con un botón de prueba
        controlador.seleccionarLinea(x, y, "RED");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1245, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1248, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmJuego().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
