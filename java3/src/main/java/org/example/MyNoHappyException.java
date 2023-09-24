package org.example;


public class MyNoHappyException extends RuntimeException{
    public MyNoHappyException(int i, int j, String value){
        super("В массиве под индексами [" + i + "]["+ j +"] лежит \"" + value + "\", что в свою очередь является не счастливым числом.");
    }
}
