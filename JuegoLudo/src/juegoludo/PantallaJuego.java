package juegoludo;

import javax.swing.JFrame;

public class PantallaJuego {
    public PantallaJuego () {
        
        // CREA EL OBJETO JFRAME QUE REPRESENTA LA VENTANA DEL JUEGO
    	JFrame ventanaJuego = new JFrame();
        
        // ESTABLECE LAS DIMENSIONES Y LA UBICACI�N DE LA VENTANA DEL JUEGO
        ventanaJuego.setBounds(10, 10, 1220, 600);
        
        // ESTABLECE EL T�TULO DE LA VENTANA DEL JUEGO
        ventanaJuego.setTitle("LUDO");
        
        // IMPIDE QUE LA VENTANA DEL JUEGO SE PUEDA REDIMENSIONAR
        ventanaJuego.setResizable(false);
        
        // ESTABLECE LA OPERACI�N POR DEFECTO AL CERRAR LA VENTANA
        ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // CREA UN OBJETO DE LA CLASE MOVIMIENTOSJUEGO QUE CONTIENE LA L�GICA DEL JUEGO
        MovimientosJuego movimientosJuego = new MovimientosJuego();
        
        // ESTABLECE EL OBJETO MOVIMIENTOSJUEGO COMO FOCUSABLE
        movimientosJuego.setFocusable(true);
        
        // A�ADE EL OBJETO MOVIMIENTOSJUEGO COMO ESCUCHADOR DE EVENTOS DEL TECLADO Y RAT�N
        movimientosJuego.addKeyListener(movimientosJuego);
        movimientosJuego.addMouseListener(movimientosJuego);
        
        // A�ADE EL OBJETO MOVIMIENTOSJUEGO A LA VENTANA DEL JUEGO
        ventanaJuego.add(movimientosJuego);
        
        // HACE VISIBLE LA VENTANA DEL JUEGO
        ventanaJuego.setVisible(true);
    }
}