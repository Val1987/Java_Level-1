package lesson2.homework;

/**
 * Тигашов Валерий ДЗ по уроку №2
 */

/*
1) Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
2) Задать пустой целочисленный массив размером 8. Написать метод, который c помощью цикла заполнит его
значениями 1 4 7 10 13 16 19 22;
3) Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,принимающий на вход массив и
умножающий числа меньше 6 на 2;
4) Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
5) *Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его
диагональные элементы единицами, используя цикл(ы);
6) **Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным,
или отрицательным), при этом метод должен циклически сместить все элементы массива на n позиций.
[1,2,3,4,5], -2 => [3,4,5,1,2]
[1,2,3,4,5], 2 => [4,5,1,2,3]
7) ***Не пользоваться вспомогательным массивом при решении задачи 6.
 */

public class HomeWork2 {

    public static void main(String[] args){

/*        int[] taskArray1 = new int[] { 1, 0, 1, 0, 1, 0, 1, 0, 1 };
        taskFirst(taskArray1);

*/

/*        int[] taskArray2 = new int[8];
        taskSecond(taskArray2);
*/

/*        int[] taskArray3 = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        taskThird(taskArray3);
*/

/*        int[] taskArray4 = new int[] { 1, 5, 3, 2, 11, 4, 5, 40, 4, 8, 9, 7 };
        System.out.print(taskForth1(taskArray4) + " | ");
        System.out.print(taskForth2(taskArray4));
*/
        int[][] taskArray5 = new int[3][3];
        taskFifth(taskArray5);

    }


/*   public static void taskFirst(int[] replace){

        for (int i = 0; i < replace.length; i++) {
            if (replace[i] == 0)
                replace[i] = 1;
            else if (replace[i] == 1)
                replace[i] = 0;
            System.out.print(replace[i] + " | ");

        }
   }
*/
/*   public static void taskSecond(int[] fill){

       int j = 1;
       for (int i = 0; i < fill.length; i++){
           fill[i] = j;
           j+=3;
           System.out.print(fill[i] + " | " );

       }

   }
*/
/*   public static void taskThird(int[] multiply){

       for (int i = 0; i < multiply.length; i++) {
           if (multiply[i] <6)
               multiply[i] *=2;
           System.out.print(multiply[i] + " | " );

       }

   }
*/

/*    public static int taskForth1(int[] search){

        int min = search[0];
        for (int j : search) {
            if (j < min)
                min = j;
        }
        return min;
    }

    public static int taskForth2(int[] search){

        int max = search[0];
        for (int j : search) {
            if (j > max)
                max = j;
        }
        return max;
    }
*/

    public static void taskFifth(int[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ( i == j )
                    matrix[i][j] = 1;
                else matrix[i][j] = 0;
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

    }

}
