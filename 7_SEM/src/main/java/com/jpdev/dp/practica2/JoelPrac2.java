package com.jpdev.dp.practica2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Joel Jacome Pioquinto - S18001420
 * */

/*
* Debes de leer el archivo nombres.txt, subirlo a un arreglo,
* ordenarlo con el metodo que gustes y despues realizar una busqueda binaria de un dato
* */

public class JoelPrac2 {
    public File f;
    int med = 0;
    String line;
    public static String array[] = new String[1406];

    public JoelPrac2() {
        f = new File("Nombres.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            if (!f.exists()){
                System.out.println("No existe el archivo");
                return;
            }
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            int i = 0;
            while(true){
                line = br.readLine();
                if (line == null)
                    break;
                array[i] = line;
                i++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void imprime(){
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    public void ordena(int primero, int ultimo){//metodo: QuickSort
        int i, j, central;
        String pivote;
        central = (primero + ultimo) / 2;
        pivote = array[central];
        i = primero;
        j = ultimo;
        do {
            while (array[i].compareTo(pivote) < 0) {
                i++;
            }
            while (array[j].compareTo(pivote) > 0) {
                j--;
            }
            if (i <= j) {
                String tmp;
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                /* intercambia a[i] con a[j] */
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            ordena(primero, j); /* mismo proceso con sublista izqda */
        }
        if (i < ultimo) {
            ordena(i, ultimo); /* mismo proceso con sublista drcha */
        }
    }

    public void busquedaBinaria(String name){
        int ini = 0, fin = array.length-1, con = 0;
        while (ini <= fin){
            med = (ini + fin) / 2;
            con++;
            if (array[med].equals(name)){
                System.out.println("Dato encontrado");
                break;
            } else {
                if (name.compareTo(array[med]) > 0)
                    ini = med + 1;
                else
                    fin = med - 1;
            }
        }
        if (ini > fin)
            System.out.println("Dato NO encontrado");
        System.out.println("Total de iteraciones: "+con);
    }

    public static void main(String[] args) {
        String name;
        Scanner sc = new Scanner(System.in);
        JoelPrac2 nombres = new JoelPrac2();
        nombres.ordena(0, array.length - 1);
        nombres.imprime();
        System.out.print("Ingresa nombre a buscar: ");
        name = sc.nextLine();
        nombres.busquedaBinaria(name);
    }
}
