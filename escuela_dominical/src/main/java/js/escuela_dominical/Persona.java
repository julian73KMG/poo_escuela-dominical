package js.escuela_dominical;

import java.time.Period;
import java.time.LocalDate;

public class Persona {
    String nombre;
    int añoNacimiento;
    int mesNacimiento;
    int diaNacimiento;
    LocalDate fechaNacimiento;
    int edad;
    String genero;
    LocalDate fechaIngreso;
    String contacto;

    public Persona(String nombre, String genero,
    int añoNacimiento, int mesNacimiento, int diaNacimiento, String contacto){
        this.nombre = nombre;
        this.añoNacimiento = añoNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.diaNacimiento = diaNacimiento;
        this.fechaNacimiento = LocalDate.of(añoNacimiento, mesNacimiento, diaNacimiento);
        this.edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        this.genero = genero;
        this.fechaIngreso = LocalDate.now();
        this.contacto = contacto;
    }

    public void mostrarDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Género: " + genero);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Fecha de Ingreso: " + fechaIngreso);
        System.out.println("Contacto: " + contacto);
    }

    public void actualizarContacto(String nuevoContacto){
        this.contacto = nuevoContacto;
        System.out.println("Contacto actualizado exitosamente.");
    }
}