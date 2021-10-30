package com.jpdev.poo.programa4;

/**
 *
 * @author Joel Jacome Pioquinto - S18001428
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImcJoel extends Frame implements ActionListener{
    double height, weight, imc;
    Font resultFont = new Font(null, Font.BOLD, 15);
    Label labHeight, labWeight, labResult;
    Button btnImc, btnLimpiar, btnSalir;
    TextField tfHeight, tfWeight, result;
    List indicador;

    public ImcJoel(){
        super("Calculador de IMC");
        setLayout(null);
        setVisible(true);
        setSize(355,210);
        setBackground(Color.GRAY);
    }

    public void crea(){
        btnImc = new Button("Calcular IMC");
        btnImc.addActionListener(this);
        btnImc.setBounds(50, 130, 80, 30);
        add(btnImc);

        btnLimpiar = new Button("Limpiar");
        btnLimpiar.addActionListener(this);
        btnLimpiar.setBounds(145,130,70,30);
        add(btnLimpiar);

        btnSalir = new Button("Salir");
        btnSalir.addActionListener(this);
        btnSalir.setBounds(230,130,70,30);
        add(btnSalir);
        
        labHeight = new Label("Altura en cm:");
        labHeight.setBounds(50,50,80,20);
        add(labHeight);

        labWeight = new Label("Peso en kg:");
        labWeight.setBounds(50, 70, 80, 20);
        add(labWeight);

        labResult = new Label("Resultado");
        labResult.setBounds(50, 90, 80, 20);
        add(labResult);

        tfHeight = new TextField("");
        tfHeight.setBounds(130,50,70,20);
        add(tfHeight);

        tfWeight = new TextField("");
        tfWeight.setBounds(130, 70, 70, 20);
        add(tfWeight);

        result = new TextField("");
        result.setBounds(130,90,70,20);
        result.setFont(resultFont);
        add(result);
        
        indicador = new List();
        indicador.addActionListener(this);
        indicador.setBounds(210,50,100,65);
        indicador.add("Bajo peso");
        indicador.add("Normal");
        indicador.add("Sobrepeso");
        indicador.add("Obesidad");
        add(indicador);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }
    
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnImc){
            try {
                height = Double.parseDouble(tfHeight.getText());
                weight = Double.parseDouble(tfWeight.getText());
            }catch (Exception e){
                //e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Los datos ingresados no son correctos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            imc = weight / Math.pow(height, 2);
            result.setText(String.valueOf(imc));
            if (imc < 18.5){
                result.setBackground(Color.YELLOW);
                indicador.select(0);
                indicador.setBackground(Color.YELLOW);
            }
            if (imc >= 18.5 && imc <= 24.9){
                result.setBackground(Color.GREEN);
                indicador.select(1);
                indicador.setBackground(Color.GREEN);
            }
            if (imc >= 25 && imc <= 29.9){
                result.setBackground(Color.ORANGE);
                indicador.select(2);
                indicador.setBackground(Color.ORANGE);
            }
            if (imc >= 30){
                result.setBackground(Color.RED);
                indicador.select(3);
                indicador.setBackground(Color.RED);
            }
        }
        if (evt.getSource() == btnSalir)
            System.exit(0);

        if (evt.getSource() == btnLimpiar) {
            tfHeight.setText("");
            tfWeight.setText("");
            result.setText("");
            result.setBackground(Color.WHITE);
            indicador.setBackground(Color.WHITE);
        }
    }
        public static void main(String[] args) {
        ImcJoel convert = new ImcJoel();
        convert.crea();
    }
    
}
