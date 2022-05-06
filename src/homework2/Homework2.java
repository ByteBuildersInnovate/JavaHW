package homework2;

public class Homework2 {
    public static void main(String[] args) {


        System.out.println("***********");
        System.out.println(comparison(15, 5));

        System.out.println("***********");
        System.out.println(number(-1));

        System.out.println("***********");
        System.out.println(positiveOrNegative(0));

        System.out.println("***********");
        System.out.println(cycle(3, "Cycle"));

        System.out.println("***********");
        System.out.println(year(2004));
    }

    //1. Написать метод, принимающий на вход два целых числа и проверяющий,
    //что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
    //в противном случае – false.

    public static boolean comparison(int a, int b) {

        return a + b >= 10 && a + b <= 20;
    }

    //2. Написать метод, которому в качестве параметра передается целое число,
    //метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    //Замечание: ноль считаем положительным числом.

    public static String number(int value) {

        if (value >= 0) {
            return "Число положительное.";
        } else {
            return "Чмсло отрицательное.";
        }
    }

    //3. Написать метод, которому в качестве параметра передается целое число.
    //Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.

    public static boolean positiveOrNegative(int x) {
        return x >= 0;
    }

    //4. Написать метод, которому в качестве аргументов передается строка и число,
    //метод должен отпечатать в консоль указанную строку, указанное количество раз;

    public static String cycle(int n, String s){

        for (int i = 0; i < n-1; i++) {
            System.out.println(s);
        }
        return s;
    }

    //5.* Написать метод, который определяет, является ли год високосным,
    //и возвращает boolean (високосный - true, не високосный - false).
    //Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static boolean year(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}
