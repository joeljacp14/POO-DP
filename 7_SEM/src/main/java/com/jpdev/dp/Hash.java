package com.jpdev.dp;

public class Hash {
    public int hash1 (int clave){
        return clave % 16;

    }

    public int hash2(String s, int M) {

        long sum = 0, mul = 1;

//        for (int i = 0; s.[i]!='\0'; i++) {
//            mul = (i % 4 == 0) ? 1 : mul * 256;
//            sum += s[i] * mul;
//        }
//        return (int)(labs(sum) % M);
        return 0;
    }

    public static void main(String[] args) {
        Hash hash = new Hash();
        System.out.println("hash 1 de la clave "+hash.hash1(56));
        System.out.println("hash 2 de la clave "+hash.hash2("Joel Jacome", 54));
    }
}
