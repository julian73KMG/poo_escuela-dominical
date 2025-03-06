package escuela_dominical;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Ruta a la base de datos local (se guardará en la misma carpeta del proyecto)
            String url = "jdbc:sqlite:escuela_dominical.db"; 

            // Intentar conexión
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                System.out.println("Conexión exitosa a SQLite 🎉");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con SQLite: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
}
