package com.tf;
import java.util.Random;

public class Randomizer {

    Integer[] rowCreator(Integer[] arryArandom, int arryLengh,int range) {
       Random randInt = new Random();
       for (int loop=0;loop<arryLengh;loop++) {
           Integer someInt= randInt.nextInt(range);
           arryArandom[loop]=someInt;
       }
       return arryArandom;
    }

}
