package juegoludo;

public class Camino {
    // MATRIZ DE POSICIONES EN EL EJE X PARA CADA CASILLA DEL TABLERO
    static int[][] posicionX = {
        {1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6},
        {8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7},
        {13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 13, 12, 11, 10, 9, 8},
        {6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7}
    };
    
    // MATRIZ DE POSICIONES EN EL EJE Y PARA CADA CASILLA DEL TABLERO
    static int[][] posicionY = {
        {6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7},
        {1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6},
        {8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7},
        {13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 13, 12, 11, 10, 9, 8}
    };
    
    // POSICIONES INICIALES EN EL EJE X PARA CADA JUGADOR
    static int[][] inicialX = {
        {1, 1, 3, 3},
        {10, 10, 12, 12},
        {10, 10, 12, 12},
        {1, 1, 3, 3}
    };
    
    // POSICIONES INICIALES EN EL EJE Y PARA CADA JUGADOR
    static int[][] inicialY = {
        {1, 3, 1, 3},
        {1, 3, 1, 3},
        {10, 12, 10, 12},
        {10, 12, 10, 12}
    };
}