import java.time.LocalDate;

/**
 * Representa el vínculo entre un Estudiante y una Actividad en un momento dado.
 * Guarda referencia tanto al estudiante como a la actividad para poder
 * trazar el vínculo en el mapa de memoria (Ejercicio 4).
 */
public class Inscripcion {

    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;
    private Actividad actividad;

    public Inscripcion(Estudiante estudiante, Actividad actividad, String estado) {
        this.estudiante = estudiante;
        this.actividad = actividad;
        this.estado = estado;
        this.fecha = LocalDate.now();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Actividad getActividad() {
        return actividad;
    }
}
