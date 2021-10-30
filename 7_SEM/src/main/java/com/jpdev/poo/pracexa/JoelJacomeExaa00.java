package com.jpdev.poo.pracexa;
import java.util.Scanner;

/**
 * @author Joel Jacome Piowuinto - S18001428
 *
 */

/*El limite para buscar es:  Seg: 5
Estas en el hilo
 Seg: 4
 Seg: 3
 Seg: 2
 Seg: 1
*/

class ThreadBuscaPrimos implements Runnable {

    private int cuantos = 1, limite=0;

    ThreadBuscaPrimos( int xlimit, String xhilo) {
    	limite = xlimit;
    	Thread primillo = new Thread(this, xhilo);
    	primillo.start();
    }
    
  
    public void run(){
       System.out.println("Estas en el hilo");
   }
}

class Exa2019{

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int search;
        System.out.print("El limite para buscar es: ");
        search = sc.nextInt();
        int limite = 5;
        new ThreadBuscaPrimos(limite, "Hilo 1");
        for (int i = limite; i >0; i-- ){
            try {
                System.out.println(" Seg: " + i);
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("ERROR: "+e);
            }
        }
    }
   }
