/**
 * Representa a un estudiante que puede inscribirse en actividades.
 */
public class Estudiante {

    private String legajo;
    private String nombre;

    public Estudiante(String legajo, String nombre) {
        this.legajo = legajo;
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Estudiante{legajo='" + legajo + "', nombre='" + nombre + "'}";
    }
}
