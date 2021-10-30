package com.jpdev.poo.programa2;

/*
 * @author Joel Jacome Pioquinto - S18001428
 * */

public class JoelSec implements Runnable {
    public final long LIMIT = 100000;
    long password;

    JoelSec(long contrasenia){
        Thread busquedaSec = new Thread(this, "Busqueda secuencial");
        password = contrasenia;
        busquedaSec.start();
    }

    public void run (){
        int i;
        for (i = 0; i <= LIMIT; i++){
            if (password == i){
                System.out.println(Thread.currentThread().getName()+" terminada: La contraseña "+password+" fue encontrada en el intento "+i);
                return;
            }
        }
        System.out.println(Thread.currentThread().getName()+" terminada: Ninguna contraseña generada fue correcta");
    }
}
