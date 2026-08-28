import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que modela una actividad genérica dentro de un evento.
 * Es abstracta porque, a partir del Ejercicio 3, no se crean actividades
 * "genéricas": siempre se crea un tipo concreto (Charla o Taller).
 *
 * La relación con EventoUniversitario es de COMPOSICIÓN: una actividad
 * no tiene sentido ni existe fuera del evento al que pertenece.
 */
public abstract class Actividad {

    private int id;
    private String titulo;
    private int cupoMaximo;
    public static final int CUPO_MINIMO = 5;

    private List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    /**
     * Inscribe a un estudiante en la actividad, si hay cupo disponible.
     */
    public Inscripcion inscribir(Estudiante estudiante) {
        if (inscripciones.size() >= cupoMaximo) {
            System.out.println("No se pudo inscribir a " + estudiante.getNombre()
                    + ": cupo completo en \"" + titulo + "\"");
            return null;
        }
        Inscripcion inscripcion = new Inscripcion(estudiante, this, "Confirmada");
        inscripciones.add(inscripcion);
        return inscripcion;
    }

    public void mostrarInscripciones() {
        System.out.println("Inscripciones en \"" + titulo + "\" (" + inscripciones.size() + "):");
        for (Inscripcion i : inscripciones) {
            System.out.println("   - " + i.getEstudiante().getNombre()
                    + " | legajo: " + i.getEstudiante().getLegajo()
                    + " | fecha: " + i.getFecha()
                    + " | estado: " + i.getEstado());
        }
    }

    /**
     * Método final: no puede ser redefinido por las subclases (Charla, Taller).
     * Usa getTipo() y calcularCostoMateriales(), que sí son polimórficos.
     */
    public final void mostrarIdentificacion() {
        System.out.println("[" + getTipo() + "] #" + id + " - " + titulo
                + " | cupo máximo: " + cupoMaximo
                + " | costo materiales: $" + calcularCostoMateriales());
    }

    public abstract double calcularCostoMateriales();

    public abstract String getTipo();

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }
}
