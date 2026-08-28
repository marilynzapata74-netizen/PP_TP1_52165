/**
 * Actividad de tipo Taller. Su costo de materiales depende de si
 * requiere o no el uso de notebook.
 */
public class Taller extends Actividad {

    private boolean requiereNotebook;

    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    @Override
    public double calcularCostoMateriales() {
        return requiereNotebook ? 5000 : 2000;
    }

    @Override
    public String getTipo() {
        return "Taller";
    }

    public boolean isRequiereNotebook() {
        return requiereNotebook;
    }
}
