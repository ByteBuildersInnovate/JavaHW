package homework3;

public class Homework3 {
    public static void main(String[] args) {

        System.out.println("Task1");
        replaceArray(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0});
        System.out.println();

        System.out.println("Task2");
        fillArray(100);
        System.out.println();

        System.out.println("Task3");
        changeArray(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
        System.out.println();

        System.out.println("Task4");
        fillDiagonal(new int[4][4]);
        System.out.println();

        System.out.println("Task5");
        argumentsArray(5,10);
        System.out.println();

        System.out.println("Task6");
        ambitArray(new int[]{2, 11, 4, 5, 2, 4, 8, 9});

    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    //С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void replaceArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;

    public static void fillArray(int size) {
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

    public static void changeArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    //и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
    // если обе сложно).

    public static void fillDiagonal(int[][]arr) {
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(i == j){
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа
    // int длиной len, каждая ячейка которого равна initialValue;

    public static void argumentsArray(int len, int initialValue) {
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = initialValue;
            System.out.println("["+ i +"]" + arr[i]);
        }
        System.out.println();
    }

    //6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы;

    public static void ambitArray(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int j : arr) {
            if (j < min) {
                min = j;
            }
            if (j > max) {
                max = j;
            }
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }
}
