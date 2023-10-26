package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        methodOne();
        methodTwo();
        methodThree();
    }
    static final int size = 60_000_000;
    static final int half = size / 2;
    public static void methodOne() {
        float[] array = new float[size];
        Arrays.fill(array, 1.0f);
        long time = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("\n"+array[0]);
        System.out.println(array[array.length - 1]);
        System.out.println("Время выполнения первого метода: " + (System.currentTimeMillis() - time)+"\n");
    }

    public static void methodTwo() {
        float[] array = new float[size];
        float[] firstHalf = new float[half];
        float[] secondHalf = new float[half];
        Arrays.fill(array, 1.0f);
        long time = System.currentTimeMillis();
        System.arraycopy(array, 0, firstHalf, 0, half);
        System.arraycopy(array, half, secondHalf, 0, half);

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < firstHalf.length; i++) {
                firstHalf[i] = (float) (firstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(firstHalf, 0, array, 0, firstHalf.length);
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < secondHalf.length; i++) {
                secondHalf[i] = (float) (secondHalf[i] * Math.sin(0.2f + (half + i) / 5) * Math.cos(0.2f + (half + i) / 5) * Math.cos(0.4f + (half + i) / 2));
            }
            System.arraycopy(secondHalf, 0, array, half, secondHalf.length);
        });
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(array[0]);
        System.out.println(array[array.length - 1]);
        System.out.println("Время выполнения второго метода: " + (System.currentTimeMillis() - time)+"\n");
    }

    public static void methodThree() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long time = System.currentTimeMillis();
        int countThreads = 6;

        while (size % countThreads != 0) {
            countThreads++;
        }

        Thread[] threads = new Thread[countThreads];
        System.out.println("Количество потоков: "+countThreads);
        int partSize = size / countThreads;
        int foldedParts = 0;
        for (int i = 0; i < countThreads; i++)
        {
           //  System.out.println(partSize);
            int finalPartSize = partSize;
            int finalFoldedParts = foldedParts;
            threads[i] = new Thread(() -> {
                float[] part = new float[finalPartSize];

                System.arraycopy(arr, finalFoldedParts, part, 0, finalPartSize);

                for (int j = 0; j < part.length; j++) {
                    part[j] = (float) (part[j] * Math.sin(0.2f + (finalFoldedParts + j) / 5) * Math.cos(0.2f + (finalFoldedParts + j) / 5) * Math.cos(0.4f + (finalFoldedParts + j) / 2));
                }

                System.arraycopy(part, 0, arr, finalFoldedParts, finalPartSize);

            });
            foldedParts += partSize;
            threads[i].start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(arr[0]);
        System.out.println(arr[arr.length-1]);
        System.out.println("Время выполнения третьего метода: " + (System.currentTimeMillis() - time));
    }
}