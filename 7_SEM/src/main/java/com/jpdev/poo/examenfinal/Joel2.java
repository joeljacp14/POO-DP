package com.jpdev.poo.examenfinal;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Joel2 {
    File f;
    String line;
    final int TAM = 12;
    int monto;
    int cont = 0, med = 0;
    int array[] = new int[TAM];

    public Joel2(){
        f = new File("Exab21.txt");
        try {
            f.createNewFile();
        }catch (IOException e){
            System.out.println("ERROR: "+e);
        }

        try {
            if (!f.exists()){
                System.out.println("No existe el archivo");
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (true){
                line = br.readLine();
                if (line == null)
                    break;
                monto = Integer.parseInt(get(2, line));
                array[cont] = monto;
                cont++;
            }
        }catch (IOException e){
            System.out.println("ERROR: "+e);
        }
    }

    public String get(int flag, String cliente){//obtiene un campo indicado
        int cont = 0;
        String cadena = "";
        for (int i = 0; i < cliente.length(); i++){
            if (cliente.charAt(i) == '|')
                cont++;
            if (flag == cont && cliente.charAt(i) != '|')
                cadena+= cliente.charAt(i);
            if (flag < cont)
                break;
        }
        return cadena;
    }

    public void quickSort(int primero, int ultimo){
        int i, j, central;
        int pivote;
        central = (primero + ultimo) / 2;
        pivote = array[central];
        i = primero;
        j = ultimo;
        do {
            while (array[i] < pivote) {
                i++;
            }
            while (array[j] > pivote) {
                j--;
            }
            if (i <= j) {
                int tmp;
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
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
    }

    public void busquedaBinaria(int dato){
        int ini = 0, fin = array.length-1, con = 0;
        while (ini <= fin){
            med = (ini + fin) / 2;
            con++;
            if (array[med] == dato){
                System.out.println("El dato "+dato+" fue encontrado en la pocision "+(med+1));
                break;
            } else {
                if (dato > array[med])
                    ini = med + 1;
                else
                    fin = med - 1;
            }
        }
        if (ini > fin)
            System.out.println("Dato no encontrado");
        System.out.println("Total de iteraciones: "+con);
    }

    public void imprime(){//pocisiones 20-30
        System.out.println("Array");
        for (int i = 0; i < array.length; i++){
            System.out.println("["+(i+1)+"] -> "+array[i]);
        }
    }
}
