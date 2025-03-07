package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatos {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:escuela_dominical.db"; // Base de datos local

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Insertar Acudientes
            stmt.executeUpdate("INSERT INTO Acudientes (nombre, telefono) VALUES "
                    + "('Carlos Pérez', '3123456789'),"
                    + "('María Gómez', '3109876543'),"
                    + "('Luis Rodríguez', '3156781234');");

            // Insertar Estudiantes
            stmt.executeUpdate("INSERT INTO Estudiantes (nombre, edad, id_acudiente) VALUES "
                    + "('Juan Pérez', 8, 1),"
                    + "('Ana Gómez', 10, 2),"
                    + "('Pedro Rodríguez', 9, 3),"
                    + "('Luisa Fernández', 7, 1);");

            // Insertar Grupos
            stmt.executeUpdate("INSERT INTO Grupos (nombre) VALUES "
                    + "('Grupo 1'),"
                    + "('Grupo 2'),"
                    + "('Grupo 3');");

            // Insertar Temáticas
            stmt.executeUpdate("INSERT INTO Tematicas (nombre) VALUES "
                    + "('Matemáticas'),"
                    + "('Ciencias Naturales'),"
                    + "('Historia');");

            // Insertar Lecciones
            stmt.executeUpdate("INSERT INTO Lecciones (nombre, id_grupo, id_tematica, profesor_titular, profesor_auxiliar) VALUES "
                    + "('Sumas y Restas', 1, 1, 'Profesor A', 'Profesor Aux 1'),"
                    + "('La Célula', 2, 2, 'Profesor B', 'Profesor Aux 2'),"
                    + "('Edad Media', 3, 3, 'Profesor C', 'Profesor Aux 3');");

            // Insertar Actividades Lúdicas
            stmt.executeUpdate("INSERT INTO ActividadesLudicas (nombre, id_tematica) VALUES "
                    + "('Juego de Números', 1),"
                    + "('Experimentos con Plantas', 2),"
                    + "('Teatro Histórico', 3);");

            System.out.println("Datos de prueba insertados correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
}
