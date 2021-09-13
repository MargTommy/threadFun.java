package com.tf;

public class arryCloner {
    Integer[][] clone(Integer[][]clonningArry,Integer[][]clonedArry,int sizeX,int sizeY) {
        for(int y=0;y<sizeY;y++)
            for(int x=0;x<sizeX;x++) {
                clonedArry[y][x]=clonningArry[y][x];
            }
        return clonedArry;
    }
}
