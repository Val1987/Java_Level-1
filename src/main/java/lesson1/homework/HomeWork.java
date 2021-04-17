package lesson1.homework;

/**
 * Тигашов Валерий ДЗ по уроку №1
 */

/*
  1) Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой,
  где a, b, c, d – целочисленные входные параметры этого метода;

  2) Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах от 10
  до 20(включительно), если да – вернуть true, в противном случае – false;

  3) Написать метод, которому в качестве параметра передается целое число, метод должен проверить положительное
  ли число передали, или отрицательное. Замечание: ноль считаем положительным числом. Результат работы метода
  вывести в консоль;

  4) Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вернуть
  приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль;

  5) *Написать метод, который определяет является ли год високосным. Каждый 4-й год является високосным,
  кроме каждого 100-го, при этом каждый 400-й – високосный. Для проверки работы вывести результаты работы
  метода в консоль.
 */

public class HomeWork {

    public static double firstTask (double a, double b, double c, double d) {
        return a*(b+c/d);
    }

    public static boolean secondTask (int a, int b) {
        if (a+b>=10 && a+b<=20) return true;
        else return false;
    }

    public static boolean thirdTask (int a) {
        return a>=0;
    }

    public static void forthTask(String name) {
        System.out.println ("Привет,"+name);
    }

    public static boolean fifthTask (int y) {
        boolean vis = (y-1980)%4==0;
        boolean hund = y%100==0;
        boolean forHund = y%400==0;
        return (vis&&!hund)||forHund;
    }

    // 5-е задание делал под наставлением отчима (программист), ибо хрен бы сам соориентировался!((

    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        int c = 13;
        int d = 2;
        double result = firstTask (a,b,c,d);
        System.out.println (result);
        System.out.println (secondTask (a,b));
        System.out.println (thirdTask (a));
        forthTask ("Valeriy");
        System.out.print (fifthTask(2021));
    }
 }
