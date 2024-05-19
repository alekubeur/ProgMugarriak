import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Argazkilari {
    private int idArgazkilari;
    private String izena;
    private boolean saritua;

    public Argazkilari(int idArgazkilari, String izena, boolean saritua) {
        this.idArgazkilari = idArgazkilari;
        this.izena = izena;
        this.saritua = saritua;
    }

    public static Argazkilari[] lortuArgazkilariGuztiak(Connection konexioa) {
        ArrayList<Argazkilari> argazkilariZerrenda = new ArrayList<>();
        try {
            String kontsulta = "SELECT * FROM Argazkilari";
            PreparedStatement ps = konexioa.prepareStatement(kontsulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idArgazkilari = rs.getInt("IdArgazkilari");
                String izena = rs.getString("Izena");
                boolean saritua = rs.getBoolean("Saritua");
                argazkilariZerrenda.add(new Argazkilari(idArgazkilari, izena, saritua));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return argazkilariZerrenda.toArray(new Argazkilari[argazkilariZerrenda.size()]);
    }
}
