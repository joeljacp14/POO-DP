package com.jpdev.poo.exa1part2;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

public class Exab00 implements Runnable {
    public final long LIMIT = 1000;
    long array[] = new long[(int) LIMIT];
    long menor, mayor;

    Exab00(String nombreHilo,long men, long may){
        Thread llenado = new Thread(this, nombreHilo);
        for (int i = 0; i < LIMIT; i++){
            array[i] = (long) (Math.random() * 100000);
        }
        menor = men;
        mayor = may;
        llenado.start();
    }

    @Override
    public void run() {
        long cont = 0;
        for (int i = 0; i < LIMIT; i++){
            try {
                Thread.sleep(2);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            if (array[i] >= menor && array[i] <= mayor){
                cont++;
            }
        }
        System.out.println(cont+" numeros estan dentro del "+Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName()+" terminado");
    }
}
