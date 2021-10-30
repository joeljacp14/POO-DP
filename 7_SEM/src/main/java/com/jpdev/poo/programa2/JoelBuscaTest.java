package com.jpdev.poo.programa2;

/*
* @author Joel Jacome Pioquinto - S18001428
* */

import java.util.Scanner;

public class JoelBuscaTest {
    private static int TIME_LIMIT = 120;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Genera un PIN de acceso: ");
        long password = sc.nextLong();

        new JoelSec(password);
        new JoelRan(password);

        for(int i = 1; i <= TIME_LIMIT; i++){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){}
            System.out.println("TIME: "+i+" seg.");
        }

        System.out.println("Proceso main terminado");
    }

}
