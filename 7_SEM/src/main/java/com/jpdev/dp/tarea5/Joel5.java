package com.jpdev.dp.tarea5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Joel5 {
    int op = 0;
    Scanner sc = new Scanner(System.in);
    NodoHash array[] = new NodoHash[3000];
    //NodoHash overflow[] = new NodoHash[1501];
    String line;
    File f;
    //line on windows PC Joel

    public Joel5(){
        for (int i = 0; i < 3000; i++){
            array[i] = new NodoHash();
            if (i < 1500)
                array[i].clave = -1;
            else
                array[i].clave = i + 1;
        }
        array[0].clave = 1500;
    }

    public void carga(){
        f = new File("Nombres.txt");
        double n;
        int cont = 0;
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
                //meter al arreglo con una funcion hash
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public int funHash(String nombre){
        int clave = 0;
        //esta funcion convertira el nombre en una clave numerica
        return clave;
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

            switch (op){
                case 1:{
                    //funcion de carga
                    break;
                }

                case 2:{
                    //funcion de alta
                    break;
                }

                case 3:{
                    //funcion de baja
                    break;
                }

                case 4:{
                    //funcion de consulta(busqueda)
                    break;
                }

                case 5:{
                    //funcion de imprime
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
}
