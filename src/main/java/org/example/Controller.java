package org.example;

import javax.swing.*;
import java.awt.*;

public class Controller {
    static JFrame frame;
    static FerstForm ferstForm;
    static private JComponent componentFerstForm;
    static SecondForm secondForm;
    static private JComponent componentSecondForm;
    public Controller() {
        frame = new JFrame();
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ferstForm = new FerstForm();
        componentFerstForm = ferstForm.$$$getRootComponent$$$();
        secondForm = new SecondForm();
        componentSecondForm = secondForm.$$$getRootComponent$$$();
        frame.add(componentFerstForm);
        frame.setVisible(true);
    }

    public static void showSecond() {
        frame.remove(componentFerstForm);
        Component[] components= componentFerstForm.getComponents();
        JPanel jPanel= (JPanel) components[1];
        Component[] componentsPanel = jPanel.getComponents();
        JTextField tfname = (JTextField) componentsPanel[1];
        JTextField tfsurname = (JTextField) componentsPanel[6];
        JTextField tfpatronymic = (JTextField) componentsPanel[4];
        if(tfsurname.getText().isEmpty()){
            showMesage("Dont enter surname");
            frame.add(componentFerstForm);
            frame.repaint();
            frame.setVisible(true);
            return;

        }
        if(tfname.getText().isEmpty()){
            showMesage("Dont enter name");
            frame.add(componentFerstForm);
            frame.repaint();
            frame.setVisible(true);
            return;
        }
        if(!Validator.valid(tfname.getText(),tfsurname.getText(),tfpatronymic.getText())){
            showMesageErorEnter("Mistake enter, Name, Surname and Patronumic mast consist only later");
            frame.add(componentFerstForm);
            frame.repaint();
            frame.setVisible(true);
            return;
        }
        String result = tfname.getText()+" "+ tfsurname.getText()+" "+tfpatronymic.getText();

        getTextFieldSecondForm().setText(result);
        frame.add(componentSecondForm);
        frame.repaint();
        frame.setVisible(true);
    }

    public static void showFerst() {
        String nsp=getTextFieldSecondForm().getText();
        if(nsp.isEmpty()){
            showMesage("Dont enter NSP");
            frame.add(componentFerstForm);
            frame.repaint();
            frame.setVisible(true);
            return;
        }
        if(!Validator.validNSP(nsp)){
            showMesageErorEnter("Mistake enter, Name, Surname and Patronumic mast consist only later");
            return;
        }
        String[] nspMas = new String[3];
        String[] nspResurs= nsp.split(" ");
        for (int i=0;i<nspResurs.length;i++){
            nspMas[i]=nspResurs[i];
        }

        Component[] components= componentFerstForm.getComponents();
        JPanel jPanel= (JPanel) components[1];
        Component[] componentsPanel = jPanel.getComponents();
        JTextField tfname = (JTextField) componentsPanel[1];
        JTextField tfsurname = (JTextField) componentsPanel[6];
        JTextField tfpatronymic = (JTextField) componentsPanel[4];
        tfname.setText(nspMas[0]);
        tfsurname.setText(nspMas[1]);
        tfpatronymic.setText(nspMas[2]);
        frame.remove(componentSecondForm);
        frame.add(componentFerstForm);
        frame.repaint();
        frame.setVisible(true);
    }

    static private JTextField getTextFieldSecondForm(){
        Component[] componentsSecondForm= componentSecondForm.getComponents();
        JPanel jPanelSecondForm= (JPanel) componentsSecondForm[1];
        Component[] componentsSecondFormJPanel = jPanelSecondForm.getComponents();
        JTextField tfSecondPanel = (JTextField) componentsSecondFormJPanel[1];
        return  tfSecondPanel;
    }

    private static void showMesage(String caption){
        JOptionPane.showMessageDialog(
                frame,
                caption,
                "Error enter",
                JOptionPane.PLAIN_MESSAGE);
    }

    private static void showMesageErorEnter(String caption){
        JOptionPane.showMessageDialog(
                frame,
                caption,
                "Error enter",
                JOptionPane.PLAIN_MESSAGE);
    }



}
