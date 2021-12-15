/**
*Java_1_level_HomeWork_3
*
*@author Marina Bakhareva
*@version 14.12.2021 - нормальная сложность (1-5 задания);
*@version 15.12.2021 - 6-7 задания
*/
import java.util.Arrays;

class HomeWorkThree {
    public static void main(String[] args) {
        invertArr();
        fillArray();
        multiplyLessThanSix();
        fillDiagonal(11);
        System.out.println(Arrays.toString(getArray(10, 5)));
        getMinMax();
        System.out.println(checkBalance());

    }
/*task_1 - инвертировать значения в массиве из нулей и единиц*/
    static void invertArr() {
        System.out.println("task_1");
        int[] arr = {1, 0, 1, 0, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != 0) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            };
        }
        System.out.println(Arrays.toString(arr));
    }
    
/*task_2 - создать пустой массив длиной 100 и заполнить его значениями 1-100*/
    static void fillArray() {
        System.out.println("task_2");
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }
/*task_3 - задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
пройти по нему циклом, и числа меньшие 6 умножить на 2*/
    static void multiplyLessThanSix() {
        System.out.println("task_3");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            };
        }
        System.out.println(Arrays.toString(arr));
    }
    
/*task_4 - Создать квадратный двумерный целочисленный массив 
и заполнить его диагональ единицами;
во вложенном цикле потребовалось дополнительно объявить переменную обратного счетчика n, 
которая уменьшается при увеличении счетчика j*/
    static void fillDiagonal(int a) {
        System.out.println("task_4");
        int[][] arr = new int[a][a];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, n = arr.length - 1; j < arr.length; j++, n--){
                if(i == j || i == n) {
                    arr[i][j] = 1;
                } 
        System.out.print(arr[i][j] + "  ");
        }
    System.out.println();
        }
    }
    
/*task_5 - написать метод, принимающий аргументы len и initialValue 
и возвращающий одномерный массив типа int длиной len, 
каждая ячейка которого равна initialValue*/
    static int[] getArray(int len, int initialValue){
        System.out.println("task_5");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++){
            arr[i] = initialValue;
            }
        return arr;
    }
    
/*task_6 - Задать одномерный массив и найти в нем минимальный и 
максимальный элементы*/
    static void getMinMax(){
        System.out.println("task_6");
        int[] arr = {1, 5, 3, 2, -111, 4, 5, 2, 4, 8, 9, 1, 185, -66};
        int min = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            else if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Minimum value = " + min);
        System.out.println("Maximum value = " + max);
    }
    
/*task_7 - Написать метод, в который передается не пустой одномерный
целочисленный массив, метод должен вернуть true, если в массиве есть
место, в котором сумма левой и правой части массива равны.*/
    static boolean checkBalance() {
        System.out.println("task_7");
        int[] arr = {1, 1, 1, 1, 4};
        int leftPart = 0, rightPart = Arrays.stream(arr).sum();
        for (int a : arr) {
            if(leftPart == rightPart) {
                return true;
            } else {
            leftPart += a;
            rightPart -= a;
            }
        }
        return leftPart == rightPart;
    }
}

