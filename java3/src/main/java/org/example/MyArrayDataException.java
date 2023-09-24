package org.example;

//в ячейке массива лежит что-то не то
public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int i, int j, String value){
        super("В массиве под индексами [" + i + "]["+ j +"] лежит \"" + value + "\", что в свою очередь является не числом.");
    }
}
