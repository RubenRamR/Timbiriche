/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.awt.Color;
import javax.swing.ImageIcon;
/**
 *
 * @author joseq
 */
public class Jugador implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String nombreUsuario;
    private Color color;
    private ImageIcon avatar;
    private int puntos;

    public Jugador(String nombreUsuario, Color color, ImageIcon avatar) {
        this.nombreUsuario = nombreUsuario;
        this.color = color;
        this.avatar = avatar;
        this.puntos = 0;
    }

    public String getNombreUsuario() { return nombreUsuario; }
    public Color getColor() { return color; }
    public ImageIcon getAvatar() { return avatar; }
    public int getPuntos() { return puntos; }
    public void incrementarPuntos() { puntos++; }

    @Override
    public String toString() {
        return nombreUsuario + " (" + puntos + " pts)";
    }
    }
