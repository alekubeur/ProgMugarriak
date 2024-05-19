import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;

public class ArgazkilariBiztaratzaile extends JFrame {
public void interfazea() {

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
}
}

