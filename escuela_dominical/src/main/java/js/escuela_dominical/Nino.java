package js.escuela_dominical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.Period;
import java.time.LocalDate;

public class Nino extends Persona {
    Grupo grupo;
    ArrayList<Tematica> temasVistos;
    HashMap<String, String> acudientes;
    ArrayList<Leccion> lecciones;
    int numAsistencias;
    String observaciones;

    Scanner scanner = new Scanner(System.in);

    Nino(String nombre, String genero, int año, int mes, int dia, String contacto, String acudiente) {
        super(nombre, genero, año, mes, dia, contacto);
        this.acudientes = new HashMap<>();
        acudiente = acudiente.concat(" ");
        contacto = " " + contacto;
        acudientes.put(acudiente, contacto);
        this.lecciones = new ArrayList<>();
        this.numAsistencias = 0;
        this.observaciones = "";
    }

    public void agregarAcudiente(String acudiente, String contacto) {
        acudiente = acudiente.concat(" ");
        contacto = " " + contacto;
        acudientes.put(acudiente, contacto);
        System.out.println("Acudiente agregado exitosamente.");
        System.out.println(acudientes);
    }

    public void asignarGrupo(Grupo grupo) {
        if (this.grupo == null) {
            this.grupo = grupo;
            grupo.ninosRegistrados.add(this);
            System.out.println(nombre + " ha sido asignado al grupo " + grupo.getNombre());
        } else {
            System.out.println(nombre + " ya está asignado a un grupo.");
        }
    }

    public void registrarAsistencia(Leccion leccion) {
        if (grupo != null) {
            lecciones.add(leccion);
            System.out.println(nombre + " ha registrado su asistencia en la lección " + leccion.nombre);
        } else {
            System.out.println(nombre + " no está asignado a ningún grupo.");
        }
    }

    public void verLecciones() {
        if (lecciones.isEmpty()) {
            System.out.println(nombre + " no ha asistido a ninguna lección todavía.");
        } else {
            System.out.println("Lecciones asistidas por " + nombre + ":");
            for (Leccion leccion : lecciones) {
                System.out.println("- " + leccion.nombre);
            }
        }
    }

    public void agregarObservacion(String nuevaObservacion) {
        if (observaciones.isEmpty()) {
            observaciones = nuevaObservacion;
        } else {
            observaciones += "\n- " + nuevaObservacion;
        }
        System.out.println("Observación agregada exitosamente.");
    }

    public void agregarLeccion(Leccion leccion) {
        lecciones.add(leccion);
        System.out.println("Lección " + leccion.nombre + " agregada exitosamente.");
    }

    public void actualizarDatos(String nuevoNombre, String nuevoGenero, String nuevoContacto) {
        this.nombre = nuevoNombre;
        this.genero = nuevoGenero;
        this.contacto = nuevoContacto;
        System.out.println("Datos actualizados exitosamente.");
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Género: " + genero);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);

        Period edadActual = Period.between(fechaNacimiento, LocalDate.now());
        System.out.println("Edad: " + edadActual.getYears() + " años");

        System.out.println("Fecha de Ingreso: " + fechaIngreso);

        if (grupo != null) {
            System.out.println("Grupo: " + grupo.getNombre());
        } else {
            System.out.println("Grupo: No asignado");
        }

        System.out.println("Acudientes:");
        for (String acudiente : acudientes.keySet()) {
            System.out.println("- " + acudiente + ": " + acudientes.get(acudiente));
        }

        System.out.println("Número de Asistencias: " + numAsistencias);
        System.out.println("Observaciones: " + (observaciones.isEmpty() ? "Ninguna" : observaciones));
    }
}
