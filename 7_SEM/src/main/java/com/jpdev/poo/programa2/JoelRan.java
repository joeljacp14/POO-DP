package com.jpdev.poo.programa2;

/*
 * @author Joel Jacome Pioquinto - S18001428
 * */

public class JoelRan implements Runnable {
    long LIMIT = 100000;
    long password, passRan;

    JoelRan(long contrasenia){
        Thread busquedaRan = new Thread( this, "Busqueda aleatoria");
        password = contrasenia;
        busquedaRan.start();
    }

    public void run (){
        int intent = 0;
        do {
            passRan = (long) (Math.random() * 100000);
            //System.out.println("Contraseña generada: "+passRan);//valida que si se estaban generando contraseñas aleatorias
            if (passRan == password){
                System.out.println(Thread.currentThread().getName()+" terminada: La contraseña "+password+" fue encontrada en el intento "+intent);
                return;
            }else {
                intent++;
            }
        }while ((passRan != password) && (intent < LIMIT));
        System.out.println(Thread.currentThread().getName()+" terminada: Ninguna contraseña generada fue correcta");
    }
}
