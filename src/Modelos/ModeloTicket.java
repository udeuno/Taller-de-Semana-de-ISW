package Modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModeloTicket {
    private String folio;
    private String fechaEmision;

    public ModeloTicket(String folio) {
        this.folio = folio;
        this.fechaEmision = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public String getFolio() {
        return folio;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public String generar() {
        return "TICKET DE INSCRIPCION - SEMANA DE ISW"
                + "\nFolio: " + folio
                + "\nFecha de emision: " + fechaEmision;
    }
}