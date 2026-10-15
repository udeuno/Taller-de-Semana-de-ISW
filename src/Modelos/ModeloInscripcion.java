package Modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModeloInscripcion {
    private static int siguienteId = 1;
    private int idInscripcion;
    private String fechaInscripcion;
    private ModeloAlumno alumno;
    private ModeloTaller taller;
    private ModeloTicket ticket;

    public ModeloInscripcion(ModeloAlumno alumno, ModeloTaller taller) {
        this.idInscripcion = siguienteId++;
        this.fechaInscripcion = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.alumno = alumno;
        this.taller = taller;
    }

    public void registrar() {
        if (alumno == null || taller == null) {
            throw new IllegalStateException(
                    "Se necesita un alumno y un taller.");
        }

        ticket = new ModeloTicket(
                "ISW-" + String.format("%04d", idInscripcion));
    }

    public boolean confirmarInscripcion() {
        return alumno != null && taller != null && ticket != null;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public ModeloAlumno getAlumno() {
        return alumno;
    }

    public ModeloTaller getTaller() {
        return taller;
    }

    public ModeloTicket getTicket() {
        return ticket;
    }
}