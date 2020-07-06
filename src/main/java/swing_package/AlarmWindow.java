package swing_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;


public class AlarmWindow {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JButton okButton = new JButton("ok");
    JPanel panel = new JPanel();

    public void display(String title, String message){
        frame.setTitle(title);
        label.setText(message);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(250,200);
        panel.setLayout(new BorderLayout());

        Font font = new Font("Verdana", Font.PLAIN,25);
        label.setFont(font);

        panel.add(label, BorderLayout.PAGE_START);
        panel.add(okButton, BorderLayout.PAGE_END);
        frame.add(panel);

        frame.setVisible(true);
    }

    class  Okbutton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        AlarmWindow obj = new AlarmWindow();
        obj.display("dsfdsfsdf", "zdfdfdv");
    }
}
