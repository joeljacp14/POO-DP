package com.jpdev.poo.programa3;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

import java.io.*;

public class Joel3 {
    public final double IVA = 0.16;
    public File f;
    String line;

    public Joel3(){
        f = new File("Cliente.txt");
        try {
            f.createNewFile();
        }catch (IOException e){
            System.out.println("ERROR: "+e);
        }
    }

    public String get(int flag, String cliente){//obtiene un campo indicado del cliente
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

    public void deuda(){//metodo 1
        int flag = 0, deudaCliente, deudaTotal = 0;
        String deudores = "";
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
                deudaCliente = Integer.parseInt(get(2, line));
                if (deudaCliente == flag){
                    deudores += line+"\n";
                    flag = deudaCliente;
                }
                if (deudaCliente > flag){
                    deudores = line+"\n";
                    flag = deudaCliente;
                }
                deudaTotal += Integer.parseInt(get(2, line));
            }
            System.out.println("CLIENTES QUE MAS DEBEN: ");
            System.out.println(deudores);
            System.out.println("DEUDA TOTAL: $"+deudaTotal);
        }catch (IOException e){
            System.out.println("ERROR: "+e);
        }
    }

    public void deudoresCiudad(String city){//metodo 2
        String clienteCiudad = "";
        double montoIVA;
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
                if (get(1, line).equals(city)){
                    montoIVA = Double.parseDouble(get(2, line));
                    montoIVA += (montoIVA * IVA);
                    clienteCiudad += get(0, line)+" de "+get(1, line)+" debe: $"+montoIVA+" (IVA incluido)\n";
                }
            }
            System.out.println(clienteCiudad);
        }catch (IOException e){
            System.out.println("ERROR: "+e);
        }
    }

    public void cambiaTipo(){//metodo 3
        String nombre;
        int deudaCliente;
        try {
            if (!f.exists()){
                System.out.println("No se puede acceder al archivo");
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            ///////////////////////////////////////////
            FileOutputStream fos = new FileOutputStream(f,true);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
            BufferedWriter bw = new BufferedWriter(osw);
            while (true){
                line = br.readLine();
                if (line == null)
                    break;
                System.out.println(line);
                nombre = get(0, line);
                deudaCliente = Integer.parseInt(get(2, line));
                if (deudaCliente == 0) {
                    bw.write(nombre+"|"+get(1, line)+"|"+deudaCliente+"|A\n");
                    System.out.println(nombre+" es tipo A");
                }
                if (deudaCliente < 300 && deudaCliente > 0) {
                    bw.write(nombre+"|"+get(1, line)+"|"+deudaCliente+"|B\n");
                    System.out.println(nombre+" es tipo B");
                }
                if (deudaCliente >= 300) {
                    bw.write(nombre+"|"+get(1, line)+"|"+deudaCliente+"|C\n");
                    System.out.println(nombre+" es tipo C");
                }
            }
            bw.close();
            System.out.println("Los datos han sido actualizados :)");
        }catch (IOException e){
            System.out.println("ERROR: "+e);
        }
    }
}
