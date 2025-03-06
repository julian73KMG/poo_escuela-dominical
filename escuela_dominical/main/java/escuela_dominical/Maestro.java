package escuela_dominical;


import java.util.ArrayList;
import java.util.HashMap;

public class Maestro extends Persona {
    // Atributos
    HashMap<Tematica, String> temasEnsenados;
    public ArrayList<Leccion> lecciones;

    public Maestro(String nombre, String genero, int año, int mes, int dia, String contacto) {
        super(nombre, genero, año, mes, dia, contacto);
        this.temasEnsenados = new HashMap<>();
        this.lecciones = new ArrayList<>();
    }

    @Override
    public void actualizarContacto(String nuevoContacto) {
        this.contacto = nuevoContacto;
        System.out.println("El contacto de " + nombre + " ha sido actualizado a: " + nuevoContacto);
    }

    public void agregarLeccion(Leccion leccion) {
        lecciones.add(leccion);
        actualizarDatos();
    }

    public void actualizarDatos() {
        temasEnsenados.clear();
        for (Leccion leccion : lecciones) {
            Tematica tematica = leccion.tematica;
            temasEnsenados.put(tematica, tematica.titulo);
        }
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();  // Reutiliza el método de la clase Persona
        System.out.println("Cantidad de lecciones impartidas: " + lecciones.size());
        System.out.println("Temáticas enseñadas: " + temasEnsenados.keySet());
    }

    public void verLecciones() {
        if (lecciones.isEmpty()) {
            System.out.println("No hay lecciones impartidas todavía.");
        } else {
            System.out.println("Lecciones dadas:");
            for (Leccion leccion : lecciones) {
                leccion.mostrarDatos();
            }
        }
    }
}