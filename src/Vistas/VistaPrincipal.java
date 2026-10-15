package Vistas;

import Controladores.ControladorInscripcion;
import Modelos.ModeloTaller;
import javax.swing.*;
import java.awt.*;

public class VistaPrincipal extends JFrame {

    private final ControladorInscripcion controlador;

    private final JComboBox<ModeloTaller> comboTalleres
            = new JComboBox<>();

    private final JTextArea areaDetalles = new JTextArea();

    private final JButton btnInscribir
            = new JButton("Inscribirse");

    private final JButton btnVerDetalles
            = new JButton("Ver detalles");

    public VistaPrincipal(ControladorInscripcion controlador) {
        this.controlador = controlador;

        configurarVentana();
        cargarTalleres();
        configurarEventos();
    }

    private void configurarVentana() {
        setTitle("Talleres - Semana de ISW");
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelTalleres = new JPanel(new BorderLayout(10, 10));
        panelTalleres.setBorder(
                BorderFactory.createTitledBorder("Talleres disponibles"));

        comboTalleres.setPreferredSize(new Dimension(220, 30));

        panelTalleres.add(comboTalleres, BorderLayout.NORTH);
        panelTalleres.add(btnVerDetalles, BorderLayout.CENTER);
        panelTalleres.add(btnInscribir, BorderLayout.SOUTH);

        areaDetalles.setEditable(false);
        areaDetalles.setFont(
                new Font(Font.MONOSPACED, Font.PLAIN, 14));
        areaDetalles.setLineWrap(true);
        areaDetalles.setWrapStyleWord(true);
        areaDetalles.setText(
                "Selecciona un taller para consultar sus detalles.");

        JPanel panelDetalles = new JPanel(new BorderLayout());
        panelDetalles.setBorder(
                BorderFactory.createTitledBorder("Detalles del taller"));

        panelDetalles.add(
                new JScrollPane(areaDetalles),
                BorderLayout.CENTER);

        JPanel panelCentral = new JPanel(new GridLayout(1, 2, 10, 0));
        panelCentral.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelCentral.add(panelTalleres);
        panelCentral.add(panelDetalles);

        add(panelCentral, BorderLayout.CENTER);
    }

    private void cargarTalleres() {
        for (ModeloTaller taller : controlador.cargarTalleres()) {
            comboTalleres.addItem(taller);
        }
    }

    private void configurarEventos() {
        btnVerDetalles.addActionListener(e -> mostrarDetalles());

        comboTalleres.addActionListener(e -> mostrarDetalles());

        btnInscribir.addActionListener(e -> {
            if (comboTalleres.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "No hay talleres disponibles.");
                return;
            }

            ModeloTaller taller
                    = (ModeloTaller) comboTalleres.getSelectedItem();

            controlador.seleccionarTaller(taller.getIdTaller());

            VistaInscripcion ventana
                    = new VistaInscripcion(this, controlador);

            ventana.setVisible(true);
        });
    }

    private void mostrarDetalles() {
        ModeloTaller taller
                = (ModeloTaller) comboTalleres.getSelectedItem();

        if (taller != null) {
            areaDetalles.setText(
                    controlador.seleccionarTaller(
                            taller.getIdTaller()));
        }
    }
}
