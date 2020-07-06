package swing_package;

import javax.swing.*;
import java.awt.*;

public class ProgramWindow {
    JFrame frame;
    JPanel panelLeft = new JPanel();
    JPanel panelBottom = new JPanel();
    JPanel coordinates = new JPanel();

    JButton add = new JButton("add");
    JButton update = new JButton("update");
    JButton remove_by_id = new JButton("remove by id");
    JButton clear = new JButton("clear");
    JButton add_if_min = new JButton("add if min");
    JButton remove_greater = new JButton("remove greater");
    JButton remove_lower = new JButton("remove lower");
    JButton average_of_distance = new JButton("average of distance");
    JButton min_by_creation_date = new JButton("min by creation_date");
    JButton print_field_ascending_distance = new JButton("print field ascending distance");

    public void display(){
        frame = new JFrame("program");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        panelLeft.setLayout(new GridLayout(10, 1, 10, 0));

        add.setPreferredSize(print_field_ascending_distance.getPreferredSize());
        panelLeft.add(add);
        update.setPreferredSize(print_field_ascending_distance.getPreferredSize());
        panelLeft.add(update);
        remove_by_id.setPreferredSize(print_field_ascending_distance.getPreferredSize());
        panelLeft.add(remove_by_id);
        clear.setPreferredSize(print_field_ascending_distance.getPreferredSize());
        panelLeft.add(clear);
        add_if_min.setPreferredSize(print_field_ascending_distance.getPreferredSize());
        panelLeft.add(add_if_min);
        remove_greater.setPreferredSize(print_field_ascending_distance.getPreferredSize());
        panelLeft.add(remove_greater);
        remove_lower.setPreferredSize(print_field_ascending_distance.getPreferredSize());
        panelLeft.add(remove_lower);
        average_of_distance.setPreferredSize(print_field_ascending_distance.getPreferredSize());
        panelLeft.add(average_of_distance);
        min_by_creation_date.setPreferredSize(print_field_ascending_distance.getPreferredSize());
        panelLeft.add(min_by_creation_date);
        panelLeft.add(print_field_ascending_distance);

        coordinates.setLayout(new BorderLayout());

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

        MyComponent component = new MyComponent();
        coordinates.add(component);

        frame.getContentPane().add(BorderLayout.PAGE_START, jMenuBar);
        frame.add(panelLeft, BorderLayout.LINE_START);
        frame.add(panelBottom, BorderLayout.PAGE_END);
        frame.add(coordinates);

        frame.setVisible(true);
    }
}
