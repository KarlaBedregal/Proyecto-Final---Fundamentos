package juegoludo;

import javax.swing.JFrame;

public class PantallaJuego {
    public static void main(String[] args) {
        // CREA EL OBJETO JFRAME QUE REPRESENTA LA VENTANA DEL JUEGO
        JFrame ventanaJuego = new JFrame();
        
        // ESTABLECE LAS DIMENSIONES Y LA UBICACIÓN DE LA VENTANA DEL JUEGO
        ventanaJuego.setBounds(10, 10, 1220, 600);
        
        // ESTABLECE EL TÍTULO DE LA VENTANA DEL JUEGO
        ventanaJuego.setTitle("LUDO");
        
        // IMPIDE QUE LA VENTANA DEL JUEGO SE PUEDA REDIMENSIONAR
        ventanaJuego.setResizable(false);
        
        // ESTABLECE LA OPERACIÓN POR DEFECTO AL CERRAR LA VENTANA
        ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // CREA UN OBJETO DE LA CLASE MOVIMIENTOSJUEGO QUE CONTIENE LA LÓGICA DEL JUEGO
        MovimientosJuego movimientosJuego = new MovimientosJuego();
        
        // ESTABLECE EL OBJETO MOVIMIENTOSJUEGO COMO FOCUSABLE
        movimientosJuego.setFocusable(true);
        
        // AÑADE EL OBJETO MOVIMIENTOSJUEGO COMO ESCUCHADOR DE EVENTOS DEL TECLADO Y RATÓN
        movimientosJuego.addKeyListener(movimientosJuego);
        movimientosJuego.addMouseListener(movimientosJuego);
        
        // AÑADE EL OBJETO MOVIMIENTOSJUEGO A LA VENTANA DEL JUEGO
        ventanaJuego.add(movimientosJuego);
        
        // HACE VISIBLE LA VENTANA DEL JUEGO
        ventanaJuego.setVisible(true);
    }
}
