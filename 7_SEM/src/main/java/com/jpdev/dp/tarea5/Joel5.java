package com.jpdev.dp.tarea5;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Joel5 {
    int hash, op = 0;
    Scanner scop = new Scanner(System.in);
    Scanner scclav = new Scanner(System.in);
    NodoHash array[] = new NodoHash[3000];
    //NodoHash overflow[] = new NodoHash[1501];
    String line;
    File f;

    public Joel5(){
        for (int i = 0; i < 3000; i++){
            array[i] = new NodoHash();
            if (i < 1500)
                array[i].apun = -1;
            else
                array[i].apun = i + 1;
        }
        array[0].apun = 1500;
        array[2999].apun = 0;
    }

    public void carga(){
        f = new File("Nombres.txt");
        double n;
        int col = 0;
        try {
            if (!f.exists()){
                System.out.println("No se puede abrir el archivo");
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (true){
                line = br.readLine();
                if (line == null)
                    break;
                hash = funHash(line);
                if (array[hash].dato.isEmpty())
                    array[hash].dato = line;
                else {
                    col++;
                    array[hash].apun = array[0].apun;
                    array[array[0].apun].dato = line;
                    array[0].apun = array[0].apun + 1;
                }
                System.out.println("Hash: "+hash+" de la clave: "+line);
            }
            System.out.println("Colisiones: "+col);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public int funHash(String clave){
        int ascii = 0;
        for(int i = 0; i < clave.length(); i++) {
            ascii += (Math.pow(clave.charAt(i), 2) + (i + 1));
        }
        return (ascii % 1499);
    }

    public void buscar(String clave){
        hash = funHash(clave);
        if (array[hash].dato.equals(clave)){
            System.out.println("Dato encontrado en la pocision "+hash);
            return;
        }if (array[hash].apun != -1 && array[array[hash].apun].dato.equals(clave)){//lo busca en la colision****
            System.out.println("Dato encontrado en la pocision "+array[hash].apun);
            return;
        }
        System.out.println("Dato no encontrado");
        return;

    }

    public void eliminar(String clave){
        hash = funHash(clave);
        if (array[hash].dato.equals(clave)){
            array[hash].dato = "";
            array[hash].apun = -1;
            System.out.println("Dato eliminado correctamente en el area de hash");
            return;
        }if (array[hash].apun != -1 && array[array[hash].apun].dato.equals(clave)){
            array[array[hash].apun].dato = "";
            array[0].apun = array[hash].apun;
            System.out.println("Dato eliminado correctamente en el area de colisiones");
            return;
        }
        System.out.println("El dato no se elimino");
        return;
    }

    public void imprime(){
        for (int i = 0; i <= 2000; i++)
            System.out.println("POS: ["+i+"] -> clave: "+array[i].dato+", sig: "+array[i].apun);
    }

    public  void menu(){
        while (op != 6){
            System.out.println("BUSQUEDA HASH");
            System.out.println("1)  Cargar el arreglo");
            System.out.println("2)  Alta");
            System.out.println("3)  Baja");
            System.out.println("4)  Consulta");
            System.out.println("5)  Imprime");
            System.out.println("6)  Salir");
            System.out.print("Elige una opcion -> ");
            op = scop.nextInt();

            switch (op){
                case 1:{
                    carga();
                    break;
                }

                case 2:{
                    System.out.print("Ingresa un nuevo nombre: ");
                    line = scclav.nextLine();
                    hash = funHash(line);
                    if (array[hash].dato.isEmpty())
                        array[hash].dato = line;
                    else {
                        array[hash].apun = array[0].apun;
                        array[array[0].apun].dato = line;
                        array[0].apun = array[0].apun + 1;
                    }
                    //scclav.next();
                    break;
                }

                case 3:{
                    System.out.print("Ingresa una clave a eliminar: ");
                    line = scclav.nextLine();
                    eliminar(line);
                    //sc.next();
                    break;
                }

                case 4:{
                    System.out.print("Ingresa una clave a buscar: ");
                    line = scclav.nextLine();
                    buscar(line);
                    //sc.next();
                    break;
                }

                case 5:{
                    imprime();
                    break;
                }

                case 6:{
                    System.out.println("Saliendo...");
                    break;
                }
                default:{
                    System.out.println("La opcion es incorrecta, intenta nuevamente");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Joel5 hash = new Joel5();
        hash.menu();
    }
}
