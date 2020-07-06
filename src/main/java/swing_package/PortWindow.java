package swing_package;

import javax.sound.sampled.Port;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PortWindow {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JButton setButton = new JButton("set");
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JTextField textField = new JTextField();

    public void display(){
        frame = new JFrame("Подключение");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        setButton.addActionListener(new SetButton());

        label.setText("Введите порт");
        Font font = new Font("Verdana", Font.PLAIN,30);
        label.setBounds(120, 30, 60, 40);
        label.setFont(font);
        panel.add(label);

        textField.setBounds(120, 90, 60, 25);
        panel2.setLayout(new GridLayout(2, 1, 10, 0));

        frame.setLayout(new GridLayout(3, 1, 10, 0));
        frame.add(panel);
        frame.add(textField);
        Label label1 = new Label();
        panel2.add(label1);
        panel2.add(setButton, BorderLayout.PAGE_END);
        frame.add(panel2);

        frame.setVisible(true);
    }

    class  SetButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            LoginWindow o = new LoginWindow();
            o.display();
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        PortWindow obj = new PortWindow();
        obj.display();
    }

}
