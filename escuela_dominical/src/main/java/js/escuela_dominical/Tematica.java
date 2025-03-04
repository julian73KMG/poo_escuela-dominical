package js.escuela_dominical;

import java.util.ArrayList;
import java.util.HashMap;

public class Tematica {
    String titulo;
    HashMap<Grupo, Leccion> lecciones;
    ArrayList<ActividadLudica> actividadesLudicas;

    Tematica(String titulo) {
        this.titulo = titulo;
        this.lecciones = new HashMap<Grupo, Leccion>();
        this.actividadesLudicas = new ArrayList<ActividadLudica>();
    }

    public void mostrarDatos() {
        System.out.println("Título de la temática: " + titulo);
        System.out.println("Número de lecciones asociadas: " + lecciones.size());
        verLecciones();
        verActividadesLudicas();
    }

    public void verLecciones() {
        if (lecciones.isEmpty()) {
            System.out.println("No hay lecciones asociadas a esta temática.");
        } else {
            System.out.println("Lecciones asociadas a la temática " + titulo + ":");
            for (Grupo grupo : lecciones.keySet()) {
                System.out.println("Grupo: " + grupo.getNombre() + " - Lección: " + lecciones.get(grupo).nombre);
            }
        }
    }

    public void agregarLeccion(Grupo grupo, Leccion leccion) {
        lecciones.put(grupo, leccion);
        System.out.println("Lección " + leccion.nombre + " agregada exitosamente al grupo " + grupo.getNombre() + " en la temática " + titulo);
    }

    public void agregarActividadLudica(ActividadLudica actividad) {
        actividadesLudicas.add(actividad);
        System.out.println("Actividad lúdica agregada exitosamente a la temática " + titulo);
    }

    public void verActividadesLudicas() {
        if (actividadesLudicas.isEmpty()) {
            System.out.println("No hay actividades lúdicas asociadas a esta temática.");
        } else {
            System.out.println("Actividades lúdicas asociadas a la temática " + titulo + ":");
            for (ActividadLudica actividad : actividadesLudicas) {
                actividad.mostrarDatos();
            }
        }
    }

    public void actualizarDatos(String nuevoTitulo) {
        this.titulo = nuevoTitulo;
        System.out.println("El título de la temática ha sido actualizado a: " + nuevoTitulo);
    }
}
