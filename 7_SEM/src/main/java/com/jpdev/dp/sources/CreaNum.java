package com.jpdev.dp.sources;
/*

 * @author Pedro Díaz Abascal
 */

import java.io.*;
public class CreaNum {
    public File f;
    public int arr [] =new int[10000];
    
    public CreaNum(){
        f = new File("Numeros10000.txt");
        String numS;
        int num;
        for(int con = 0;con<10000;con++){
            num = (int) (Math.random()*1000+1);
            numS = Integer.toString(num);
            grabaArch(Integer.toString(con));
            //System.out.println(con);
        }
    }

    /*public CreaNum(){
        f = new File("Datos.txt");
        grabaArch("Lola");
        grabaArch("100");
        grabaArch("50");
    }*/
    
    public void creaArch(){
        try{
           f.createNewFile();
        }catch(IOException e){}
    }
    
    public void cargaArr(){
        f = new File("Numeros10000.txt");
        String aux;
        int con=0;
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
                arr[con++] = Integer.parseInt(aux);
            }  
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
    
    public void imprime(){
        for(int i=0; i< arr.length-2; i++) {
           if(arr[i]+1!=arr[i+1]) System.out.println(arr[i]);
        }
    }
    
    public static void main(String[] args) {
       CreaNum xx = new CreaNum();
       xx.cargaArr();
       xx.imprime();
    }
}
