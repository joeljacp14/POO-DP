package com.jpdev.dp.sources.MaxComunDivisor;

/*
Calcular el maximo comun divisor de 2 numeros
Segun: Kevin
 *
 * @author Pedro Diaz
 */
public class MaxComDiv {
    
    public static void main(String[] args) {
        int num1=36,num2=96,residuo,mcd=0;// eliminar mcd
        do{
            residuo = num1%num2;
            if (residuo!=0){
                num1 = num2;
                num2 = residuo;
            }
            //}else mcd = num2; // eliminamos el else
        }while(residuo!=0);
        System.out.println("El Max Com Div es: "+num2);
    }
    
}
