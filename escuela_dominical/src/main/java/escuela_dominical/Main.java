package escuela_dominical;
import java.util.ArrayList;
import java.util.Scanner;
import Frames.Principal;
import Frames.Auxiliar;
import Frames.GestionarTematicas;
import Frames.Grupos;
import Frames.Lecciones;
import Frames.Login;
import Frames.Maestro;
import Frames.Principal;
import Frames.Principal;
import Frames.Principal;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Nino> ninos = new ArrayList<>();
        ArrayList<Grupo> grupos = new ArrayList<>();
        ArrayList<Maestro> maestros = new ArrayList<>();
        ArrayList<Auxiliar> auxiliares = new ArrayList<>();
        ArrayList<Tematica> tematicas = new ArrayList<>();
        
       new Principal().setVisible(true);
        
        
        
        int opcion;
        do {
            System.out.println("\n----- MENÚ ESCUELA DOMINICAL -----");
            System.out.println("1. Registrar Niño");
            System.out.println("2. Crear Grupo");
            System.out.println("3. Registrar Maestro");
            System.out.println("4. Registrar Auxiliar");
            System.out.println("5. Crear Temática");
            System.out.println("6. Crear Lección");
            System.out.println("7. Tomar Asistencia");
            System.out.println("8. Ver Datos de un Niño");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombreNino = scanner.nextLine();

                    System.out.print("Género: ");
                    String genero = scanner.nextLine();

                    int anio = 0, mes = 0, dia = 0;
                        boolean validInput = false;

                    // Validate Year of Birth
                    while (!validInput) {
                        try {
                            System.out.print("Año de nacimiento: ");
                            anio = scanner.nextInt();
                            if (anio < 1900 || anio > 2025) { // Adjust valid year range as needed
                                System.out.println("Por favor, ingrese un año válido.");
                                continue;
                            }
                            validInput = true;
                        } catch (Exception e) {
                            System.out.println("Entrada inválida. Debe ingresar un número entero.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                    }

                    validInput = false; // Reset flag for the next input

                    // Validate Month of Birth
                    while (!validInput) {
                        try {
                            System.out.print("Mes de nacimiento: ");
                            mes = scanner.nextInt();
                            if (mes < 1 || mes > 12) {
                                System.out.println("Por favor, ingrese un mes válido (1-12).");
                                continue;
                            }
                            validInput = true;
                        } catch (Exception e) {
                            System.out.println("Entrada inválida. Debe ingresar un número entero.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                    }

                    validInput = false; // Reset flag

                    // Validate Day of Birth
                    while (!validInput) {
                        try {
                            System.out.print("Día de nacimiento: ");
                            dia = scanner.nextInt();
                            if (dia < 1 || dia > 31) {
                                System.out.println("Por favor, ingrese un día válido (1-31).");
                                continue;
                            }
                            validInput = true;
                        } catch (Exception e) {
                            System.out.println("Entrada inválida. Debe ingresar un número entero.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                    }

                    scanner.nextLine(); // Clear the buffer

                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Acudiente: ");
                    String acudiente = scanner.nextLine();

                    // Create and add the child object
                    Nino nino = new Nino(nombreNino, genero, anio, mes, dia, telefono, acudiente);
                    ninos.add(nino);

                    System.out.println("Niño registrado exitosamente.");
                    break;
                case 2:
                    System.out.print("\nNombre del grupo: ");
                    String nombreGrupo = scanner.nextLine();
                    Grupo grupo = new Grupo(nombreGrupo);
                    grupos.add(grupo);
                    System.out.println("Grupo creado exitosamente.");
                    break;
                case 3:
                    System.out.print("\nNombre del maestro: ");
                    String nombreMaestro = scanner.nextLine();
                    System.out.print("Género: ");
                    String generoMaestro = scanner.nextLine();
                    System.out.print("Año de nacimiento: ");
                    int anioM = scanner.nextInt();
                    System.out.print("Mes de nacimiento: ");
                    int mesM = scanner.nextInt();
                    System.out.print("Día de nacimiento: ");
                    int diaM = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefonoM = scanner.nextLine();
                    //Maestro maestro = new Maestro(nombreMaestro, generoMaestro, anioM, mesM, diaM, telefonoM);
                    //maestros.add(maestro);
                    System.out.println("Maestro registrado exitosamente.");
                    break;
                case 4:
                    System.out.print("\nNombre del auxiliar: ");
                    String nombreAuxiliar = scanner.nextLine();
                    System.out.print("Género: ");
                    String generoAux = scanner.nextLine();
                    System.out.print("Año de nacimiento: ");
                    int anioA = scanner.nextInt();
                    System.out.print("Mes de nacimiento (en número): ");
                    int mesA = scanner.nextInt();
                    System.out.print("Día de nacimiento: ");
                    int diaA = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefonoA = scanner.nextLine();
                    //Auxiliar auxiliar = new Auxiliar(nombreAuxiliar, generoAux, anioA, mesA, diaA, telefonoA);
                    //auxiliares.add(auxiliar);
                    System.out.println("Auxiliar registrado exitosamente.");
                    break;
                case 5:
                    System.out.print("\nTítulo de la temática: ");
                    String tituloTematica = scanner.nextLine();
                    Tematica tematica = new Tematica(tituloTematica);
                    tematicas.add(tematica);
                    System.out.println("Temática creada exitosamente.");
                    break;
                case 6:
                    if (grupos.isEmpty() || maestros.isEmpty() || tematicas.isEmpty()) {
                        System.out.println("\nDebe crear al menos un grupo, maestro y temática antes de crear una lección.");
                        break;
                    }
                    System.out.print("\nNombre de la lección: ");
                    String nombreLeccion = scanner.nextLine();
                    Grupo grupoLeccion = grupos.get(0);
                    Maestro maestroLeccion = maestros.get(0);
                    Tematica tematicaLeccion = tematicas.get(0);
                    System.out.print("Tema específico: ");
                    String temaEspecifico = scanner.nextLine();
                    System.out.print("Texto bíblico: ");
                    String textoBiblico = scanner.nextLine();
                    //Leccion leccion = new Leccion(grupoLeccion, nombreLeccion, tematicaLeccion, temaEspecifico, maestroLeccion, textoBiblico);
                    System.out.println("Lección creada exitosamente.");
                    break;
                case 7:
                    if (ninos.isEmpty()) {
                        System.out.println("\nNo hay niños registrados para tomar asistencia.");
                        break;
                    }
                    System.out.println("Tomando asistencia para el primer niño registrado:");
                    ninos.get(0).mostrarDatos();
                    break;
                case 8:
                    if (ninos.isEmpty()) {
                        System.out.println("No hay niños registrados.");
                        break;
                    }
                    System.out.println("Datos del primer niño registrado:");
                    ninos.get(0).mostrarDatos();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}