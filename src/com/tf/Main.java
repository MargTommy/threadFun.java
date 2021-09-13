package com.tf;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.System;

public class Main {

//Tak słaby ten program,szczegolnie na samym koncu, ale czas mi się kończył i spanikowałem.
    public static void main(String[] args) throws IOException {

        int rowsSize = 40000;//liczba kolumn (dla pliku)
        int rowsSizeSmall = 1000; //liczba kolumn do sortowania(mniejsza)
        int colSize = 16;//liczba wierszy
        int rangeRandom =2000000; //max losowanej liczny
        String path = "dane.txt"; //ściezka do pliku
        long time =0; //dla czasu xD

        Randomizer arry = new Randomizer();
        Integer[][] arrySort = new Integer[colSize][rowsSizeSmall];
        Integer[][] arrySortClone = new Integer[colSize][rowsSizeSmall];
        Integer[] justArry = new Integer[rowsSize];
        arryReader readArry =new arryReader();
        System.out.println("Generowanie Tablicy. Zapis Kopi do Pliku!");
        arryCloner cloneArry = new arryCloner();

        DataOutputStream outputStream = null;
        outputStream = new DataOutputStream(new FileOutputStream(path));
        for (int loop = 0; loop < colSize; loop++) {
            arry.rowCreator(justArry, rowsSize,rangeRandom);
            for (int number : justArry) {
                outputStream.writeInt(number);
                for (int loop2 = 0; loop2 < rowsSizeSmall; loop2++)
                    arrySort[loop][loop2] = justArry[loop2];
            }
        }
        outputStream.close();

        System.out.println("Generowanie Tablicy zakończone!");
        cloneArry.clone(arrySort,arrySortClone,rowsSizeSmall,colSize);


        System.out.println("Liczba wątków użyta do sortowania: 1");
        heapSorter sortingThread = new heapSorter();
        time=System.currentTimeMillis();
        sortingThread.sortingThread(arrySortClone,1,colSize);
        time=System.currentTimeMillis()-time;
        System.out.println("Czas wykonania tego wątku wyniusł: "+time);

        System.out.println("Liczba wątków użyta do sortowania: 2");
        cloneArry.clone(arrySort,arrySortClone,rowsSizeSmall,colSize);
        time=System.currentTimeMillis();
        sortingThread.sortingThread(arrySortClone,2,colSize);
        time=System.currentTimeMillis()-time;
        System.out.println("Czas wykonania tego wątku wyniusł: "+time);

        System.out.println("Liczba wątków użyta do sortowania: 4");
        cloneArry.clone(arrySort,arrySortClone,rowsSizeSmall,colSize);
        time=System.currentTimeMillis();
        sortingThread.sortingThread(arrySortClone,4,colSize);
        time=System.currentTimeMillis()-time;
        System.out.println("Czas wykonania tego wątku wyniusł: "+time);

        System.out.println("Liczba wątków użyta do sortowania: 8");
        cloneArry.clone(arrySort,arrySortClone,rowsSizeSmall,colSize);
        time=System.currentTimeMillis();
        sortingThread.sortingThread(arrySortClone,8,colSize);
        time=System.currentTimeMillis()-time;
        System.out.println("Czas wykonania tego wątku wyniusł: "+time);


        System.out.println("Liczba wątków użyta do sortowania: 16");
        cloneArry.clone(arrySort,arrySortClone,rowsSizeSmall,colSize);
        time=System.currentTimeMillis();
        sortingThread.sortingThread(arrySortClone,16,colSize);
        time=System.currentTimeMillis()-time;
        System.out.println("Czas wykonania tego wątku wyniusł: "+time);


        /*for(int loop=0;loop<colSize;loop++) {
            sortingThread.sortingThread(arrySortClone[loop],1);
        }*/


        /*System.out.println("Liczba wątków użyta do sortowania: 2");
        //sort with two
        cloneArry.clone(arrySort,arrySortClone,rowsSizeSmall,colSize);
        time=System.currentTimeMillis();
        for(int loop=0;loop<(colSize/2);loop++) {
            sortingThread.sortingThread(arrySortClone[loop]);
            sortingThread.sortingThread(arrySortClone[loop+8]);
        }
        time=System.currentTimeMillis()-time;
        System.out.println("Czas wykonania tego wątku wnyniusł: "+time);

        System.out.println("Liczba wątków użyta do sortowania: 4");
        //sort with four
        cloneArry.clone(arrySort,arrySortClone,rowsSizeSmall,colSize);
        time=System.currentTimeMillis();
        for(int loop=0;loop<(colSize/4);loop++) {
            sortingThread.sortingThread(arrySortClone[loop]);
            sortingThread.sortingThread(arrySortClone[loop+4]);
            sortingThread.sortingThread(arrySortClone[loop+8]);
            sortingThread.sortingThread(arrySortClone[loop+12]);
        }
        time=System.currentTimeMillis()-time;
        System.out.println("Czas wykonania tego wątku wnyniusł: "+time);
        System.out.println("Liczba wątków użyta do sortowania: 8");
        //sort with eight
        cloneArry.clone(arrySort,arrySortClone,rowsSizeSmall,colSize);
        time=System.currentTimeMillis();
        for(int loop=0;loop<(colSize/8);loop++) {
            sortingThread.sortingThread(arrySortClone[loop]);
            sortingThread.sortingThread(arrySortClone[loop+2]);
            sortingThread.sortingThread(arrySortClone[loop+4]);
            sortingThread.sortingThread(arrySortClone[loop+6]);
            sortingThread.sortingThread(arrySortClone[loop+8]);
            sortingThread.sortingThread(arrySortClone[loop+10]);
            sortingThread.sortingThread(arrySortClone[loop+12]);
            sortingThread.sortingThread(arrySortClone[loop+14]);
        }
        time=System.currentTimeMillis()-time;
        System.out.println("Czas wykonania tego wątku wnyniusł: "+time);
        //sort with sixteen
        System.out.println("Liczba wątków użyta do sortowania: 16");
        cloneArry.clone(arrySort,arrySortClone,rowsSizeSmall,colSize);
        time=System.currentTimeMillis();
        sortingThread.sortingThread(arrySortClone[0]);
        sortingThread.sortingThread(arrySortClone[1]);
        sortingThread.sortingThread(arrySortClone[2]);
        sortingThread.sortingThread(arrySortClone[3]);
        sortingThread.sortingThread(arrySortClone[4]);
        sortingThread.sortingThread(arrySortClone[5]);
        sortingThread.sortingThread(arrySortClone[6]);
        sortingThread.sortingThread(arrySortClone[7]);
        sortingThread.sortingThread(arrySortClone[8]);
        sortingThread.sortingThread(arrySortClone[9]);
        sortingThread.sortingThread(arrySortClone[10]);
        sortingThread.sortingThread(arrySortClone[11]);
        sortingThread.sortingThread(arrySortClone[12]);
        sortingThread.sortingThread(arrySortClone[13]);
        sortingThread.sortingThread(arrySortClone[14]);
        sortingThread.sortingThread(arrySortClone[15]);
        time=System.currentTimeMillis()-time;
        System.out.println("Czas wykonania tego wątku wnyniusł: "+time);
        */readArry.readIt(arrySortClone);
    }
}
