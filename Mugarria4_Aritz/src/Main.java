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
            System.out.println("Konektatuta");
        } catch (SQLException e) {
            System.out.println("Errorea");
            e.printStackTrace();
        }

ArgazkilariBiztaratzaile a1=new ArgazkilariBiztaratzaile();
        a1.interfazea();

    }
}