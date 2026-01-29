import javax.swing.*;
import java.awt.*;

public class GUI extends javax.swing.JFrame {
    public GUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel,  BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Social Media Platform Simulation");
        frame.pack();
        frame.setVisible(true);



        JButton button1 = new JButton();
        JButton button2 = new JButton();


    }


}