package swing_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPortWindow {
    JFrame frame;

    public void display(){
        frame = new JFrame("connection");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel port = new JLabel("Port");
        port.setFont(new Font("Verdana", Font.PLAIN,30));
        port.setBounds(140,30,80,25);
        panel.add(port);

        JTextField portText = new JTextField(20);
        portText.setBounds(90,70,165,25);
        panel.add(portText);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(10, 130, 80, 25);
        panel.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });

        JButton setButton = new JButton("Set");
        setButton.setBounds(140, 100, 60, 25);
        panel.add(setButton);
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //do something
                LoginWindow o = new LoginWindow();
                frame.dispose();
                o.display();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        NewPortWindow o = new NewPortWindow();
        o.display();
    }
}
