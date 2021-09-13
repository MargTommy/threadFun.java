package com.tf;

public class arryReader {
    void readIt(Integer[][] readArry){
        System.out.println("Wczytanie tablicy: ");
        for(Integer[] x :readArry) {
            for (int y : x) {
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }
}
