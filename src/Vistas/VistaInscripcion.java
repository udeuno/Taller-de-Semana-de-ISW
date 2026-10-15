package Vistas;

import Controladores.ControladorInscripcion;
import Modelos.ModeloAlumno;
import javax.swing.*;
import java.awt.*;

public class VistaInscripcion extends JDialog {

    private final ControladorInscripcion controlador;

    private final JTextField txtID = new JTextField(15);

    private final JTextArea areaDatos = new JTextArea(8, 35);

    private final JButton btnBuscar = new JButton("Buscar ID");

    private final JButton btnConfirmar =
            new JButton("Confirmar inscripcion");

    public VistaInscripcion(
            JFrame padre,
            ControladorInscripcion controlador) {

        super(padre, "Inscripcion al taller", true);

        this.controlador = controlador;

        configurarVentana();
        configurarEventos();
    }

    private void configurarVentana() {
        setSize(480, 360);
        setLocationRelativeTo(getOwner());
        setLayout(new BorderLayout(10, 10));

        JPanel panelID = new JPanel(new FlowLayout());

        panelID.add(new JLabel("ID del alumno:"));
        panelID.add(txtID);
        panelID.add(btnBuscar);

        areaDatos.setEditable(false);

        areaDatos.setText(
                "Ingresa el ID y presiona Buscar ID.");

        JPanel panelInferior = new JPanel(
                new FlowLayout(FlowLayout.RIGHT));

        btnConfirmar.setEnabled(false);
        panelInferior.add(btnConfirmar);

        add(panelID, BorderLayout.NORTH);
        add(new JScrollPane(areaDatos), BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private void configurarEventos() {
        btnBuscar.addActionListener(e -> buscarAlumno());

        btnConfirmar.addActionListener(
                e -> confirmarInscripcion());
    }

    private void buscarAlumno() {
        String id = txtID.getText().trim();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingresa el ID del alumno.");
            return;
        }

        ModeloAlumno alumno = controlador.buscarAlumno(id);

        if (alumno == null) {
            areaDatos.setText(
                    "No se encontro un alumno con ese ID.");

            btnConfirmar.setEnabled(false);
        } else {
            areaDatos.setText(alumno.consultarDatos());

            btnConfirmar.setEnabled(true);
        }
    }

    private void confirmarInscripcion() {
        try {
            String ticket = controlador.registrarInscripcion();

            areaDatos.setText(ticket);

            btnConfirmar.setEnabled(false);
            btnBuscar.setEnabled(false);
            txtID.setEditable(false);

        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "No se pudo inscribir",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
