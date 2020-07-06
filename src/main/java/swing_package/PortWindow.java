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
    JTextField textField = new JTextField();

    public void display(){
        frame.setTitle("Подключение");
        label.setText("Введите порт");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setSize(300,200);

        setButton.addActionListener(new SetButton());

        Font font = new Font("Verdana", Font.PLAIN,30);
        label.setFont(font);

        frame.add(label, BorderLayout.PAGE_START);
        frame.add(textField, BorderLayout.CENTER);
        frame.add(setButton, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }

    class  SetButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            LoginWindow o = new LoginWindow();
            o.display();
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        PortWindow obj = new PortWindow();
        obj.display();
    }

}
