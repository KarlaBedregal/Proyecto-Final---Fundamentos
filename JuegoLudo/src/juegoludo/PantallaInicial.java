package juegoludo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PantallaInicial extends JFrame
{
	private static final int ANCHO = 300;
	private static final int LARGO = 350;
	public static String [] jugador = new String [4];
	public static int JUGADORES;
	private JRadioButton [] cantidad;
	private JTextField [] jugadores;
	
	public PantallaInicial ()
	{
		setTitle("Configuración");
		setSize(ANCHO, LARGO);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setLayout( new GridLayout(2, 0, 0, 15) );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		crearContenido();
		setVisible(true);
		setEnabled(true);
	}
	
	public void crearContenido ()
	{		
		cantidadJugadores();
		ingresoDatos();
	}
	
	public void cantidadJugadores ()
	{
		//CANTIDAD DE JUGADORES
		ButtonGroup botones = new ButtonGroup();
				   cantidad = new JRadioButton [3];
				   
		cantidad[0] = new JRadioButton ("2 Jugadores");
		cantidad[1] = new JRadioButton ("3 Jugadores");
		cantidad[2] = new JRadioButton ("4 Jugadores", true);
		
		JPanel cantidadPanelTitulo = new JPanel ( new FlowLayout(FlowLayout.CENTER, 50, 10) );
		cantidadPanelTitulo.add( new JLabel("OPCIONES DE PARTIDA") );
		
		JPanel cantidadPanel = new JPanel ( new GridLayout(4,1) );
		cantidadPanel.add( new JLabel("Numero de Jugadores:") );
		
		for (JRadioButton jugadores : cantidad)
		{
			botones.add(jugadores);
			cantidadPanel.add(jugadores);
		}
		
		agregarListener();
		
		JPanel cantidadPanel2 = new JPanel ( new FlowLayout(FlowLayout.LEFT, 30, 10) );
		cantidadPanel2.add(cantidadPanelTitulo);
		cantidadPanel2.add(cantidadPanel);
		add(cantidadPanel2);
	}
	
	public void agregarListener ()
	{
		cantidad[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugadores[1].setEnabled(true);
            	jugadores[2].setEnabled(false);
                jugadores[3].setEnabled(false);
                JUGADORES = 2;
            }
        });
		
		cantidad[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	jugadores[1].setEnabled(true);
            	jugadores[2].setEnabled(true);
                jugadores[3].setEnabled(false);
                JUGADORES = 3;
            }
        });
		
		cantidad[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	jugadores[1].setEnabled(true);
            	jugadores[2].setEnabled(true);
                jugadores[3].setEnabled(true);
                JUGADORES = 4;
            }
        });
	}
	
	public void ingresoDatos ()
	{
		//INGRESO DE JUGADORES
		JPanel panelIngresar = new JPanel( new FlowLayout() );
		jugadores = new JTextField [4];
		
		for (int i = 0 ; i < jugadores.length ; i++)
			jugadores[i] = new JTextField (15);
		
		for (int i = 0 ; i < jugadores.length ; i++)
		{
			panelIngresar.add( new JLabel ("Jugador "+(i+1)+":") );
			panelIngresar.add(jugadores[i]);
		}
		
		// BOTON DE ENVIAR
		JButton botonEnviar = new JButton ("Configurar");
		botonEnviar.addActionListener(new Listener());
		panelIngresar.add(botonEnviar);
		
		add(panelIngresar);
	}
	
	private class Listener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{	
		    // MËTODO PARA ESTABLECER NOMBRES
	    	for (int i = 0 ; i < jugadores.length ; i++)
	    		jugador[i] = jugadores[i].getText();
	    	
	    	dispose();
	    	
	    	new PantallaJuego ();
		}
	}
	
	public static void main(String[] args) {
        new PantallaInicial();
	}
}

