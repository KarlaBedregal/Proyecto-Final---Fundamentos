package juegoludo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PantallaInicial extends JFrame
{
	private static final int ANCHO = 300;
	private static final int LARGO = 400;
	private String [] jugador = new String [4];
	private JRadioButton [] cantidad;
	
	public PantallaInicial ()
	{
		setTitle("Inicio");
		setSize(ANCHO, LARGO);
		setLayout( new GridLayout(3, 0) );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		crearContenido();
		setVisible(true);
	}
	
	public void crearContenido ()
	{
		//CANTIDAD DE JUGADORES
		cantidad = new JRadioButton [3];
		cantidad[0] = new JRadioButton ("2 Jugadores");
		cantidad[1] = new JRadioButton ("3 Jugadores");
		cantidad[2] = new JRadioButton ("4 Jugadores");
		
		JPanel cantidadPanel = new JPanel ( new FlowLayout(FlowLayout.LEFT) );
		cantidadPanel.add( new JLabel("Numero de Jugadores:") );
		
		for (JRadioButton jugadores : cantidad)
			cantidadPanel.add(jugadores);
		
		add(cantidadPanel);
	}
	
	private class Listener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{	
			
		}
	}
	
	public static void main (String[] args)
	{
		new PantallaInicial();
	}
}

