package com.jpdev.poo.programa1;
import java.util.Scanner;

/*
* @author Joel Jacome Pioquinto
* */

public class
Joel1 implements Password {
    int intentos = INTENTOS;
    final int IVA = 16;

    public void validacion(){
        do{
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingresa la contraseña de ingreso: ");
            String contrasenia = sc.next();
            if (!contrasenia.equals(PASSWORD)){
                intentos--;
                System.out.println(ERROR);

            }
            else{
                System.out.print("Precio del producto: ");
                double precio = sc.nextDouble();
                this.descuento(precio);
                return;
            }
        } while(intentos >= INTENTOS);
        System.out.println("Has excedido el numero de intentos, sistema bloqueado");
    }

    @Override
    public void descuento(double precio) {
        double desc = (precio *  DESCUENTO) * 0.01;
        double iva = (precio * IVA) * 0.01;
        double pfinal = precio - desc + iva;
        System.out.println("El importe del producto es: $" +pfinal);
    }
}
