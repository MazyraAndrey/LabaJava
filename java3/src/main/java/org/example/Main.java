package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"102102", "300111", "100217", "755109"},
                {"118010", "110021", "148651", "78137"},
                {"840544", "1098412", "302111", "321700"},
                {"10063", "165007", "184173", "125579"}
        };

        try {
            System.out.println("Сумма чисел матрицы: " + method(array));
        }
        catch (MyArraySizeException | MyArrayDataException | MyNoHappyException e){
            e.printStackTrace();
        }
    }

    public static int method(String[][] array) throws MyArraySizeException, MyArrayDataException, MyNoHappyException {

        if(array.length != 4){
            throw new MyArraySizeException();
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4){
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        int number;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    number = Integer.parseInt(array[i][j]);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }

                try{
                    if(unluckyNumber(number)){
                        throw new MyNoHappyException(i, j, array[i][j]);
                    }
                }
                catch (MyNoHappyException ee){
                    ee.printStackTrace();
                }

            }
        }
        return sum;
    }

    public static boolean unluckyNumber(int number) {
        char[] value = String.valueOf(number).toCharArray();
        if(value.length != 6)
            return false;

        int part1 = 0;
        int part2 = 0;
        for (int i = 0; i < 6; i++) {

            if(i < 3){

                part1 += Character.digit(value[i], 10);
            }
            else
                part2 += Character.digit(value[i], 10);

        }
        return part1 == part2;
    }
}