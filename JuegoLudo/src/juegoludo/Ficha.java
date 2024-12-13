package juegoludo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Ficha {
    int posicionX, posicionY; // COORDENADAS DE LA FICHA
    int posicionActual; // POSICION ACTUAL EN EL TABLERO
    int altura, ancho; // DIMENSIONES DE LA FICHA

    // CONSTRUCTOR DE LA CLASE FICHA
    public Ficha(int altura, int ancho) {
        posicionActual = -1; // INICIALIZA POSICI�N ACTUAL A -1 (FUERA DEL TABLERO)
        posicionX = -1; // INICIALIZA POSICION X A -1
        posicionY = -1; // INICIALIZA POSICION Y A -1
        this.altura = altura; // ASIGNA ALTURA
        this.ancho = ancho; // ASIGNA ANCHO
    }

    // M�TODO PARA DIBUJAR LA FICHA
    public void dibujar(Graphics2D graficos, int i, int j, int jugador) {
        if (posicionActual == -1) { // SI LA FICHA EST� FUERA DEL TABLERO
            int temp1 = 80 + (altura / 2), temp2 = 50 + (ancho / 2); // CALCULA LAS COORDENADAS TEMPORALES
            posicionX = i; // ASIGNA LA POSICION X
            posicionY = j; // ASIGNA LA POSICION Y
            if (jugador == 0) {
                graficos.setColor(Color.RED); // ASIGNA COLOR ROJO SI ES EL JUGADOR 0
            } else if (jugador == 1) {
                graficos.setColor(Color.GREEN); // ASIGNA COLOR VERDE SI ES EL JUGADOR 1
            } else if (jugador == 2) {
                graficos.setColor(Color.YELLOW); // ASIGNA COLOR AMARILLO SI ES EL JUGADOR 2
            } else if (jugador == 3) {
                graficos.setColor(Color.BLUE); // ASIGNA COLOR AZUL SI ES EL JUGADOR 3
            }
            graficos.fillOval(temp1 + 5 + (i * ancho), temp2 + 5 + (j * altura), ancho - 10, altura - 10); // DIBUJA LA FICHA
            graficos.setStroke(new BasicStroke(2)); // ESTABLECE EL GROSOR DEL BORDE
            graficos.setColor(Color.BLACK); // ASIGNA EL COLOR NEGRO PARA EL BORDE
            graficos.drawOval(temp1 + 5 + (i * ancho), temp2 + 5 + (j * altura), ancho - 10, altura - 10); // DIBUJA EL BORDE DE LA FICHA
        } else { // SI LA FICHA ESTA EN EL TABLERO
            int temp1 = 80, temp2 = 50; // COORDENADAS TEMPORALES
            posicionX = Camino.posicionX[jugador][posicionActual]; // ACTUALIZA LA POSICI�N X BASADO EN EL CAMINO DEL JUGADOR
            posicionY = Camino.posicionY[jugador][posicionActual]; // ACTUALIZA LA POSICI�N Y BASADO EN EL CAMINO DEL JUGADOR
            if (jugador == 0) {
                graficos.setColor(Color.RED); // ASIGNA COLOR ROJO SI ES EL JUGADOR 0
            } else if (jugador == 1) {
                graficos.setColor(Color.GREEN); // ASIGNA COLOR VERDE SI ES EL JUGADOR 1
            } else if (jugador == 2) {
                graficos.setColor(Color.YELLOW); // ASIGNA COLOR AMARILLO SI ES EL JUGADOR 2
            } else if (jugador == 3) {
                graficos.setColor(Color.BLUE); // ASIGNA COLOR AZUL SI ES EL JUGADOR 3
            }
            graficos.fillOval(temp1 + 5 + (posicionX * ancho), temp2 + 5 + (posicionY * altura), ancho - 10, altura - 10); // DIBUJA LA FICHA
            graficos.setStroke(new BasicStroke(2)); // ESTABLECE EL GROSOR DEL BORDE
            graficos.setColor(Color.BLACK); // ASIGNA EL COLOR NEGRO PARA EL BORDE
            graficos.drawOval(temp1 + 5 + (posicionX * ancho), temp2 + 5 + (posicionY * altura), ancho - 10, altura - 10); // DIBUJA EL BORDE DE LA FICHA
        }
    }
}