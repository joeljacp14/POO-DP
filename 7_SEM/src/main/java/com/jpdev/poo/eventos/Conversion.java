package com.jpdev.poo.eventos;

/**
 *
 * @author Joel Jacome Pioquinto - S18001428
 */

import java.awt.*;
import java.awt.event.*;

public class Conversion extends Frame implements ActionListener, ItemListener{
    public static final double ft = 30.48, in = 2.54, yd = 91.4;
    Label lcm;
    Button limpia, salir;
    TextField cm, resul;
    Choice unidad;
    
    public Conversion(){
        super("Conversion de unidades");
        setLayout(null);
        setVisible(true);
        setSize(400,210);
        setBackground(Color.GRAY);
    }

    public void crea(){
        limpia = new Button("Borrar");
        limpia.addActionListener(this);
        limpia.setBounds(100,130,70,30);
        add(limpia);  

        salir = new Button("Salir");
        salir.addActionListener(this);
        salir.setBounds(200,130,70,30);
        add(salir);  
        
        lcm = new Label("Altura en cm:");
        lcm.setBounds(125,50,80,20);
        add(lcm);

        cm = new TextField("");
        cm.setBounds(205,50,50,20);
        add(cm);

        resul = new TextField("");
        resul.setBounds(220,90,70,20);
        add(resul);
        
        unidad = new Choice();
        unidad.addItemListener(this);
        unidad.setBounds(115,90,100,30);
        unidad.addItem("--Seleccione--");
        unidad.addItem("Pies");
        unidad.addItem("Pulgadas");
        unidad.addItem("Yardas");
        add(unidad);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }
    
    public void itemStateChanged(ItemEvent e){
        if (e.getSource() == unidad){
           int indice = unidad.getSelectedIndex();
           double dcm = Double.parseDouble(cm.getText()), res;
           if (indice == 1) {
               res = dcm * ft;
               resul.setText(String.valueOf(res));
           }
           if (indice == 2) {
               res = dcm * in;
               resul.setText(String.valueOf(res));
           }
           if (indice == 3) {
               res = dcm * yd;
               resul.setText(String.valueOf(res));
           }
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir)
            System.exit(0);
        if (e.getSource() == limpia) {
            cm.setText("");
            resul.setText("");
        }
    }
        public static void main(String[] args) {
        Conversion convert = new Conversion();
        convert.crea();
    }
    
}
