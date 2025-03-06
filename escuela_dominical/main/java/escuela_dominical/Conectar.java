package escuela_dominical;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Conectar {
    Connection cn;
    Statement st;
    public Connection conexion (){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/escuela_dominical","root","");
            System.out.println("Conectado");
            
        } catch (Exception e) {
            
            System.err.println(e.getMessage());
        }
        return cn;
    }

}
