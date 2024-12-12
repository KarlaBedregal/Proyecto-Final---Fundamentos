package juegoludo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class MovimientosJuego extends JPanel implements KeyListener, ActionListener, MouseListener {

    private static final long serialVersionUID = 1L; // IDENTIFICADOR DE VERSIÓN PARA LA SERIALIZACIÓN
    Tablero tablero; // OBJETO QUE REPRESENTA EL TABLERO DEL JUEGO
    CrearJugadores jugador; // OBJETO QUE REPRESENTA LOS JUGADORES DEL JUEGO
    Timer temporizador; // OBJETO TIMER PARA EL CONTROL DEL TIEMPO
    int retraso = 10; // RETRASO DEL TEMPORIZADOR EN MILISEGUNDOS
    int jugadorActual, dado; // VARIABLES PARA CONTROLAR EL JUGADOR ACTUAL Y EL VALOR DEL DADO
    int bandera = 0, tiro, eliminacion = 0; // VARIABLES DE ESTADO

    // CONSTRUCTOR DE LA CLASE MOVIMIENTOSJUEGO
    public MovimientosJuego() {
        setFocusTraversalKeysEnabled(false); // DESHABILITA LAS TECLAS DE TRAVESÍA DE FOCUS
        requestFocus(); // SOLICITA FOCUS PARA EL PANEL
        jugadorActual = 0; // INICIALIZA EL JUGADOR ACTUAL A 0
        tablero = new Tablero(80, 50); // CREA UN NUEVO TABLERO CON LAS DIMENSIONES DADAS
        jugador = new CrearJugadores(tablero.alto, tablero.ancho); // CREA LOS JUGADORES CON LAS DIMENSIONES DEL TABLERO
        dado = 0; // INICIALIZA EL VALOR DEL DADO A 0
        bandera = 0; // INICIALIZA LA BANDERA A 0
        tiro = 0; // INICIALIZA EL TIRO A 0
        eliminacion = 0; // INICIALIZA LA ELIMINACIÓN A 0
    }

    // MÉTODO PARA DIBUJAR LOS COMPONENTES DEL JUEGO
    @Override
    public void paint(Graphics g) {
        tablero.dibujar((Graphics2D) g); // DIBUJA EL TABLERO
        jugador.dibujar((Graphics2D) g); // DIBUJA LOS JUGADORES
        if (jugador.jugadores[jugadorActual].fichas == 4) { // VERIFICA SI EL JUGADOR ACTUAL HA GANADO
            g.setColor(Color.WHITE);
            g.fillRect(590, 100, 380, 130); // DIBUJA UN RECTÁNGULO BLANCO PARA EL MENSAJE DE GANADOR
            if (jugadorActual == 0) {
                g.setColor(Color.RED);
            } else if (jugadorActual == 1) {
                g.setColor(Color.GREEN);
            } else if (jugadorActual == 2) {
                g.setColor(Color.YELLOW);
            } else if (jugadorActual == 3) {
                g.setColor(Color.BLUE);
            }
            g.setFont(new Font("serif", Font.BOLD, 40));
            g.drawString("Jugador " + (PantallaInicial.jugador[jugadorActual]) + " gana.", 600, 150); // MENSAJE DE GANADOR
            g.drawString("Felicidades.", 600, 200); // MENSAJE DE FELICITACIONES
            jugadorActual = 0; // REINICIA EL JUGADOR ACTUAL A 0
            tablero = new Tablero(80, 50); // CREA UN NUEVO TABLERO
            jugador = new CrearJugadores(tablero.alto, tablero.ancho); // CREA NUEVOS JUGADORES
            dado = 0; // REINICIA EL VALOR DEL DADO
            bandera = 0; // REINICIA LA BANDERA
            tiro = 0; // REINICIA EL TIRO
            eliminacion = 0; // REINICIA LA ELIMINACIÓN
        } else if (dado != 0) { // SI SE HA LANZADO EL DADO
            g.setColor(Color.WHITE);
            g.fillRect(590, 100, 420, 130); // DIBUJA UN RECTÁNGULO BLANCO PARA MOSTRAR EL VALOR DEL DADO
            if (jugadorActual == 0) {
                g.setColor(Color.RED);
            } else if (jugadorActual == 1) {
                g.setColor(Color.GREEN);
            } else if (jugadorActual == 2) {
                g.setColor(Color.YELLOW);
            } else if (jugadorActual == 3) {
                g.setColor(Color.BLUE);
            }
            g.setFont(new Font("serif", Font.BOLD, 40));
            g.drawString("Jugador " + (PantallaInicial.jugador[jugadorActual]), 600, 150); // MUESTRA EL JUGADOR ACTUAL
            g.drawString("Número en el dado es " + dado, 600, 200); // MUESTRA EL VALOR DEL DADO
        }
        if (bandera == 0 && dado != 0 && dado != 6 && eliminacion == 0) {
            jugadorActual = (jugadorActual + 1) % PantallaInicial.JUGADORES; // CAMBIA AL SIGUIENTE JUGADOR
        }
        eliminacion = 0; // REINICIA LA ELIMINACIÓN
    }

    // MÉTODO PARA MANEJAR EVENTOS DE TECLADO
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && bandera == 0) { // SI SE PRESIONA ENTER Y LA BANDERA ESTÁ EN 0
            tiro = 0; // REINICIA EL TIRO
            dado = 1 + (int) (Math.random() * 6); // GENERA UN NÚMERO ALEATORIO ENTRE 1 Y 6
            repaint(); // REPINTA EL COMPONENTE
            for (int i = 0; i < 4; i++) {
                if (jugador.jugadores[jugadorActual].fichasActivas[i].posicionActual != -1
                        && jugador.jugadores[jugadorActual].fichasActivas[i].posicionActual != 56
                        && (jugador.jugadores[jugadorActual].fichasActivas[i].posicionActual + dado) <= 56) {
                    bandera = 1; // ACTUALIZA LA BANDERA SI HAY UN MOVIMIENTO VÁLIDO
                    break;
                }
            }
            if (bandera == 0 && dado == 6) { // SI NO HAY MOVIMIENTO VÁLIDO PERO EL DADO ES 6
                for (int i = 0; i < 4; i++) {
                    if (jugador.jugadores[jugadorActual].fichasActivas[i].posicionActual == -1) {
                        bandera = 1; // ACTUALIZA LA BANDERA SI HAY UNA FICHA FUERA DEL TABLERO
                        break;
                    }
                }
            }
        }
    }
    // MÉTODO QUE MANEJA LOS EVENTOS DE CLIC DEL RATÓN
    public void mouseClicked(MouseEvent e) {    
        if (bandera == 1) { // VERIFICA SI SE PUEDE REALIZAR UNA ACCIÓN
            int x = e.getX(); // OBTIENE LA COORDENADA X DEL CLIC
            int y = e.getY(); // OBTIENE LA COORDENADA Y DEL CLIC
            x = x - 80; // AJUSTA LA COORDENADA X
            y = y - 50; // AJUSTA LA COORDENADA Y
            x = x / 30; // ESCALA LA COORDENADA X A LA DIMENSIÓN DE LAS CASILLAS
            y = y / 30; // ESCALA LA COORDENADA Y A LA DIMENSIÓN DE LAS CASILLAS
            int valor = -1; // VARIABLE PARA GUARDAR LA FICHA SELECCIONADA

            if (dado == 6) { // SI EL DADO ES 6
                for (int i = 0; i < 4; i++) {
                    if (jugador.jugadores[jugadorActual].fichasActivas[i].posicionX == x 
                            && jugador.jugadores[jugadorActual].fichasActivas[i].posicionY == y
                            && (jugador.jugadores[jugadorActual].fichasActivas[i].posicionActual + dado) <= 56) {
                        valor = i; // ASIGNA LA FICHA SELECCIONADA
                        bandera = 0; // REINICIA LA BANDERA
                        break;
                    }
                }
                if (valor != -1) { // SI SE SELECCIONÓ UNA FICHA
                    jugador.jugadores[jugadorActual].fichasActivas[valor].posicionActual += dado; // MUEVE LA FICHA
                    if (jugador.jugadores[jugadorActual].fichasActivas[valor].posicionActual == 56) {
                        jugador.jugadores[jugadorActual].fichas++; // INCREMENTA LAS FICHAS DEL JUGADOR
                    }
                    int k = 0;
                    int pos = jugador.jugadores[jugadorActual].fichasActivas[valor].posicionActual;
                    if ((pos % 13) != 0 && (pos % 13) != 8 && pos < 51) { // VERIFICA SI LA FICHA CAE EN UNA POSICIÓN ESPECIAL
                        for (int i = 0; i < PantallaInicial.JUGADORES; i++) {
                            if (i != jugadorActual) {
                                for (int j = 0; j < 4; j++) {
                                    int temp1 = Camino.posicionX[jugadorActual][jugador.jugadores[jugadorActual].fichasActivas[valor].posicionActual];
                                    int temp2 = Camino.posicionY[jugadorActual][jugador.jugadores[jugadorActual].fichasActivas[valor].posicionActual];
                                    if (jugador.jugadores[i].fichasActivas[j].posicionX == temp1 
                                            && jugador.jugadores[i].fichasActivas[j].posicionY == temp2) {
                                        jugador.jugadores[i].fichasActivas[j].posicionActual = -1; // ELIMINA LA FICHA DEL CONTRINCANTE
                                        eliminacion = 1; // MARCA QUE SE REALIZÓ UNA ELIMINACIÓN
                                        k = 1;
                                        break;
                                    }
                                }
                            }
                            if (k == 1)
                                break;
                        }
                    }
                } else { // SI NO SE SELECCIONÓ UNA FICHA
                    for (int i = 0; i < 4; i++) {
                        if (jugador.jugadores[jugadorActual].fichasActivas[i].posicionActual == -1) {
                            jugador.jugadores[jugadorActual].fichasActivas[i].posicionActual = 0; // MUEVE LA FICHA DESDE LA BASE
                            bandera = 0; // REINICIA LA BANDERA
                            break;
                        }
                    }
                }
            } else { // SI EL DADO NO ES 6
                for (int i = 0; i < 4; i++) {
                    if (jugador.jugadores[jugadorActual].fichasActivas[i].posicionX == x 
                            && jugador.jugadores[jugadorActual].fichasActivas[i].posicionY == y
                            && (jugador.jugadores[jugadorActual].fichasActivas[i].posicionActual + dado) <= 56) {
                        valor = i; // ASIGNA LA FICHA SELECCIONADA
                        bandera = 0; // REINICIA LA BANDERA
                        break;
                    }
                }
                if (valor != -1) { // SI SE SELECCIONÓ UNA FICHA
                    jugador.jugadores[jugadorActual].fichasActivas[valor].posicionActual += dado; // MUEVE LA FICHA
                    if (jugador.jugadores[jugadorActual].fichasActivas[valor].posicionActual == 56) {
                        jugador.jugadores[jugadorActual].fichas++; // INCREMENTA LAS FICHAS DEL JUGADOR
                    }
                    int k = 0;
                    int pos = jugador.jugadores[jugadorActual].fichasActivas[valor].posicionActual;
                    if ((pos % 13) != 0 && (pos % 13) != 8 && pos < 51) { // VERIFICA SI LA FICHA CAE EN UNA POSICIÓN ESPECIAL
                        for (int i = 0; i < PantallaInicial.JUGADORES; i++) {
                            if (i != jugadorActual) {
                                for (int j = 0; j < 4; j++) {
                                    int temp1 = Camino.posicionX[jugadorActual][jugador.jugadores[jugadorActual].fichasActivas[valor].posicionActual];
                                    int temp2 = Camino.posicionY[jugadorActual][jugador.jugadores[jugadorActual].fichasActivas[valor].posicionActual];
                                    if (jugador.jugadores[i].fichasActivas[j].posicionX == temp1 
                                            && jugador.jugadores[i].fichasActivas[j].posicionY == temp2) {
                                        jugador.jugadores[i].fichasActivas[j].posicionActual = -1; // ELIMINA LA FICHA DEL CONTRINCANTE
                                        eliminacion = 1; // MARCA QUE SE REALIZÓ UNA ELIMINACIÓN
                                        k = 1;
                                        break;
                                    }
                                }
                            }
                            if (k == 1)
                                break;
                        }
                    }
                }
            }
            repaint(); // REPINTA EL COMPONENTE
        }
    }
    // MÉTODO QUE SE EJECUTA CUANDO SE ACTIVA UNA ACCIÓN (NO IMPLEMENTADO)
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }

    // MÉTODO QUE SE EJECUTA CUANDO SE SUELTA UNA TECLA (NO IMPLEMENTADO)
    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    // MÉTODO QUE SE EJECUTA CUANDO SE PRESIONA UNA TECLA (NO IMPLEMENTADO)
    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    // MÉTODO QUE SE EJECUTA CUANDO EL RATÓN ENTRA EN EL COMPONENTE (NO IMPLEMENTADO)
    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    // MÉTODO QUE SE EJECUTA CUANDO EL RATÓN SALE DEL COMPONENTE (NO IMPLEMENTADO)
    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    // MÉTODO QUE SE EJECUTA CUANDO SE PRESIONA UN BOTÓN DEL RATÓN (NO IMPLEMENTADO)
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    // MÉTODO QUE SE EJECUTA CUANDO SE SUELTA UN BOTÓN DEL RATÓN (NO IMPLEMENTADO)
    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }
}