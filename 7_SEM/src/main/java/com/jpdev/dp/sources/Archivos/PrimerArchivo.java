package com.jpdev.dp.sources.Archivos;/*
 Manejo basico de archivos
Leer y grabar en un archivo
Tener el metodo de seleccionar.

Crear un metodo que obtenga el promedio de todos los alumnos

 *
 * @author Pedro Díaz Abascal
 */

// 1. importar la utileria io.*
import java.io.*;
public class PrimerArchivo {
    //2. Definir el objeto de tipo File
    public File f;
    
    public PrimerArchivo(String xnom){
        // 3. Instanciamos un objeto de tipo File
        f = new File(xnom);
    }
    
    public void creaArch(){
        // 4. Crear el archivo con el try IOException
        try{
           f.createNewFile();
        }catch(IOException e){}
    }
    
    //Obtiene de la cadena el campo que este a continuaciòn del inicio(separador)
    public String obten(int inicio, String cadena){
        int c = 0; // Contador del caracter separador
        String cade = ""; // Voy a tener los caracteres que deseo obtener
        for( int i=0; i<cadena.length();i++){
            if (cadena.charAt(i)=='|' ) c++; // chart.At() me la la posicion del caracter i dentro del String
            if (inicio==c && cadena.charAt(i)!='|')
                cade += cadena.charAt(i);
            if (inicio<c) break;
        }
        return cade;
    }

    // si mi caracter es Lola Perez   charAt(5)-->"P"  
    //*xx.grabaArch("s12345678|Lola|1234567890|INF|10.00");

    
    public void leeArch(){
        String aux,mat,nom,tel,carr;
        double prom;
        //11. Checar si exste el archivo (Entre un try)
        try{
            if (!f.exists()){
                System.out.println("No existe el archivo");
                return;
            }
            //11. Crea el objeto de lectura asociado con el archivo
            FileReader r = new FileReader(f);
            //12. Crear el buffer asociado al archivo
            BufferedReader br = new BufferedReader(r);
            //13. Utilizar el metodo de leer (Generalemnte esta dentro de un ciclo
            while(true){
                aux=br.readLine();
                if (aux==null) break;
                System.out.println(aux);
                mat = obten(0,aux);
                nom = obten(1,aux);
                tel = obten(2,aux);
                carr = obten(3,aux);
                prom = Double.parseDouble(obten(4,aux));
                System.out.println("Matricula: "+mat);
                System.out.println("Nombre   : "+nom);
                System.out.println("Telefono : "+tel);
                System.out.println("Carrera  : "+carr);
                System.out.println("Promedio : "+prom);
                System.out.println("-------------------------");
            }
            
        }catch(IOException e){System.out.println("No existe el archivo");}
    }

        public void promedio(){
        String aux;
        double sumaProm=0.0, prom;
        int con =0;
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
                prom = Double.parseDouble(obten(4,aux));
                sumaProm += prom;
                con++;
            }
            System.out.println("El promedio de los alumnos es: "+(sumaProm/con));
            
        }catch(IOException e){System.out.println("No existe el archivo");}
    }


    //Graba archivo en varios renglones
    public void grabaArch(String cadena){
        try{
            // 5. Crear si existe el archivo
            if (!f.exists()) creaArch();
            // 6. Crear el manejador de escritura con Stream
           FileOutputStream fos = new FileOutputStream(f,true);
            // 7. Crear el Stream de salida donde trabajaremos de forma temporal
            OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
           // Crear el buffer donde se guardaran los datos temporales
           BufferedWriter bw = new BufferedWriter(osw);
            // 8. Crae la clase de impresiòn en DD
            bw.write(cadena+"\r\n");//escribimos en el archivo alt-92
            // 10. Cerrar el PrintWriter yel BufferedWriter para escribirlo en archivo 
            bw.close();
        }catch(IOException e){}
    }
    
}
