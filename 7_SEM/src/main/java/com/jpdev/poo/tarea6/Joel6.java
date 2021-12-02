package com.jpdev.poo.tarea6;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Joel6 {
    public File f;
    int med = 0;
    String line;
    public static int array[] = new int[86];

    public Joel6() {
        f = new File("Monto.txt");
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
            int i = 0, monto;
            while(true){
                line = br.readLine();
                if (line == null)
                    break;
                monto = Integer.parseInt(get(1, line));
                array[i] = monto;
                i++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String get(int flag, String line){//obtiene un campo indicado de la linea
        int cont = 0;
        String cadena = "";
        for (int i = 0; i < line.length(); i++){
            if (line.charAt(i) == '|')
                cont++;
            if (flag == cont && line.charAt(i) != '|')
                cadena+= line.charAt(i);
            if (flag < cont)
                break;
        }
        return cadena;
    }

    public void imprime(){//pocisiones 20-30
        System.out.println("Pocisiones 20 - 30");
        for (int i = 19; i <= 29; i++){
            System.out.println("["+(i+1)+"] -> "+array[i]);
        }
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
                System.out.println("Dato encontrado en la pocision "+(med+1));
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
}
