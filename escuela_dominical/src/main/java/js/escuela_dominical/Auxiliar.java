package js.escuela_dominical;
import java.util.ArrayList;

public class Auxiliar extends Persona {
    // Atributos
    ArrayList<Leccion> lecciones = new ArrayList<>();

    // Constructor
    Auxiliar(String nombre, String genero, int año, int mes, int dia, String contacto) {
        super(nombre, genero, año, mes, dia, contacto);
    }

    @Override
    public void actualizarContacto(String nuevoContacto) {
        this.contacto = nuevoContacto;
        System.out.println("El contacto de " + nombre + " ha sido actualizado a: " + nuevoContacto);
    }

    // Método para agregar una lección
    public void agregarLeccion(Leccion leccion) {
        lecciones.add(leccion);
        System.out.println("Lección " + leccion.nombre + " agregada a " + nombre);
    }

    // Método para actualizar los datos del auxiliar
    public void actualizarDatos() {
        System.out.println("Actualizando datos de " + nombre);
        System.out.println("Total de lecciones actuales: " + lecciones.size());
    }

    public void verLecciones() {
        if (lecciones.isEmpty()) {
            System.out.println(nombre + " aún no tiene lecciones asignadas.");
        } else {
            System.out.println("Lecciones asignadas a " + nombre + ":");
            for (Leccion leccion : lecciones) {
                leccion.mostrarDatos();
            }
        }
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Cantidad de lecciones asignadas: " + lecciones.size());
    }
}