/*
Cambiar los metodos de carga e imprime para que sean recursivos.
Implementa el metodo de manera recursiva para obtener el promedio del arreglo
 *
 * @author Pedro Díaz
 @modify by: Joel Jacome Pioquinto - S18001428
 */
package com.jpdev.dp.examen1;

public class ExaJoel {
        int arr [] = new int [10];
        int con=0;
        double prom = 0;
       
        public void carga(){
          if (con == 10) {
              con = 0;
              return;
          }
          arr[con] = (int) (Math.random() * 10 + 1);
          con++;
          carga();
        }

        public void imprime(){
           if (con == 10){
               con = 0;
               return;
           }
           System.out.println(con+" [ "+arr[con]+" ]");
           con++;
           imprime();
        }

        // Metodo recursivo que obtenga el promedio de todas las calificaciones
        public void promedio(){
            if (con == 10){
                prom = prom / 10;
                System.out.println("El promedio es: "+prom);
                con = 0;
                return;
            }
            prom += arr[con];
            con++;
            promedio();
        }
         
        public static void main(String[] args) {
            ExaJoel xx = new ExaJoel();
            xx.carga();
            xx.imprime();
            xx.promedio();
        }
}
