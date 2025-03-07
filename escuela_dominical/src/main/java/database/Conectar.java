package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    private static final String URL = "jdbc:sqlite:ninos.db"; // Verifica la ruta
    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:escuela_dominical.db"); // Usa el nombre correcto de tu archivo .db
            System.out.println("Conexión exitosa a SQLite");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return con;
    }
}
