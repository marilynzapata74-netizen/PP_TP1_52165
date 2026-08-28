/**
 * Representa una sala física de la universidad.
 * Existe de forma independiente de los eventos: por eso su relación
 * con EventoUniversitario es de AGREGACIÓN (el evento "usa" una sala,
 * pero la sala no depende del evento para existir).
 */
public class Sala {

    private int id;
    private String nombre;

    public Sala(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Sala{id=" + id + ", nombre='" + nombre + "'}";
    }
}
