package juegoludo;

import java.awt.Graphics2D;

public class CrearJugadores {

    // ARREGLO DE OBJETOS JUGADOR
    Jugador[] jugadores = new Jugador[PantallaInicial.JUGADORES]; 
    
    // MATRIZ DE POSICIONES INICIALES EN EJE X PARA CADA JUGADOR
    int[][] posicionInicialX = {
        {1, 1, 3, 3},
        {10, 10, 12, 12},
        {10, 10, 12, 12},
        {1, 1, 3, 3}
    };
    
    // MATRIZ DE POSICIONES INICIALES EN EJE Y PARA CADA JUGADOR
    int[][] posicionInicialY = {
        {1, 3, 1, 3},
        {1, 3, 1, 3},
        {10, 12, 10, 12},
        {10, 12, 10, 12}
    };

    // CONSTRUCTOR DE LA CLASE CREARJUGADORES
    public CrearJugadores(int altura, int anchura) {
        for (int i = 0; i < PantallaInicial.JUGADORES; i++) {
            // INICIALIZA CADA OBJETO JUGADOR CON ALTURA Y ANCHURA DADAS
            jugadores[i] = new Jugador(altura, anchura);
        }
    }

    // M�TODO PARA DIBUJAR LOS JUGADORES EN EL TABLERO
    public void dibujar(Graphics2D g) {
        for (int i = 0; i < PantallaInicial.JUGADORES; i++) {
            for (int j = 0; j < 4; j++) {
                // DIBUJA CADA FICHA DEL JUGADOR EN SU POSICI�N INICIAL
                jugadores[i].fichasActivas[j].dibujar(g, posicionInicialX[i][j], posicionInicialY[i][j], i);
            }
        }
    }
}