package com.jpdev.poo.programa1;

/*
 * @author Joel Jacome Pioquinto
 * */

public interface Password {
    String PASSWORD = "Lola";
    String ERROR = "No seas wey y acuerdate del password";
    int INTENTOS = 1;
    int DESCUENTO = 10;

    public void descuento(double precio);
}
