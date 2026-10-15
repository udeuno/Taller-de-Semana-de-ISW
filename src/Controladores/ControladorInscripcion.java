package Controladores;

import Modelos.ModeloAlumno;
import Modelos.ModeloInscripcion;
import Modelos.ModeloTaller;
import java.util.ArrayList;
import java.util.List;

public class ControladorInscripcion {

    private final List<ModeloTaller> talleres = new ArrayList<>();
    private final List<ModeloAlumno> alumnos = new ArrayList<>();

    private ModeloTaller tallerSeleccionado;
    private ModeloAlumno alumnoEncontrado;
    private ModeloInscripcion inscripcionActual;

    public ControladorInscripcion() {
        cargarDatosPrueba();
    }

    private void cargarDatosPrueba() {
        talleres.add(new ModeloTaller(
                1,
                "Introduccion a la Inteligencia Artificial",
                "Mtra. Ana Lopez",
                "20/10/2026",
                "20/10/2026",
                "10:00 - 12:00",
                "Laboratorio 1"
        ));

        talleres.add(new ModeloTaller(
                2,
                "Desarrollo de aplicaciones web",
                "Ing. Carlos Ruiz",
                "21/10/2026",
                "21/10/2026",
                "12:00 - 14:00",
                "Aula 4"
        ));

        talleres.add(new ModeloTaller(
                3,
                "Ciberseguridad para principiantes",
                "Mtro. Luis Garcia",
                "22/10/2026",
                "22/10/2026",
                "09:00 - 11:00",
                "Laboratorio 2"
        ));

        alumnos.add(new ModeloAlumno(
                "123456",
                "Patricio Medellin",
                5,
                "Ingenieria en Software"
        ));

        alumnos.add(new ModeloAlumno(
                "234567",
                "Maria Gonzalez",
                3,
                "Ingenieria en Software"
        ));

        alumnos.add(new ModeloAlumno(
                "345678",
                "Jose Ramirez",
                7,
                "Ingenieria en Software"
        ));
    }

    public List<ModeloTaller> cargarTalleres() {
        return new ArrayList<>(talleres);
    }

    public String seleccionarTaller(int idTaller) {
        for (ModeloTaller taller : talleres) {
            if (taller.getIdTaller() == idTaller) {
                tallerSeleccionado = taller;
                return taller.obtenerDetalles();
            }
        }

        tallerSeleccionado = null;
        return "No se encontro el taller.";
    }

    public ModeloAlumno buscarAlumno(String idAlumno) {
        alumnoEncontrado = null;

        for (ModeloAlumno alumno : alumnos) {
            ModeloAlumno resultado = alumno.buscarPorID(idAlumno);

            if (resultado != null) {
                alumnoEncontrado = resultado;
                break;
            }
        }

        return alumnoEncontrado;
    }

    public String registrarInscripcion() {
        if (tallerSeleccionado == null) {
            throw new IllegalStateException(
                    "Selecciona un taller primero.");
        }

        if (alumnoEncontrado == null) {
            throw new IllegalStateException(
                    "Busca un alumno valido primero.");
        }

        inscripcionActual = new ModeloInscripcion(
                alumnoEncontrado,
                tallerSeleccionado
        );

        inscripcionActual.registrar();

        return inscripcionActual.getTicket().generar()
                + "\n\n"
                + tallerSeleccionado.obtenerDetalles()
                + "\n\n"
                + alumnoEncontrado.consultarDatos()
                + "\nFecha de inscripcion: "
                + inscripcionActual.getFechaInscripcion();
    }
}
