package com.compsa.liczbapi;

import java.util.Scanner;

public class LiczbaPi {
    public static void main(String[] args) {

        wypiszIloscProb(10);
    }
//    public static int getInt() {
//        return new Scanner(System.in).nextInt();
//    }
    public static void wypiszIloscProb(int ileRazy) {
        double x,y;
        int k=0;
        for(int i=1; i<=ileRazy; i++){
            x=Math.random();
            y=Math.random();
            if(x*x+y*y<=1) k++;
        }
        double p=4.*k/ileRazy;
        System.out.format("%.4f%n", p);
    }
}

