package swing_package;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetObjectWindow {
    JFrame frame;
    JButton buttonLocationTo = new JButton();
    JButton buttonDistance = new JButton();

    public void display(){
        frame = new JFrame("setObject");
        frame.setSize(350, 530);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel name = new JLabel("name");
        name.setBounds(10,20,90,25);
        panel.add(name);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(130,20,165,25);
        panel.add(nameText);

        JLabel coordinatesX = new JLabel("coordinates.x");
        coordinatesX.setBounds(10,50,90,25);
        panel.add(coordinatesX);

        JLabel coordinatesY = new JLabel("coordinates.y");
        coordinatesY.setBounds(10,80,90,25);
        panel.add(coordinatesY);

        JLabel LocationToX = new JLabel("LocationTo.x");
        LocationToX.setBounds(10,110,90,25);
        panel.add(LocationToX);

        JLabel LocationToY = new JLabel("LocationTo.y");
        LocationToY.setBounds(10,140,90,25);
        panel.add(LocationToY);

        JLabel LocationToZ = new JLabel("LocationTo.z");
        LocationToZ.setBounds(10,170,90,25);
        panel.add(LocationToZ);

        JTextField coordinatesXText = new JTextField(20);
        coordinatesXText.setBounds(130,50,165,25);
        panel.add(coordinatesXText);

        JTextField coordinatesYText = new JTextField(20);
        coordinatesYText.setBounds(130,80,165,25);
        panel.add(coordinatesYText);

        JTextField LocationToXText = new JTextField(20);
        LocationToXText.setBounds(130,110,165,25);
        panel.add(LocationToXText);

        JTextField LocationToYText = new JTextField(20);
        LocationToYText.setBounds(130,140,165,25);
        panel.add(LocationToYText);

        JTextField LocationToZText = new JTextField(20);
        LocationToZText.setBounds(130,170,165,25);
        panel.add(LocationToZText);

        JLabel LocationToName = new JLabel("LocationTo.name");
        LocationToName.setBounds(10, 200, 100, 25);
        panel.add(LocationToName);

        JTextField LocationToNameText = new JTextField(20);
        LocationToNameText.setBounds(130,200,165,25);
        panel.add(LocationToNameText);

        buttonLocationTo.setText("LocationTo is null");
        buttonLocationTo.setBounds(80 ,230, 160, 20);
        panel.add(buttonLocationTo);

        JLabel LocationFromX = new JLabel("LocationFrom.x");
        LocationFromX.setBounds(10,260,90,25);
        panel.add(LocationFromX);

        JLabel LocationFromY = new JLabel("LocationFrom.y");
        LocationFromY.setBounds(10,290,90,25);
        panel.add(LocationFromY);

        JLabel LocationFromZ = new JLabel("LocationFrom.z");
        LocationFromZ.setBounds(10,320,90,25);
        panel.add(LocationFromZ);

        JTextField LocationFromXText = new JTextField(20);
        LocationFromXText.setBounds(130,260,165,25);
        panel.add(LocationFromXText);

        JTextField LocationFromYText = new JTextField(20);
        LocationFromYText.setBounds(130,290,165,25);
        panel.add(LocationFromYText);

        JTextField LocationFromZText = new JTextField(20);
        LocationFromZText.setBounds(130,320,165,25);
        panel.add(LocationFromZText);

        JLabel LocationFromName = new JLabel("LocationFrom.name");
        LocationFromName.setBounds(10, 350, 120, 25);
        panel.add(LocationFromName);

        JTextField LocationFromNameText = new JTextField(20);
        LocationFromNameText.setBounds(130,350,165,25);
        panel.add(LocationFromNameText);

        buttonDistance.setText("distance is null");
        buttonDistance.setBounds(80 ,380, 160, 20);
        panel.add(buttonDistance);

        JLabel distance = new JLabel("Distance");
        distance.setBounds(10, 410, 120, 25);
        panel.add(distance);

        JTextField distanceText = new JTextField(20);
        distanceText.setBounds(130,410,165,25);
        panel.add(distanceText);

        JButton cancelButton = new JButton("cancel");
        cancelButton.setBounds(10, 440, 80, 25);
        panel.add(cancelButton);

        JButton createButton = new JButton("create object");
        createButton.setBounds(130, 440, 120, 25);
        panel.add(createButton);

        buttonDistance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (buttonDistance.getText() == "distance is null"){
                    buttonDistance.setText("distance is not null");
                    distanceText.setEditable(false);
                } else {
                    buttonDistance.setText("distance is null");
                    distanceText.setEditable(true);
                }
            }
        });

        buttonLocationTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (buttonLocationTo.getText() == "LocationTo is null"){
                    buttonLocationTo.setText("LocationTo is not null");
                    LocationFromNameText.setEditable(false);
                    LocationFromXText.setEditable(false);
                    LocationFromYText.setEditable(false);
                    LocationFromZText.setEditable(false);
                } else {
                    buttonLocationTo.setText("LocationTo is null");
                    LocationFromNameText.setEditable(true);
                    LocationFromXText.setEditable(true);
                    LocationFromYText.setEditable(true);
                    LocationFromZText.setEditable(true);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //do something
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SetObjectWindow o = new SetObjectWindow();
        o.display();
    }
}
