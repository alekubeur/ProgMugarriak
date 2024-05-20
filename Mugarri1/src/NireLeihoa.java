import javax.swing.*;
import java.awt.*;

public class NireLeihoa {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Interfaze Proiektua");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 300);

        Container nagusia = frame.getContentPane();
        nagusia.setLayout(new BorderLayout());

        JPanel iparra = new JPanel();

        iparra.setLayout(new FlowLayout(FlowLayout.CENTER));
        iparra.add(new JCheckBox("Katniss"));
        iparra.add(new JCheckBox("Peeta"));

        JPanel ekialdea = new JPanel();
        ekialdea.setPreferredSize(new Dimension(250, 100));
        ekialdea.setLayout(new BoxLayout(ekialdea, BoxLayout.Y_AXIS));
        ekialdea.add(new JRadioButton("OPT 1"));
        ekialdea.add(new JRadioButton("OPT 2"));
        ekialdea.add(new JRadioButton("OPT 3"));

        JPanel hegoa = new JPanel();
        hegoa.setLayout(new BoxLayout(hegoa, BoxLayout.Y_AXIS));
        hegoa.setPreferredSize(new Dimension(200, 50));
        hegoa.setLayout(new FlowLayout(FlowLayout.LEFT));
        hegoa.add(new JButton("But 1"));
        hegoa.add(new JButton("But 2"));

        JPanel erdia = new JPanel(new GridLayout(2, 2));
        ImageIcon imageIcon = new ImageIcon("../descarga.png");
        JLabel label1 = new JLabel(imageIcon);
        JLabel label2 = new JLabel(imageIcon);
        JLabel label3 = new JLabel(imageIcon);
        JLabel label4 = new JLabel(imageIcon);
        erdia.add(label1);
        erdia.add(label2);
        erdia.add(label3);
        erdia.add(label4);

        nagusia.add(iparra, BorderLayout.NORTH);
        nagusia.add(ekialdea, BorderLayout.EAST);
        nagusia.add(hegoa, BorderLayout.SOUTH);
        nagusia.add(erdia, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
