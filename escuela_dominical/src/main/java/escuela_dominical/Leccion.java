package escuela_dominical;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class Leccion {
    public Grupo grupo;
    public String nombre;
    public Tematica tematica;
    public String temaEspecifico;
    public Maestro maestro;
    public Auxiliar auxiliar;
    public String textoBiblico;

    public LocalDate fecha;
    public HashMap<Nino,String> asistencia;
    public int cantidadAsistentes;
    public ArrayList<String> observaciones;

    Scanner scanner = new Scanner(System.in);

    public Leccion(Grupo grupo, String nombre, Tematica tematica,
    String temaEspecifico, Maestro maestro, String textoBiblico){

        this.grupo = grupo;
        this.nombre = nombre;
        this.tematica = tematica;
        this.temaEspecifico = temaEspecifico;
        this.maestro = maestro;
        this.textoBiblico = textoBiblico;
        this.auxiliar = null;

        this.fecha = LocalDate.now();
        this.asistencia = new HashMap<Nino,String>();
        this.cantidadAsistentes = asistencia.size();
        this.observaciones = new ArrayList<String>();

        maestro.agregarLeccion(this);
        grupo.agregarLeccion(this);
        tematica.agregarLeccion(grupo,this);

    }

   public Leccion(Grupo grupo, String nombre, Tematica tematica,
    String temaEspecifico, Maestro maestro, Auxiliar auxiliar, String textoBiblico){

        this.grupo = grupo;
        this.nombre = nombre;
        this.tematica = tematica;
        this.temaEspecifico = temaEspecifico;
        this.maestro = maestro;
        this.textoBiblico = textoBiblico;
        this.auxiliar = auxiliar;

        this.fecha = LocalDate.now();
        this.asistencia = new HashMap<Nino,String>();
        this.cantidadAsistentes = asistencia.size();
        this.observaciones = new ArrayList<String>();

        maestro.agregarLeccion(this);
        grupo.agregarLeccion(this);
        auxiliar.agregarLeccion(this);
        tematica.agregarLeccion(grupo,this);

    }

    public void hacerObservacion(String observacion){
        observaciones.add(observacion);
    }

    public void tomarAsistencia(){
        for(Nino nino : grupo.ninosRegistrados){
            System.out.println("Asistio (si/no): ");
            String asistio = scanner.nextLine().trim().toLowerCase();
            asistencia.put(nino,asistio);
            if (asistio.equals("si")) {
                nino.lecciones.add(this);
                cantidadAsistentes++;  // Aumenta el contador de asistentes
            }
        }
    }

    public void verAsistencia() {
        System.out.println("Asistencia de la lección '" + nombre + "':");
        for (Nino nino : asistencia.keySet()) {
            System.out.println(nino.nombre + ": " + asistencia.get(nino));
        }
    }

    public int getCantidadAsistentes(){
        return cantidadAsistentes;
    }

    public void mostrarDatos() {
        System.out.println("Grupo: " + grupo.getNombre());
        System.out.println("Nombre de la lección: " + nombre);
        System.out.println("Temática: " + tematica.titulo);
        System.out.println("Tema específico: " + temaEspecifico);
        System.out.println("Maestro a cargo: " + maestro.nombre);
        System.out.println("Texto bíblico: " + textoBiblico);
        System.out.println("Fecha: " + fecha);
    }
}