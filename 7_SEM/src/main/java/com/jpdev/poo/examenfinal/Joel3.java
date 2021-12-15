package com.jpdev.poo.examenfinal;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pedro Diaz
 * modificado por Joel Jacome Pioquinto - S18001428
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Exac21 extends Frame implements ItemListener, ActionListener{
    Label lcantidad, lprecio, ldescuento;
    TextField tcantidad,tprecio;
    List xdescuento;
    Choice producto;
    int ppantalon = 500, pcamisa = 300, pcinturon = 100, cantidad;
    double total, desc;
    
    public Exac21(){
        super("Precios");
        setLayout(null);
        setVisible(true);
        setSize(400,200);
    }
    
    public void pantalla(){

        lcantidad = new Label("Cantidad: ");
        lcantidad.setBounds(160,40,60,50);
        add(lcantidad);

        ldescuento = new Label("Descuento: ");
        ldescuento.setBounds(25,30,90,30);
        add(ldescuento);
        
        lprecio = new Label("Precio: ");
        lprecio.setBounds(160,90,60,50);
        add(lprecio);
        
        tcantidad = new TextField();
        tcantidad.setBounds(220,50,90,20);
        add(tcantidad);

        tprecio = new TextField();
        tprecio.setBounds(220, 105, 90, 20);
        add(tprecio);
        
        xdescuento = new List();
        xdescuento.addActionListener(this);
        xdescuento.setBounds(20,60,40,70);
        xdescuento.add("0");
        xdescuento.add("10");
        xdescuento.add("20");
        xdescuento.add("30");
        //xdescuento.select(0);
        add(xdescuento);

        producto = new Choice();
        producto.addItemListener(this);
        producto.setBounds(70, 60, 70, 50);
        producto.add("Pantalon");
        producto.add("Camisa");
        producto.add("Cinturon");
        add(producto);
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
        }
    } );  
        
    }
    
    public void itemStateChanged(ItemEvent e){

        if (e.getSource() == producto){
            String selected = producto.getSelectedItem();
            if (selected == "Pantalon"){
                cantidad = Integer.parseInt(tcantidad.getText());
                total =  (ppantalon * cantidad);
                tprecio.setText(String.valueOf(total));
            }
            if (selected == "Camisa"){
                cantidad = Integer.parseInt(tcantidad.getText());
                total =  (pcamisa * cantidad);
                tprecio.setText(String.valueOf(total));
            }
            if (selected == "Cinturon"){
                cantidad = Integer.parseInt(tcantidad.getText());
                total =  (pcinturon * cantidad);
                tprecio.setText(String.valueOf(total));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == xdescuento){
            int index = xdescuento.getSelectedIndex();
            if (index == 0){
                tprecio.setText(String.valueOf(total));
            }
            if (index == 1){
                desc = total - (total * 0.1);
                tprecio.setText(String.valueOf(desc));
            }
            if (index == 2){
                desc = total - (total * 0.2);
                tprecio.setText(String.valueOf(desc));
            }
            if (index == 3){
                desc = total - (total * 0.3);
                tprecio.setText(String.valueOf(desc));
            }
        }
    }

    public static void main(String[] args) {
        Exac21 xx = new Exac21();
        xx.pantalla();
    }
    
    
}
