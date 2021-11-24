package com.jpdev.poo.exa2part3;

/**
 * Modify by Joel Jacome Pioquinto - S18001428
 * */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class JoelA extends Frame implements ActionListener {
	Label lbl;
	Button button, button1;

	public JoelA() {
		super("Examen A");
		setLayout(null);
		setSize(200, 200);
		setVisible(true);

			button = new Button("Hola arriba");
			button.addActionListener(this);
			button.setBounds(48, 36, 80, 30);
			add(button);

			button1 = new Button("Hola abajo");
			button1.addActionListener(this);
			button1.setBounds(48, 66, 80, 30);
			add(button1);

			lbl = new Label("Ejemplo Botones");
			lbl.setBounds(48, 96, 80, 20);
			add(lbl);

			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) {
					System.exit(0);
				}
			});


	}

	public void actionPerformed(ActionEvent e) {
		//Button bt = (Button)e.getSource();
		String str;
		if (e.getSource() == button) {
			str = button.getLabel();
			lbl.setText(str);
		}
		if (e.getSource() == button1) {
			str = button1.getLabel();
			lbl.setText(str);
		}
	}

	public static void main(String[] args) {
		JoelA t = new JoelA();
	}

}