package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListenerButton implements ActionListener {
    private String Name;
    private String Surname;
    private String Patronymic;

    public MyListenerButton(String name, String surname, String patronymic) {
        Name = name;
        Surname = surname;
        Patronymic = patronymic;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     JButton button = (JButton) e.getSource();
     String name = button.getName();
    if(name.equals("collaps")){
        Controller.showSecond();
    }
    if(name.equals("expand")){
        Controller.showFerst();
    }
    }
}
