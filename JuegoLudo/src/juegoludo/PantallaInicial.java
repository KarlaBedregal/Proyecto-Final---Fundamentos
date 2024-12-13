package juegoludo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PantallaInicial extends JFrame {
    private static final int ANCHO = 300;
    private static final int LARGO = 350;
    public static String[] jugador = new String[4];
    public static int JUGADORES;
    private JRadioButton[] cantidad;
    private JTextField[] jugadores;

    public PantallaInicial() {
        setTitle("Configuracion"); // TITULO DE LA VENTANA
        setSize(ANCHO, LARGO); // TAMAÑO DE LA VENTANA
        setResizable(false); // DESHABILITA CAMBIO DE TAMAÑO
        setLocationRelativeTo(null); // CENTRA LA VENTANA
        setAlwaysOnTop(true); // PONEMS ENCIMA DE OTRAS VENTANAS
        setLayout(new GridLayout(2, 0, 0, 15));
        getContentPane().setBackground(new Color(173, 216, 230)); // COLOR CELESTE DE LA VENTANA
        setDefaultCloseOperation(EXIT_ON_CLOSE); // TERMINA EL PROGRAMA AL CERRAR
        crearContenido(); // LLAMA A CREAR LOS ELEMENTOS DE LA VENTANA
        setVisible(true); // HACE LA VENTANA VISIBLE
        setEnabled(true); // HABILITA LA INTERACCION
    }

    public void crearContenido() {
        cantidadJugadores(); // CREA LAS OPCIONES PARA SELECCIONAR CANTIDAD DE JUGADORES
        ingresoDatos(); // CREA EL FORMULARIO PARA INGRESAR LOS NOMBRES DE LOS JUGADORES
    }

    public void cantidadJugadores() {
        // CANTIDAD DE JUGADORES
        ButtonGroup botones = new ButtonGroup();
        cantidad = new JRadioButton[3];

        cantidad[0] = new JRadioButton("2 Jugadores");
        cantidad[1] = new JRadioButton("3 Jugadores");
        cantidad[2] = new JRadioButton("4 Jugadores");

        JPanel cantidadPanelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
        cantidadPanelTitulo.add(new JLabel("OPCIONES DE PARTIDA"));

        JPanel cantidadPanel = new JPanel(new GridLayout(4, 1));
        cantidadPanel.add(new JLabel("Numero de Jugadores:")); // TITULO PARA SELECCION DE JUGADORES

        for (JRadioButton jugadores : cantidad) {
            botones.add(jugadores); // AGREGA LOS BOTONES AL GRUPO
            cantidadPanel.add(jugadores);
        }

        agregarListener(); // AGREGA LOS LISTENERS PARA LOS BOTONES DE OPCION

        JPanel cantidadPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
        cantidadPanel2.add(cantidadPanelTitulo);
        cantidadPanel2.add(cantidadPanel);
        add(cantidadPanel2); // AGREGA EL PANEL A LA VENTANA
    }

    public void agregarListener() {
        cantidad[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jugadores != null) {
                    jugadores[1].setEnabled(true);
                    jugadores[2].setEnabled(false);
                    jugadores[3].setEnabled(false);
                }
                JUGADORES = 2; // ESTABLECE 2 JUGADORES
            }
        });

        cantidad[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jugadores != null) {
                    jugadores[1].setEnabled(true);
                    jugadores[2].setEnabled(true);
                    jugadores[3].setEnabled(false);
                }
                JUGADORES = 3; // ESTABLECE 3 JUGADORES
            }
        });

        cantidad[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jugadores != null) {
                    jugadores[1].setEnabled(true);
                    jugadores[2].setEnabled(true);
                    jugadores[3].setEnabled(true);
                }
                JUGADORES = 4; // ESTABLECE 4 JUGADORES
            }
        });
    }

    public void ingresoDatos() {
        // INGRESO DE NOMBRES DE LOS JUGADORES
        JPanel panelIngresar = new JPanel(new FlowLayout());
        jugadores = new JTextField[4];

        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new JTextField(15); // CAJAS DE TEXTO PARA LOS NOMBRES
        }

        for (int i = 0; i < jugadores.length; i++) {
            panelIngresar.add(new JLabel("Jugador " + (i + 1) + ":")); // ETIQUETA PARA CADA JUGADOR
            panelIngresar.add(jugadores[i]); // AGREGA LA CAJA DE TEXTO
        }

        // BOTON DE ENVIAR CONFIGURACIÓN
        JButton botonEnviar = new JButton("Configurar");
        botonEnviar.setBackground(Color.GREEN); // COLOR VERDE PARA EL BOTON
        botonEnviar.addActionListener(new Listener()); // AGREGA EL LISTENER AL BOTON
        panelIngresar.add(botonEnviar);

        add(panelIngresar); // AGREGA EL PANEL A LA VENTANA
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // METODO PARA ESTABLECER LOS NOMBRES DE LOS JUGADORES
            for (int i = 0; i < jugadores.length; i++) {
                // SOLO ASIGNA NOMBRES SI EL JUGADOR ESTÁ HABILITADO
                if (i < JUGADORES) {
                    jugador[i] = jugadores[i].getText(); // ASIGNA EL NOMBRE
                } else {
                    jugador[i] = ""; // SI NO ESTÁ HABILITADO, ASIGNA VALOR VACÍO
                }
            }

            dispose(); // CIERRA LA VENTANA ACTUAL
            new PantallaJuego(); // INICIA LA PANTALLA DEL JUEGO
        }
    }

    public static void main(String[] args) {
        new PantallaInicial(); // INICIA LA PANTALLA INICIAL
    }
}


