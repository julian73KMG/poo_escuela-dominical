package escuela_dominical;

import java.util.ArrayList;

public class ActividadLudica {
    public ArrayList<String> materiales;
    public String descripcion;
    public Tematica tematica;

    public ActividadLudica(Tematica tematica) {
        this.materiales = new ArrayList<>();
        this.descripcion = "";
        this.tematica = tematica;
    }

    public void agregarMaterial(String material) {
        materiales.add(material);
        System.out.println("Material agregado: " + material);
    }

    public void mostrarDatos() {
        System.out.println("Descripción de la actividad: " + descripcion);
        if (materiales.isEmpty()) {
            System.out.println("No se han registrado materiales para esta actividad.");
        } else {
            System.out.println("Materiales necesarios:");
            for (String material : materiales) {
                System.out.println("- " + material);
            }
        }
    }

    public void actualizarDescripcion(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
        System.out.println("Descripción actualizada a: " + nuevaDescripcion);
    }
}