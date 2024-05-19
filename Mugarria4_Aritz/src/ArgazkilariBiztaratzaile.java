import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class ArgazkilariBiztaratzaile extends JFrame {
    String url = "jdbc:mysql://localhost:3306/mugarri4";
    String usuario = "root";
    String contrasena = "aritz123";
    Connection conn;
    Date data;
    public void konexioa(){



        try{
                conn= DriverManager.getConnection(url, usuario, contrasena);

            System.out.println("Konektatuta");
        } catch (SQLException e) {
            System.out.println("Errorea");
            e.printStackTrace();
        }
    }
public void interfazea() {
    konexioa();

    setLayout(new GridLayout(2, 2));

    JPanel goiEzkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    goiEzkPanel.add(new JLabel("Argazkilari:"));
    JComboBox comboBox = new JComboBox();
    comboBox.setPreferredSize(new Dimension(150, 20));
    goiEzkPanel.add(comboBox);

    JPanel goiEskPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    goiEskPanel.add(new JLabel("Argazkiak honen ondoren:"));
    JXDatePicker datePicker = new JXDatePicker();
    goiEskPanel.add(datePicker);
    datePicker.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            data = (Date) datePicker.getDate();

        }
    });
    JList list = new JList();
    JScrollPane scrollPane = new JScrollPane(list);

    JLabel label = new JLabel();

    add(goiEzkPanel);
    add(goiEskPanel);
    add(scrollPane);
    add(label);

    setTitle("Argazkigintza");
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);


    try {
        konexioa();
        String consulta = "SELECT Izena FROM Argazkilari";
        PreparedStatement ps = conn.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();


        while (rs.next()) {
            comboBox.addItem(rs.getString("Izena"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }


}

}

