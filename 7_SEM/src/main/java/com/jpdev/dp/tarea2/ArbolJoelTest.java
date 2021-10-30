package com.jpdev.dp.tarea2;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

import java.io.*;
import java.util.Scanner;

public class ArbolJoelTest {
    public static int cont = 0, mayor = 0;

    private static void instrucciones(){
        System.out.println("MANEJO DE ARBOL BINARIO DE BUSQUEDA (ABB)");
        System.out.println("1) Ingresar");
        System.out.println("2) Preorden (imprime, cuenta nodos y obtiene el mayor)");
        System.out.println("3) Inorden");
        System.out.println("4) Postorden");
        System.out.println("5) Guardar");
        System.out.println("6) Obtener altura");
        System.out.println("7) Eliminar");
        System.out.println("8) Cargar arbol existente en un archivo");
        System.out.println("0) Salir");
        System.out.print("Tu opcion: ");
    }

    public static void main(String[] args) {
        ArbolJoel raiz = null;
        int op = 9, dato, result;
        String sdato;
        Scanner sc = new Scanner(System.in);
        File f = new File("Datos.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo");
            e.printStackTrace();
        }

        while (op != 0){
            instrucciones();
            op = sc.nextInt();

            switch (op){
                case 1: {
                    System.out.print("Ingresa el valor: ");
                    dato = sc.nextInt();
                    if (raiz == null)
                        raiz = new ArbolJoel(dato);
                    else
                        raiz.inserta(dato);
                    break;
                }
                case 2:{
                    if (raiz == null){
                        System.out.println("El arbol es nulo, llenelo primero");
                        break;
                    }
                    System.out.println("=======================================");
                    System.out.println("Datos del arbol en Pre-Orden");
                    raiz.preOrden();
                    System.out.println("\nNodos el arbol: "+cont);
                    System.out.println("Valor mayor es: "+mayor);
                    System.out.println("=======================================");
                    cont = 0; mayor = 0;
                    break;
                }
                case 3:{
                    if (!f.exists())
                        return;
                    if (raiz == null){
                        System.out.println("El arbol es nulo, llenelo primero");
                        break;
                    }
                    System.out.println("=======================================");
                    System.out.println("Datos en el arbol en In-Orden");
                    raiz.inOrden();
                    System.out.println("\n=======================================");
                    break;
                }
                case 4:{
                    if (!f.exists())
                        return;
                    if (raiz == null){
                        System.out.println("El arbol es nulo, llenelo primero");
                        break;
                    }
                    System.out.println("=======================================");
                    System.out.println("Datos en el arbol en Post-Orden");
                    raiz.postOrden();
                    System.out.println("\n=======================================");
                    break;
                }
                case 5:{//guardar en un archivo
                    if (!f.exists())
                        return;

                    if (raiz == null){
                        System.out.println("El arbol es nulo, llenelo primero");
                        break;
                    }
                    try {
                        FileWriter fw = new FileWriter(f);
                        BufferedWriter bw = new BufferedWriter(fw);
                        raiz.guarda(bw);
                        bw.close();
                        System.out.println("\nLos datos del arbol se han guardado en el archivo");
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case 6:{//obtener altura
                    if (raiz == null){
                        System.out.println("El arbol es nulo, llenelo primero");
                        break;
                    }
                    System.out.println("La altura de arbol es: "+raiz.altura());
                    break;
                }
                case 7:{// eliminar
                    if (raiz == null){
                        System.out.println("El arbol es nulo, llenelo primero");
                        break;
                    }
                    System.out.print("Dato a eliminar: ");
                    dato = sc.nextInt();
                    result = raiz.elimina(dato);
                    if (result == -1)
                        System.out.println("El dato no se encuentra en el arbol");
                    if (result == 0)
                        System.out.println("Dato eliminado correctamente");
                    //EL VALOR A ELIMINAR ES LA RAIZ
                    if (result == 1)
                        raiz = null;
                    if (result == 2)
                        raiz = raiz.izq;
                    if (result == 3)
                        raiz = raiz.der;
                    if (result == 4){
                        int flag;
                        flag = raiz.izq.predecesor();
                        if (flag == -1) {
                            flag = raiz.der.sucesor();
                            if (flag == -1){
                                raiz.dato = raiz.der.dato;
                                raiz.der = null;
                                break;
                            }
                            raiz.dato = flag;
                            break;
                        }
                        raiz.dato = flag;
                        break;
                    }
                    break;
                }
                case 8:{//cargar
                    if (!f.exists())
                        return;
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
                        while (true){
                            sdato = br.readLine();
                            if (sdato == null)
                                break;
                            dato = Integer.parseInt(sdato);
                            if (raiz == null)
                                raiz = new ArbolJoel(dato);
                            else
                                raiz.inserta(dato);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case 0:{
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
