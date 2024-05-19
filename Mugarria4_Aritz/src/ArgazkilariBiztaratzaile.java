import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ArgazkilariBiztaratzaile extends JFrame {
    String url = "jdbc:mysql://localhost:3306/mugarri4";
    String erabiltzailea = "root";
    String pasahitza = "aritz123";
    Connection konexioa;
    Date data ;
    DefaultListModel modeloa;
    JComboBox comboBox;
    JList lista;

    public void konexioaSortu() {
        try {
            konexioa = DriverManager.getConnection(url, erabiltzailea, pasahitza);
            System.out.println("Konektatuta");
        } catch (SQLException e) {
            System.out.println("Errorea");
            e.printStackTrace();
        }
    }

    public void interfazeaSortu() {
        konexioaSortu();

        setLayout(new GridLayout(2, 2));

        JPanel goiEzkPanela = new JPanel(new FlowLayout(FlowLayout.LEFT));
        goiEzkPanela.add(new JLabel("Argazkilari:"));
        JComboBox comboBox = new JComboBox();
        comboBox.setPreferredSize(new Dimension(150, 20));
        goiEzkPanela.add(comboBox);

        JPanel goiEskPanela = new JPanel(new FlowLayout(FlowLayout.LEFT));
        goiEskPanela.add(new JLabel("Argazkiak honen ondoren:"));
        JXDatePicker datePicker = new JXDatePicker();
        goiEskPanela.add(datePicker);
        datePicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                data = datePicker.getDate();
            }
        });

        modeloa = new DefaultListModel();
        JList lista = new JList(modeloa);
        JScrollPane scrollPane = new JScrollPane(lista);

        JLabel etiketa = new JLabel();

        add(goiEzkPanela);
        add(goiEskPanela);
        add(scrollPane);
        add(etiketa);

        setTitle("Argazkigintza");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Argazkilari[] argazkilariak = Argazkilari.lortuArgazkilariGuztiak(konexioa);
        for (Argazkilari argazkilari : argazkilariak) {
            comboBox.addItem(argazkilari);
        }

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                argazkiakKargatu();
            }
        });

        lista.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    argazkiaErakutsi();
                }
            }
        });
    }

    private void argazkiakKargatu() {
        modeloa.clear();
        Argazkilari argazkilari = (Argazkilari) comboBox.getSelectedItem();
        JXDatePicker datePicker = new JXDatePicker();
        datePicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                data = datePicker.getDate();
            }
        });
        try {
            String kontsulta = "SELECT * FROM Argazkia WHERE IdArgazkilari = ? AND Data >= ?";
            PreparedStatement ps = konexioa.prepareStatement(kontsulta);
            ps.setInt(1, argazkilari.getIdArgazkilari());
            if (data != null) {
                ps.setDate(2, new java.sql.Date(data.getTime()));
            } else {
                ps.setDate(2, new java.sql.Date(0));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idArgazki = rs.getInt("IdArgazki");
                String izenburua = rs.getString("Izenburua");
                Date dataArgazkia = rs.getDate("Data");
                String fitxategia = rs.getString("Fitxategia");
                int bistaratzeKop = rs.getInt("BistaratzeKop");
                int idArgazkilari = rs.getInt("IdArgazkilari");
                modeloa.addElement(new Argazkia(idArgazki, izenburua, dataArgazkia, fitxategia, bistaratzeKop, idArgazkilari));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void argazkiaErakutsi() {
        Argazkia argazkia = (Argazkia) lista.getSelectedValue();
        ImageIcon ikonoa = new ImageIcon(argazkia.getFitxategia());

    }
}
