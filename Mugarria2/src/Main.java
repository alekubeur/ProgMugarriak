import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JSplitPane splitPane = new JSplitPane();
        frame.getContentPane().add(splitPane, BorderLayout.CENTER);

        JPanel ezkerra = new JPanel();
        splitPane.setLeftComponent(ezkerra);

        JComboBox comboBox = new JComboBox(new String[]{"python.txt", "c.txt", "java.txt"});
        JButton leftButton = new JButton("Ezabatu");
        ezkerra.add(comboBox);
        ezkerra.add(leftButton);

        JPanel eskubi = new JPanel();
        splitPane.setRightComponent(eskubi);
        eskubi.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        eskubi.add(scrollPane, BorderLayout.CENTER);

        JButton rightButton = new JButton("Itxi");
        eskubi.add(rightButton, BorderLayout.SOUTH);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fitx = (String) comboBox.getSelectedItem();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(fitx));
                    textArea.read(br, null);
                    br.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, fitx + " fitxategia ez da aurkitu.", "Errorea", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
