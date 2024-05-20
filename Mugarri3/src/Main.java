import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Main {
    private static final String KARPETA = "Irudi";

    public static void main(String[] args) {
        String password = JOptionPane.showInputDialog("Pasahitza sartu:");
        if (!"damocles".equals(password)) {
            System.exit(0);
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(comboBoxPanel);

        JComboBox comboBox = new JComboBox(load_combo());
        comboBox.setMaximumSize(comboBox.getPreferredSize());
        comboBoxPanel.add(comboBox);

        ImageIcon imageIcon = new ImageIcon(KARPETA + "/" + comboBox.getItemAt(0));
        JLabel label = new JLabel(imageIcon);
        panel.add(label);

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(checkBoxPanel);

        JCheckBox checkBox = new JCheckBox("Check");
        checkBox.setSelected(true);
        checkBoxPanel.add(checkBox);

        JTextField textField = new JTextField(10);
        checkBoxPanel.add(textField);

        JPanel rightPanel = new JPanel();
        frame.getContentPane().add(rightPanel, BorderLayout.SOUTH);
        rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton button = new JButton("Guardar");
        rightPanel.add(button);

        comboBox.addActionListener(new ComboListener(label, comboBox));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    String selectedImage = (String) comboBox.getSelectedItem();
                    String comment = textField.getText();
                    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(selectedImage + ".txt", true)))) {
                        out.println(selectedImage + " - " + comment);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "Agur");
            }
        });

        frame.setVisible(true);
    }

    private static String[] load_combo() {
        File folder = new File(KARPETA);
        return folder.list((dir, name) -> name.endsWith(".jpg"));
    }

    static class ComboListener implements ActionListener {
        private final JLabel label;
        private final JComboBox comboBox;

        public ComboListener(JLabel label, JComboBox comboBox) {
            this.label = label;
            this.comboBox = comboBox;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedImage = (String) comboBox.getSelectedItem();
            label.setIcon(new ImageIcon(KARPETA + "/" + selectedImage));
        }
    }
}
