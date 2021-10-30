package com.jpdev.poo.practica4;

/*
* @author: Joel Jacome Pioquinto - S18001428
* */

/*
* Instrucciones
Imprimir el nombre de los alumnos que estudien informática.
Un método que indique el nombre(s) del(os) alumno(s) con mayor promedio
Un método que me obtenga el promedio de los alumnos de la carrera que le pases como parámetro
Un método que indique cuantos alumnos han reprobado (Calif <6)
* */

import java.io.*;

public class JoelAlumnos {
    public File f;
    String aux,mat,nom,tel,carr;
    double prom;

    public JoelAlumnos(String xnom){
        f = new File(xnom);
    }

    public void creaArch(){
        try{
            f.createNewFile();
        }catch(IOException e){}
    }

    public String obten(int inicio, String cadena){
        int c = 0;
        String cade = "";
        for( int i=0; i<cadena.length();i++){
            if (cadena.charAt(i)=='|' ) c++;
            if (inicio==c && cadena.charAt(i)!='|')
                cade += cadena.charAt(i);
            if (inicio<c) break;
        }
        return cade;
    }

    public void leeTodo(){
        try{
            if (!f.exists()){
                System.out.println("No existe el archivo");
                return;
            }
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while(true){
                aux=br.readLine();
                if (aux==null) break;
                System.out.println(aux);
                mat = obten(0, aux);
                nom = obten(1, aux);
                tel = obten(2, aux);
                carr = obten(3, aux);
                prom = Double.parseDouble(obten(4, aux));
                System.out.println("Matricula: "+mat);
                System.out.println("Nombre: "+nom);
                System.out.println("Telefono: "+tel);
                System.out.println("Carrera: "+carr);
                System.out.println("Promedio: "+prom);
                System.out.println("===========================");
            }
        }catch(IOException e){System.out.println("No existe el archivo");}
    }

    public void leeCarrera(String xcarr){
        try{
            if (!f.exists()){
                System.out.println("No existe el archivo");
                return;
            }
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while(true){
                aux=br.readLine();
                if (aux==null) break;
                if (obten(3,aux).equals(xcarr)){
                    System.out.println(obten(1,aux));
                }
            }

        }catch(IOException e){System.out.println("No existe el archivo");}
    }

    public void leePromedioAlto(){
        double flag = 0.0;
        String aplicado = "";
        try{
            if (!f.exists()){
                System.out.println("No existe el archivo");
                return;
            }
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while(true){
                aux=br.readLine();
                if (aux==null) break;
                prom = Double.parseDouble(obten(4, aux));
                if (prom == flag){
                    aplicado += "\n"+obten(1, aux);
                }
                if (prom >= flag){
                    aplicado = obten(1, aux);
                    flag = prom;
                }
            }
            System.out.println("ALUMNOS CON MAYOR PROMEDIO:\n"+aplicado);

        }catch(IOException e){System.out.println("No existe el archivo");}
    }

    public void promedioCarrera(String carrera){
        double promCarrera = 0.0;
        int contador = 0;
        try{
            if (!f.exists()){
                System.out.println("No existe el archivo");
                return;
            }
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while(true){
                aux=br.readLine();
                if (aux==null) break;
                if (obten(3,aux).equals(carrera)){
                    promCarrera += Double.parseDouble(obten(4, aux));
                    contador++;
                }
            }
            promCarrera = promCarrera / (double) contador;
            System.out.println("El promedio de la carrera de "+carrera+" es: "+promCarrera);

        }catch(IOException e){System.out.println("No existe el archivo");}
    }

    public void leeReprobados(){
        int contador = 0;
        try{
            if (!f.exists()){
                System.out.println("No existe el archivo");
                return;
            }
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while(true){
                aux=br.readLine();
                if (aux==null) break;
                prom = Double.parseDouble(obten(4,aux));
                if (prom < 6.0){
                    contador++;
                }
            }
            System.out.println("La cantidad de alumnos reprobados es: "+contador);

        }catch(IOException e){System.out.println("No existe el archivo");}
    }

    public void grabaArch(String cadena){
        try{
            if (!f.exists()) creaArch();
            FileOutputStream fos = new FileOutputStream(f,true);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(cadena+"\r\n");
            bw.close();
        }catch(IOException e){}
    }
}
