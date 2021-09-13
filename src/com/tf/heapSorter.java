package com.tf;
import java.util.ArrayList;

class heapSorter {

private static class SortThread extends Thread {
    SortThread(Integer[]arry){
        super(()->{
           heapSorter.SortSomesort2(arry);
        });
        this.start();
    }
}
public static void sortingThread(Integer[][]arry,int tNumber,int height) {


    final ArrayList<SortThread> threadsL=new ArrayList<>();
    for(int loop=0;loop<height;loop=tNumber+loop){
        for(int loop2=0;loop2<tNumber;loop2++) {
            SortThread t= new SortThread(arry[loop+loop2]);
            threadsL.add(t);
        }
        for (Thread t:threadsL){
            try{
                t.join();
            }catch (InterruptedException ignored){}
        }
        threadsL.clear();
    }

}
    public static void SortSomesort2(Integer[] arry2)  {
        buildHeap(arry2);
        for (int i = arry2.length-1; i > 0; i--) {
            swap(arry2, 0, i);
            buildMaxHeap(arry2, 0, i-1);
        }
    }

    public static void buildHeap(Integer arr[]) {
        for (int i = (arr.length-1)/2; i >= 0; i--)
            buildMaxHeap(arr, i, arr.length-1);
    }

    public static void buildMaxHeap(Integer arr[], int i, int N) {
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])
            max = right;
        if (max != i) {
            swap(arr, i, max);
            buildMaxHeap(arr, max, N);
        }
    }

    public static void swap(Integer arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
