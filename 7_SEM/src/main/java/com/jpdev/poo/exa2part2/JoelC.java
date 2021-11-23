package com.jpdev.poo.exa2part2;
/*
 * @author Pedro Diaz
 * @modify by Joel Jacome Pioquinto - S18001428
 */

import java.awt.*;
import java.awt.event.*;
        
class JoelC extends Frame implements ItemListener{
    Label ln1,ln2,ln3,lresul;
    TextField tn1,tn2,tn3,tresul;
    Choice menu;
    Font resultFont = new Font(null, Font.BOLD, 14);
    int n1,n2,n3, mayor, menor, suma, resul;
    
    public JoelC(){
        super("Examen");
        setLayout(null);
        setVisible(true);
        setSize(270,260);
    }
    
    public void alta(){
       
        ln1 = new Label("Numero 1: ");
        ln1.setBounds(30,35,70,30);
        add(ln1);

        ln2 = new Label("Numero 2: ");
        ln2.setBounds(30,75,70,30);
        add(ln2);

        ln3 = new Label("Numero 3: ");
        ln3.setBounds(30,115,70,30);
        add(ln3);      
        
        lresul = new Label("Resultado: ");
        lresul.setBounds(30,155,70,30);
        add(lresul);      


        tn1 = new TextField();
        tn1.setBounds(100,40,40,20);
        tn1.setBackground(Color.GREEN);
        add(tn1);
        
        tn2 = new TextField();
        tn2.setBounds(100,80,40,20);
        tn2.setBackground(Color.GREEN);
        add(tn2);
        
        tn3 = new TextField();
        tn3.setBounds(100,120,40,20);
        tn3.setBackground(Color.GREEN);
        add(tn3);

        tresul = new TextField();
        tresul.setBounds(100,160,40,20);
        tresul.setEditable(false);
        tresul.setBackground(Color.ORANGE);
        tresul.setFont(resultFont);
        add(tresul);

       // Declarar el choice
        menu = new Choice();
        menu.addItemListener(this);
        menu.setBounds(30,200,100,30);
        menu.addItem("--Seleccione--");
        menu.addItem("Mayor");
        menu.addItem("Menor");
        menu.addItem("Suma");
        menu.addItem("Salir");
        add(menu);
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
              // Codigo a ejecutar al cerrar la ventana
               System.exit(0);
        }
    } );   
    }

    public void operaciones(){
        n1 = Integer.parseInt(tn1.getText());
        n2 = Integer.parseInt(tn2.getText());
        n3 = Integer.parseInt(tn3.getText());
        if (n1 > n2 && n1 > n3){
            mayor = n1;
            if (n2 < n3)
                menor = n2;
            else
                menor = n3;
        }
        if (n2 > n1 && n2 > n3){
            mayor = n2;
            if (n1 < n3)
                menor = n1;
            else
                menor = n3;
        }
        if (n3 > n1 && n3 > n2){
            mayor = n3;
            if (n1 < n2)
                menor = n1;
            else
                menor = n2;
        }
        suma = n1 + n2 + n3;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == menu){
            operaciones();
            int index = menu.getSelectedIndex();
            if (index == 1)
                tresul.setText(String.valueOf(mayor));
            if (index == 2)
                tresul.setText(String.valueOf(menor));
            if (index == 3)
                tresul.setText(String.valueOf(suma));
            if (index == 4)
                System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        JoelC xx = new JoelC();
        xx.alta();
    }

}
