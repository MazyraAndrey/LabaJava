package org.example;

// неправильный размер массива
public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {
        super("Размер матрицы не 4x4!");
    }

}
