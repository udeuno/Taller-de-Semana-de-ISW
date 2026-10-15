package Modelos;

public class ModeloAlumno {
    private String id;
    private String nombre;
    private int semestre;
    private String programa;

    public ModeloAlumno(String id, String nombre, int semestre, String programa) {
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
        this.programa = programa;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getPrograma() {
        return programa;
    }

    public ModeloAlumno buscarPorID(String idBuscado) {
        return id.equalsIgnoreCase(idBuscado.trim()) ? this : null;
    }

    public String consultarDatos() {
        return "ID: " + id
                + "\nNombre: " + nombre
                + "\nSemestre: " + semestre
                + "\nPrograma: " + programa;
    }
}
