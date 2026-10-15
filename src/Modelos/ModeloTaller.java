package Modelos;

public class ModeloTaller {

    private int idTaller;
    private String nombre;
    private String instructor;
    private String fechaInicio;
    private String fechaFinal;
    private String horario;
    private String salon;

    public ModeloTaller(int idTaller, String nombre, String instructor,
            String fechaInicio, String fechaFinal, String horario, String salon) {
        this.idTaller = idTaller;
        this.nombre = nombre;
        this.instructor = instructor;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horario = horario;
        this.salon = salon;
    }

    public int getIdTaller() {
        return idTaller;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public String getHorario() {
        return horario;
    }

    public String getSalon() {
        return salon;
    }

    public String obtenerDetalles() {
        return "Taller: " + nombre
                + "\nInstructor: " + instructor
                + "\nFecha de inicio: " + fechaInicio
                + "\nFecha final: " + fechaFinal
                + "\nHorario: " + horario
                + "\nSalon: " + salon;
    }

    @Override
    public String toString() {
        return idTaller + " - " + nombre;
    }
}
