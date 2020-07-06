package swing_package;

import javax.swing.*;
import java.awt.*;

public class ProgramWindow {
    JFrame frame;
    JPanel panelLeft = new JPanel();
    JPanel panelBottom = new JPanel();;
    JPanel coordinates = new JPanel();;

    public void display(){
        frame = new JFrame("program");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JMenuBar jMenuBar = new JMenuBar();
        JMenu file = new JMenu("FILE");
        JMenu language = new JMenu("language");
        jMenuBar.add(file);
        jMenuBar.add(language);
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem langRus = new JMenuItem("Русский");
        JMenuItem LangEng = new JMenuItem("English");
        file.add(exit);
        language.add(langRus);
        language.add(LangEng);

        panelLeft.setBackground(Color.GREEN);
        panelBottom.setBackground(Color.RED);

        //MyComponent component = new MyComponent();
        //coordinates.add(component);

        //frame.getContentPane().add(BorderLayout.PAGE_START, jMenuBar);
        //frame.add(panelLeft, BorderLayout.LINE_START);
        //frame.add(panelBottom, BorderLayout.PAGE_END);
        frame.add(coordinates);

        frame.setVisible(true);
    }
}
