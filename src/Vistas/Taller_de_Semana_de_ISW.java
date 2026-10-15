package Vistas;

import Controladores.ControladorInscripcion;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Taller_de_Semana_de_ISW {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }

            ControladorInscripcion controlador =
                    new ControladorInscripcion();

            VistaPrincipal ventana =
                    new VistaPrincipal(controlador);

            ventana.setVisible(true);
        });
    
    }
    
}
