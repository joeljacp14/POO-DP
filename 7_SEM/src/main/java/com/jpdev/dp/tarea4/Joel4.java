package com.jpdev.dp.tarea4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Joel Jacome Pioquinto - S18001420
 * */

/*
* Con el archivo adjunto de nombres200000, debes de ordenarlo mediante el Quick-Sort
* y el Shell-Sort y un método propio que me arroje mejores resultados que los anteriores
* (Que tarde menos tiempo en ordenar). Lo debes investigar o programar y entregarlo
* en programa donde se muestre que fue el mas rápido.
* */

public class Joel4 {
    public File f;
    String line;
    public static String array1[] = new String[200000];
    public static String array2[] = new String[200000];
    public static String array3[] = new String[200000];

    public Joel4() {
        f = new File("Nombres200000.txt");
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
                array1[i] = line;
                array2[i] = line;
                array3[i] = line;
                i++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void imprime(String array[]){
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    public double quickSort(int primero, int ultimo){
        double start = System.currentTimeMillis();
        String temp;
        int i, j, central;
        String pivote;
        central = (primero + ultimo) / 2;
        pivote = array1[central];
        i = primero;
        j = ultimo;
        do {
            while (array1[i].compareTo(pivote) < 0) {
                i++;
            }
            while (array1[j].compareTo(pivote) > 0) {
                j--;
            }
            if (i <= j) {
                temp = array1[i];
                array1[i] = array1[j];
                array1[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            quickSort(primero, j);
        }
        if (i < ultimo) {
            quickSort(i, ultimo);
        }
        double finish = System.currentTimeMillis();
        return (finish - start) / 1000;
    }

    public double ShellSort(){
        double start = System.currentTimeMillis();
        String temp;
        int intervalo, i, j, k;
        int n = array2.length;
        intervalo = n / 2;
        while (intervalo > 0){
            for (i = intervalo; i < n; i++){
                j = i - intervalo;
                while (j >= 0){
                    k = j + intervalo;
                    if (array2[j].compareTo(array2[k]) <= 0)
                        j = -1;
                    else{
                        temp = array2[j];
                        array2[j] = array2[k];
                        array2[k] = temp;
                        j -= intervalo;
                    }
                }
            }
            intervalo = intervalo / 2;
        }
        double finish = System.currentTimeMillis();
        return  (finish - start) / 1000;
    }

    public double combSort(){//metodo de ordenamiento personalizado
        double start = System.currentTimeMillis();

        String temp;
        double gap = array3.length;
        int swaps, i;

        do{
            if (gap > 1){
                gap = gap / 1.3;
                if (gap == 10 || gap == 9){
                    gap = 11;
                }
            }
            i = 0;
            swaps = 0;
            do {
                if (array3[i].compareTo(array3[(int)(i + gap)]) > 0){
                    temp = array3[i];
                    array2[i] = array2[(int)(i + gap)];
                    array2[(int) (i + gap)] = temp;
                    swaps++;
                }
                i++;
            }while ((i + gap) < array3.length);
        }while (gap != 1 && swaps != 0);

        double finish = System.currentTimeMillis();
        return (finish - start) / 1000;
    }

    public static void main(String[] args) {
        Joel4 nombres = new Joel4();
        double time1, time2, time3;
        time1 = nombres.quickSort(0, array1.length - 1);
        time2 = nombres.ShellSort();
        time3 = nombres.combSort();
        System.out.println("TIEMPOS DE ORDENADO");
        System.out.println("Quick Sort: "+time1+" seg.");
        System.out.println("Shell Sort: "+time2+" seg.");
        System.out.println("Comb Sort: "+time3+" seg.");
//        nombres.imprime(array1);
//        nombres.imprime(array2);
//        nombres.imprime(array3);
    }
}
