/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoludo;

import javax.swing.*;
import java.awt.*;

public class PanelTablero extends JPanel {
    private int x, y, width, height;

    public PanelTablero() {
        // INICIALIZAR POSICIÓN Y TAMAÑO INICIAL DEL TABLERO
        x = 50;  // COORDENADA X INICIAL DEL TABLERO
        y = 50;  // COORDENADA Y INICIAL DEL TABLERO
        width = 30;  // ANCHO DE CADA CELDA INDIVIDUAL
        height = 30; // ALTURA DE CADA CELDA INDIVIDUAL
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // PINTAR EL FONDO DEL TABLERO EN COLOR BLANCO
        g2d.setColor(Color.WHITE);
        g2d.fillRect(x, y, 15 * width, 15 * height);

        // DIBUJAR LAS CELDAS DE COLORES EN LAS ESQUINAS DEL TABLERO
        for (int i = 0; i < 6; i++) {
            // DIBUJAR LA ESQUINA ROJA
            g2d.setColor(Color.RED);
            g2d.fillRect(x + (i * width), y, width, height);
            g2d.fillRect(x, y + (i * height), width, height);
            g2d.fillRect(x + (i * width), y + (5 * height), width, height);
            g2d.fillRect(x + (5 * width), y + (i * height), width, height);

            // DIBUJAR LA ESQUINA VERDE
            g2d.setColor(Color.GREEN);
            g2d.fillRect(x + ((i + 9) * width), y, width, height);
            g2d.fillRect(x + (9 * width), y + (i * height), width, height);
            g2d.fillRect(x + ((i + 9) * width), y + (5 * height), width, height);
            g2d.fillRect(x + (14 * width), y + (i * height), width, height);

            // DIBUJAR LA ESQUINA AMARILLA
            g2d.setColor(Color.YELLOW);
            g2d.fillRect(x + ((i + 9) * width), y + (9 * height), width, height);
            g2d.fillRect(x + (9 * width), y + ((i + 9) * height), width, height);
            g2d.fillRect(x + ((i + 9) * width), y + (14 * height), width, height);
            g2d.fillRect(x + (14 * width), y + ((i + 9) * height), width, height);

            // DIBUJAR LA ESQUINA AZUL
            g2d.setColor(Color.BLUE);
            g2d.fillRect(x + (i * width), y + (9 * height), width, height);
            g2d.fillRect(x, y + ((i + 9) * height), width, height);
            g2d.fillRect(x + (i * width), y + (14 * height), width, height);
            g2d.fillRect(x + (5 * width), y + ((i + 9) * height), width, height);
        }

        // DIBUJAR LOS BORDES DEL TABLERO COMO CUADROS NEGROS
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                g2d.drawRect(x + (i * width), y + (j * height), width, height);
            }
        }
    }
}
