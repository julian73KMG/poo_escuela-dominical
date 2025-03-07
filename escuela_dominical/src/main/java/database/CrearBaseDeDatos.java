package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBaseDeDatos {
    public static void main(String[] args) {
       // String url = "jdbc:sqlite:escuela_dominical.db"; // Base de datos local
          String url = "jdbc:sqlite:ninos.db"; // Nombre de la base de datos

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Crear tabla de Acudientes
            String acudientes = "CREATE TABLE IF NOT EXISTS Acudientes ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nombre TEXT NOT NULL, "
                    + "telefono TEXT NOT NULL)";
            stmt.execute(acudientes);

            // Crear tabla de Estudiantes
            String estudiantes = "CREATE TABLE IF NOT EXISTS Estudiantes ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nombre TEXT NOT NULL, "
                    + "edad INTEGER NOT NULL, "
                    + "id_acudiente INTEGER, "
                    + "FOREIGN KEY(id_acudiente) REFERENCES Acudientes(id))";
            stmt.execute(estudiantes);

            // Crear tabla de Grupos
            String grupos = "CREATE TABLE IF NOT EXISTS Grupos ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nombre TEXT NOT NULL)";
            stmt.execute(grupos);

            // Crear tabla de Temáticas
            String tematicas = "CREATE TABLE IF NOT EXISTS Tematicas ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nombre TEXT NOT NULL)";
            stmt.execute(tematicas);

            // Crear tabla de Lecciones
            String lecciones = "CREATE TABLE IF NOT EXISTS Lecciones ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nombre TEXT NOT NULL, "
                    + "id_grupo INTEGER, "
                    + "id_tematica INTEGER, "
                    + "profesor_titular TEXT, "
                    + "profesor_auxiliar TEXT, "
                    + "FOREIGN KEY(id_grupo) REFERENCES Grupos(id), "
                    + "FOREIGN KEY(id_tematica) REFERENCES Tematicas(id))";
            stmt.execute(lecciones);

            // Crear tabla de Actividades Lúdicas
            String actividades = "CREATE TABLE IF NOT EXISTS ActividadesLudicas ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nombre TEXT NOT NULL, "
                    + "id_tematica INTEGER, "
                    + "FOREIGN KEY(id_tematica) REFERENCES Tematicas(id))";
            stmt.execute(actividades);

            System.out.println("Base de datos creada correctamente");

        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos: " + e.getMessage());
        }
    }
}
