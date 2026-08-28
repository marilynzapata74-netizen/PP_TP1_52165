/**
 * Clase principal. Ejecuta el escenario completo pedido en la consigna
 * (Ejercicios 1 a 3), usando exactamente los datos que después se
 * representan en el mapa de memoria del Ejercicio 4:
 *   - 3 estudiantes
 *   - 1 evento
 *   - 1 sala
 *   - 2 actividades (1 Charla, 1 Taller)
 *   - 2 inscripciones en la Charla, 2 inscripciones en el Taller
 */
public class App {

    public static void main(String[] args) {

        System.out.println("=== TP1 - Paradigmas de Programación - UTN FRM ===\n");

        // ----- Ejercicio 1: creación de evento -----
        EventoUniversitario evento1 = new EventoUniversitario("EV01", "Jornada de Tecnología", 10000, false);

        // ----- Ejercicio 2/3: estudiantes, sala, actividades, inscripciones -----
        // a. Se registran estudiantes
        Estudiante e1 = new Estudiante("50001", "Ana Gómez");
        Estudiante e2 = new Estudiante("50002", "Luis Pérez");
        Estudiante e3 = new Estudiante("50003", "Marta Ruiz");

        // c. Se asigna una sala al evento
        Sala salaMagna = new Sala(1, "Sala Magna");
        evento1.asignarSala(salaMagna);

        // d. Se crean actividades del evento (Charla y Taller, polimorfismo)
        evento1.crearActividad(1, "Introducción a Java", 30, "Charla", "Ing. Roberto Díaz");
        evento1.crearActividad(2, "Taller de Spring Boot", 20, "Taller", true);

        Actividad charla = evento1.getActividades().get(0);
        Actividad taller = evento1.getActividades().get(1);

        // e. Se inscriben estudiantes en cada actividad
        charla.inscribir(e1);
        charla.inscribir(e2);

        taller.inscribir(e2);
        taller.inscribir(e3);

        // Constructor de copia (Ejercicio 1), creado ahora para demostrar
        // que también copia la sala asignada y la lista de actividades.
        EventoUniversitario copiaEvento1 = new EventoUniversitario(evento1);

        // f. Resumen del evento y de sus actividades (identificación polimórfica)
        evento1.mostrarDatos();
        System.out.println();
        for (Actividad a : evento1.getActividades()) {
            a.mostrarInscripciones();
        }

        System.out.println("\n--- Copia de evento1 (constructor de copia, Ejercicio 1) ---");
        copiaEvento1.mostrarDatos();

        // g. Total de eventos creados
        System.out.println("\nTotal de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}
