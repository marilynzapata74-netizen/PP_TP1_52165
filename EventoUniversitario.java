import java.util.ArrayList;
import java.util.List;

/**
 * Modela un evento universitario (charla, jornada, taller, hackathon, etc).
 * Compone una lista de Actividad (Charla/Taller) y agrega una Sala.
 */
public class EventoUniversitario {

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    private Sala sala;
    private List<Actividad> actividades;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    /**
     * Constructor de copia (Ejercicio 1). Copia los datos propios del evento
     * y clona la lista de actividades (aunque las actividades en sí son
     * las mismas referencias, ya que no se pide una copia profunda de ellas).
     */
    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        this.sala = otro.sala;
        this.actividades = new ArrayList<>(otro.actividades);
        cantidadEventos++;
    }

    /**
     * Si el evento es gratuito, el costo total es 0.
     * Si no, es (costoBase + costo de cada actividad) * 1.21 (21% de impuestos).
     */
    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0;
        }
        double costoActividades = 0;
        for (Actividad a : actividades) {
            costoActividades += a.calcularCostoMateriales();
        }
        return (costoBase + costoActividades) * 1.21;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * Crea y agrega una Charla al evento.
     * Se mantiene el parámetro "tipo" (String) tal como pide la consigna,
     * a modo de validación ("debe decir Charla"), y se agrega el dato
     * propio de Charla (disertante) como parámetro adicional.
     */
    public void crearActividad(int id, String titulo, int cupo, String tipo, String disertante) {
        if (!tipo.equalsIgnoreCase("Charla")) {
            throw new IllegalArgumentException("Este método crea Charlas. Tipo recibido: " + tipo);
        }
        actividades.add(new Charla(id, titulo, cupo, disertante));
    }

    /**
     * Crea y agrega un Taller al evento (ver comentario del método anterior).
     */
    public void crearActividad(int id, String titulo, int cupo, String tipo, boolean requiereNotebook) {
        if (!tipo.equalsIgnoreCase("Taller")) {
            throw new IllegalArgumentException("Este método crea Talleres. Tipo recibido: " + tipo);
        }
        actividades.add(new Taller(id, titulo, cupo, requiereNotebook));
    }

    public void mostrarDatos() {
        System.out.println("Evento: " + titulo + " (ID: " + id + ")");
        System.out.println("Costo base: $" + costoBase);
        System.out.println("Gratuito: " + (gratuito ? "Sí" : "No"));
        System.out.println("Costo estimado total: $" + calcularCostoEstimado());
        System.out.println("Sala asignada: " + (sala != null ? sala.getNombre() : "(sin asignar)"));
        System.out.println("Actividades (" + actividades.size() + "):");
        for (Actividad a : actividades) {
            a.mostrarIdentificacion();
        }
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    public String getId() {
        return id;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public Sala getSala() {
        return sala;
    }
}
