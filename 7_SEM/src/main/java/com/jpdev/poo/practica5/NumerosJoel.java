package com.jpdev.poo.practica5;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

/*
* Instrucciones
Debes solicitar un password y compararlo con el primer renglón del archivo Datos.txt
Lola
100
20

Si es correcto debes leer los 2 números que siguen en el archivo y ponerlos en un textfield
Validar que no se puedan meter datos de manera directa

Un botón para saber si el primer numero es par o impar(indicarlo en un checkbox)
y que compare el primer numero con el segundo e indique si es mayor menor o
igual en una lista

Un botón de salir
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NumerosJoel extends Frame implements ActionListener {
    public final String PASSWORD = "Lola";
    Label l1, l2;
    TextField tfN1, tfN2;
    CheckboxGroup par_inpar;
    Checkbox par, inpar;
    List may_men;
    Button validar, salir;
    String password;
    int n1, n2;
    File f;

    public NumerosJoel(){
        super("Numeros");
        setLayout(null);
        setVisible(true);
        setSize(350, 200);
        setBackground(Color.GRAY);

        l1 = new Label("Numero 1");
        l1.setBounds(50, 50, 70, 20);
        add(l1);

        l2 = new Label("Numero 2");
        l2.setBounds(50, 80, 70, 20);
        add(l2);

        tfN1 = new TextField("");
        tfN1.setBounds(120, 50, 70, 20);
        tfN1.setEditable(false);
        add(tfN1);

        tfN2 = new TextField("");
        tfN2.setBounds(120, 80, 70, 20);
        tfN2.setEditable(false);
        add(tfN2);

        validar = new Button("Validar numeros");
        validar.addActionListener(this);
        validar.setBounds(50, 125, 100, 25);
        add(validar);

        salir = new Button("Salir");
        salir.addActionListener(this);
        salir.setBounds(200, 125, 70, 25);
        add(salir);

        par_inpar = new CheckboxGroup();
        par =new Checkbox("Par", false);
        par.setBounds(200, 47, 50, 25);
        add(par);
        inpar = new Checkbox("Inpar", false);
        inpar.setBounds(250, 47, 50, 25);
        add(inpar);

        may_men = new List();
        may_men.setBounds(200, 80, 80, 35);
        may_men.add("N1 es mayor");
        may_men.add("N1 es menor");
        add(may_men);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });

        f = new File("DatosE.txt");
        try {
            f.createNewFile();
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            password = br.readLine();
            if (!password.equals(PASSWORD)){
                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta\nIntente de nuevo", "ACCESO DENEGADO", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
            n1 = Integer.parseInt(br.readLine());
            n2 = Integer.parseInt(br.readLine());
            tfN1.setText(String.valueOf(n1));
            tfN2.setText(String.valueOf(n2));
        }catch (IOException ex){
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == validar){
            if (n1 % 2 == 0)
                par.setState(true);
            else
                inpar.setState(true);

            if (n1 > n2)
                may_men.select(0);
            else
                may_men.select(1);
        }
        if (e.getSource() == salir)
            System.exit(0);
    }

    public static void main(String[] args) {
        NumerosJoel evt = new NumerosJoel();
    }
}
