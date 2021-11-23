package com.jpdev.poo.exa2part1;

import java.io.*;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

public class JoelB {
    public File f;
    String line, clave, nombre, deuda;

    public JoelB() {
        f = new File("JoelArch.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(int flag, String line){
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

    public void imprimeTodo(){
        try{
            if (!f.exists()){
                System.out.println("No existe el archivo");
                return;
            }
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while(true){
                line = br.readLine();
                if (line == null)
                    break;
                clave = get(0, line );
                nombre = get(1, line );
                deuda = get(2, line );
                System.out.println(nombre+" con clave "+clave+" debe $"+deuda);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void eliminaMenos100(){
        String nombre;
        int deuda;
        try {
            if (!f.exists()){
                System.out.println("No se puede acceder al archivo");
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            FileOutputStream fos = new FileOutputStream(f,true);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
            //FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(osw);
            //PrintWriter pw = new PrintWriter(bw);
            while (true){
                line = br.readLine();
                if (line == null)
                    break;
                deuda = Integer.parseInt(get(2, line));
                if (deuda < 100)
                    bw.write("");
                else
                    bw.write(line+"\n");
            }
            bw.close();
            System.out.println("El registro en el archivo ha sido actualizado");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JoelB exa = new JoelB();
        exa.imprimeTodo();
        exa.eliminaMenos100();
        exa.imprimeTodo();
    }
}
