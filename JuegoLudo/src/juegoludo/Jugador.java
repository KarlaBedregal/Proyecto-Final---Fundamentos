package juegoludo;
import java.awt.Graphics2D;

public class Jugador {
    int altura, ancho, estado, fichas; // VARIABLES QUE DEFINEN EL JUGADOR
    Ficha[] fichasActivas = new Ficha[4]; // ARREGLO DE FICHAS DEL JUGADOR

    // CONSTRUCTOR DE LA CLASE JUGADOR
    public Jugador(int altura, int ancho) {
        estado = -1; // INICIALIZA EL ESTADO DEL JUGADOR A -1 (FUERA DEL JUEGO)
        fichas = 0; // INICIALIZA EL CONTEO DE FICHAS EN 0
        for (int i = 0; i < 4; i++) {
            fichasActivas[i] = new Ficha(altura, ancho); // INICIALIZA CADA FICHA CON LAS DIMENSIONES DADAS
        }
    }

    // MÉTODO PARA DIBUJAR EL JUGADOR 
    public void dibujar(Graphics2D graficos) {
        // Código auxiliar de método generado automáticamente
    }
}