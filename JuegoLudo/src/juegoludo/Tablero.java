package juegoludo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Tablero {
    int x, y, ancho, alto; // COORDENADAS Y DIMENSIONES DEL TABLERO

    // CONSTRUCTOR DE LA CLASE TABLERO
    public Tablero(int posX, int posY) {
        x = posX; // ASIGNA LA POSICI�N X
        y = posY; // ASIGNA LA POSICI�N Y
        ancho = 30; // ASIGNA EL ANCHO DE CADA CASILLA
        alto = 30; // ASIGNA LA ALTURA DE CADA CASILLA
    }
    
    // M�TODO PARA DIBUJAR EL TABLERO
    public void dibujar(Graphics2D graficos) {
        graficos.setColor(Color.WHITE);
        graficos.fillRect(x, y, 15 * ancho, 15 * alto); // DIBUJA EL FONDO DEL TABLERO

        // DIBUJA LAS CASILLAS PARA CADA JUGADOR
        for (int i = 0; i < 6; i++) {
            graficos.setColor(Color.RED);
            graficos.fillRect(x + (i * ancho), y, ancho, alto);
            graficos.fillRect(x, y + (i * alto), ancho, alto);
            graficos.fillRect(x + (i * ancho), y + (5 * alto), ancho, alto);
            graficos.fillRect(x + (5 * ancho), y + (i * alto), ancho, alto);
            graficos.setColor(Color.GREEN);
            graficos.fillRect(x + ((i + 9) * ancho), y, ancho, alto);
            graficos.fillRect(x + (9 * ancho), y + (i * alto), ancho, alto);
            graficos.fillRect(x + ((i + 9) * ancho), y + (5 * alto), ancho, alto);
            graficos.fillRect(x + (14 * ancho), y + (i * alto), ancho, alto);
            graficos.setColor(Color.YELLOW);
            graficos.fillRect(x + ((i + 9) * ancho), y + (9 * alto), ancho, alto);
            graficos.fillRect(x + (9 * ancho), y + ((i + 9) * alto), ancho, alto);
            graficos.fillRect(x + ((i + 9) * ancho), y + (14 * alto), ancho, alto);
            graficos.fillRect(x + (14 * ancho), y + ((i + 9) * alto), ancho, alto);
            graficos.setColor(Color.BLUE);
            graficos.fillRect(x + (i * ancho), y + (9 * alto), ancho, alto);
            graficos.fillRect(x, y + ((i + 9) * alto), ancho, alto);
            graficos.fillRect(x + (i * ancho), y + (14 * alto), ancho, alto);
            graficos.fillRect(x + (5 * ancho), y + ((i + 9) * alto), ancho, alto);
        }

        // DIBUJA EL CAMINO DE CADA JUGADOR
        for (int i = 1; i < 6; i++) {
            graficos.setColor(Color.RED);
            graficos.fillRect(x + (i * ancho), y + (7 * alto), ancho, alto);
            graficos.setColor(Color.YELLOW);
            graficos.fillRect(x + ((8 + i) * ancho), y + (7 * alto), ancho, alto);
            graficos.setColor(Color.GREEN);
            graficos.fillRect(x + (7 * ancho), y + (i * alto), ancho, alto);
            graficos.setColor(Color.BLUE);
            graficos.fillRect(x + (7 * ancho), y + ((8 + i) * alto), ancho, alto);
        }

        // DIBUJA LAS CASILLAS ESPECIALES PARA CADA JUGADOR
        graficos.setColor(Color.RED);
        graficos.fillRect(x + (1 * ancho), y + (6 * alto), ancho, alto);
        graficos.setColor(Color.YELLOW);
        graficos.fillRect(x + (13 * ancho), y + (8 * alto), ancho, alto);
        graficos.setColor(Color.GREEN);
        graficos.fillRect(x + (8 * ancho), y + (1 * alto), ancho, alto);
        graficos.setColor(Color.BLUE);
        graficos.fillRect(x + (6 * ancho), y + (13 * alto), ancho, alto);

        // DIBUJA LOS INICIOS DE CADA JUGADOR
        int temp1 = x + 45, temp2 = y + 45;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                graficos.setColor(Color.RED);
                graficos.fillRect(temp1 + (2 * i * ancho), temp2 + (2 * j * alto), ancho, alto);
                graficos.setColor(Color.YELLOW);
                graficos.fillRect(temp1 + (2 * i * ancho) + 9 * ancho, temp2 + (2 * j * alto) + 9 * alto, ancho, alto);
                graficos.setColor(Color.GREEN);
                graficos.fillRect(temp1 + (2 * i * ancho) + 9 * ancho, temp2 + (2 * j * alto), ancho, alto);
                graficos.setColor(Color.BLUE);
                graficos.fillRect(temp1 + (2 * i * ancho), temp2 + (2 * j * alto) + 9 * alto, ancho, alto);
            }
        }

        // DIBUJA LOS TRI�NGULOS CENTRALES PARA CADA JUGADOR
        graficos.setColor(Color.RED);
        int puntosX0[] = { x + (6 * ancho), x + (6 * ancho), x + 15 + (7 * ancho) };
        int puntosY0[] = { y + (6 * alto), y + (9 * alto), y + 15 + (7 * ancho) };
        int numPuntos0 = 3;
        graficos.fillPolygon(puntosX0, puntosY0, numPuntos0);

        graficos.setColor(Color.YELLOW);
        int puntosX1[] = { x + (9 * ancho), x + (9 * ancho), x + 15 + (7 * ancho) };
        int puntosY1[] = { y + (6 * alto), y + (9 * alto), y + 15 + (7 * ancho) };
        int numPuntos1 = 3;
        graficos.fillPolygon(puntosX1, puntosY1, numPuntos1);

        graficos.setColor(Color.GREEN);
        int puntosX2[] = { x + (6 * ancho), x + (9 * ancho), x + 15 + (7 * ancho) };
        int puntosY2[] = { y + (6 * alto), y + (6 * alto), y + 15 + (7 * ancho) };
        int numPuntos2 = 3;
        graficos.fillPolygon(puntosX2, puntosY2, numPuntos2);

        graficos.setColor(Color.BLUE);
        int puntosX3[] = { x + (6 * ancho), x + (9 * ancho), x + 15 + (7 * ancho) };
        int puntosY3[] = { y + (9 * alto), y + (9 * alto), y + 15 + (7 * ancho) };
        int numPuntos3 = 3;
        graficos.fillPolygon(puntosX3, puntosY3, numPuntos3);

        // DIBUJA LOS BORDES Y LAS L�NEAS DEL TABLERO
        graficos.setStroke(new BasicStroke(2));
        graficos.setColor(Color.BLACK);

                // DIBUJA LAS CASILLAS DE CADA JUGADOR EN EL TABLERO CENTRAL
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 6; j++) {
                        graficos.drawRect(x + ((i + 6) * ancho), y + (j * alto), ancho, alto); // CASILLAS DE LA PARTE SUPERIOR DEL TABLERO CENTRAL
                        graficos.drawRect(x + (j * ancho), y + ((i + 6) * alto), ancho, alto); // CASILLAS DE LA PARTE IZQUIERDA DEL TABLERO CENTRAL
                        graficos.drawRect(x + ((i + 6) * ancho), y + ((j + 9) * alto), ancho, alto); // CASILLAS DE LA PARTE INFERIOR DEL TABLERO CENTRAL
                        graficos.drawRect(x + ((j + 9) * ancho), y + ((i + 6) * alto), ancho, alto); // CASILLAS DE LA PARTE DERECHA DEL TABLERO CENTRAL
                    }
                }
        
                // DIBUJA LOS RECT�NGULOS GRANDES EN LAS ESQUINAS (INICIO DE CADA JUGADOR)
                graficos.drawRect(x + (1 * ancho), y + (1 * alto), 4 * ancho, 4 * alto);
                graficos.drawRect(x + (10 * ancho), y + (1 * alto), 4 * ancho, 4 * alto);
                graficos.drawRect(x + (1 * ancho), y + (10 * alto), 4 * ancho, 4 * alto);
                graficos.drawRect(x + (10 * ancho), y + (10 * alto), 4 * ancho, 4 * alto);
                graficos.drawRect(x, y, 15 * ancho, 15 * alto); // DIBUJA EL BORDE EXTERIOR DEL TABLERO
        
                // DIBUJA LOS RECT�NGULOS PEQUE�OS DE COLORES PARA CADA JUGADOR
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        graficos.drawRect(temp1 + (2 * i * ancho), temp2 + (2 * j * alto), ancho, alto);
                        graficos.drawRect(temp1 + (2 * i * ancho) + 9 * ancho, temp2 + (2 * j * alto) + 9 * alto, ancho, alto);
                        graficos.drawRect(temp1 + (2 * i * ancho) + 9 * ancho, temp2 + (2 * j * alto), ancho, alto);
                        graficos.drawRect(temp1 + (2 * i * ancho), temp2 + (2 * j * alto) + 9 * alto, ancho, alto);
                    }
                }
        
                // DIBUJA LOS TRI�NGULOS CENTRALES DE COLORES PARA CADA JUGADOR
                graficos.drawPolygon(puntosX0, puntosY0, numPuntos0);
                graficos.drawPolygon(puntosX1, puntosY1, numPuntos1);
                graficos.drawPolygon(puntosX2, puntosY2, numPuntos2);
                graficos.drawPolygon(puntosX3, puntosY3, numPuntos3);
        
                // DIBUJA LAS OV�LICAS DE LOS COLORES PARA CADA JUGADOR
                graficos.drawOval(x + 5 + (6 * ancho), y + 5 + (2 * alto), ancho - 10, alto - 10);
                graficos.drawOval(x + 5 + (12 * ancho), y + 5 + (6 * alto), ancho - 10, alto - 10);
                graficos.drawOval(x + 5 + (8 * ancho), y + 5 + (12 * alto), ancho - 10, alto - 10);
                graficos.drawOval(x + 5 + (2 * ancho), y + 5 + (8 * alto), ancho - 10, alto - 10);
                
                // CONFIGURA LA FUENTE Y DIBUJA LOS TEXTOS DE INSTRUCCIONES
                graficos.setFont(new Font("serif", Font.BOLD, 30));
                graficos.drawString(PantallaInicial.jugador[0]+"", 90, 35);
                graficos.drawString(PantallaInicial.jugador[1]+"", 370, 35);
                graficos.drawString(PantallaInicial.jugador[3]+"", 90, 540);
                graficos.drawString(PantallaInicial.jugador[2]+"", 370, 540);
                graficos.drawString("Instrucciones:", 550, 300);
                graficos.drawString("1. Lanza el dado y mueve una ficha. ", 550, 350);
                graficos.drawString("2. Si obtienes un 6, puedes mover otra ficha", 550, 400);
                graficos.drawString("3. Si no puedes mover, pasa el turno", 550, 450);
        
    }
}