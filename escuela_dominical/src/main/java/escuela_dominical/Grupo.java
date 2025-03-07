package escuela_dominical;

import java.util.ArrayList;
import java.util.HashMap;

public class Grupo {
    public String nombre;
    public ArrayList<Nino> ninosRegistrados;
    public int numeroNinos;
    public ArrayList<Leccion> lecciones;
    public int asistenciaPromedio;
    public HashMap<Tematica, String> temasVistos;
    public HashMap<Tematica, Integer> numTemasVistos;

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.ninosRegistrados = new ArrayList<>();
        this.lecciones = new ArrayList<>();
        this.temasVistos = new HashMap<>();
        this.numTemasVistos = new HashMap<>();
        this.numeroNinos = ninosRegistrados.size();
        actualizarDatos();
    }


    public void actualizarDatos() {
        // Calcular asistencia promedio
        int totalAsistentes = 0;
        for (Leccion leccion : lecciones) {
            totalAsistentes += leccion.getCantidadAsistentes();
        }
        this.asistenciaPromedio = lecciones.isEmpty() ? 0 : totalAsistentes / lecciones.size();

        // Actualizar temáticas vistas y número de veces vistas
        temasVistos.clear();
        numTemasVistos.clear();

        for (Leccion leccion : lecciones) {
            Tematica tema = leccion.tematica;
            temasVistos.put(tema, tema.titulo);
            numTemasVistos.put(tema, numTemasVistos.getOrDefault(tema, 0) + 1);
        }
    }

    public void agregarLeccion(Leccion leccion) {
        lecciones.add(leccion);
        actualizarDatos();
    }

    public void mostrarLecciones() {
        for (Leccion leccion : lecciones) {
            leccion.mostrarDatos();
        }
    }

    public void verNinosRegistrados() {
        for (Nino nino : ninosRegistrados) {
            nino.mostrarDatos();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void verTemasVistos() {
        if (temasVistos.isEmpty()) {
            System.out.println("No hay temáticas registradas.");
        } else {
            System.out.println("Temáticas vistas:");
            for (Tematica tematica : temasVistos.keySet()) {
                System.out.println("Título: " + tematica.titulo + ", Descripción: " + temasVistos.get(tematica));
            }
        }
    }

    public void numTemasVistos() {
        if (numTemasVistos.isEmpty()) {
            System.out.println("No hay conteo de temáticas vistas.");
        } else {
            System.out.println("Número de veces que se ha visto cada temática:");
            for (Tematica tematica : numTemasVistos.keySet()) {
                System.out.println("Título: " + tematica.titulo + ", Vistas: " + numTemasVistos.get(tematica));
            }
        }
    }

    public void mostrarDatos() {
        System.out.println("Nombre del grupo: " + nombre);
        System.out.println("Número de niños registrados: " + numeroNinos);
        System.out.println("Asistencia promedio: " + asistenciaPromedio);
    }

    @Override
    public String toString() {
        return nombre;
    }
}