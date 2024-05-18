import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mugarri4";
        String usuario = "root";
        String contrasena = "aritz123";

        try (
                Connection conexion = DriverManager.getConnection(url, usuario, contrasena)) {
            System.out.println("Conexión exitosa!");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }



    }
}