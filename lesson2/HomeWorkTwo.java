/**
*Java_1_level_HomeWork_2
*
*@author Marina Bakhareva
*@version 12.12.2021
*/

class HomeWorkTwo {
    public static void main(String[] args) {
        System.out.println(isSumWithin10and20(8, 6));
        isPositiveOrNegative(-60);
        System.out.println(isNegative(-8));
        printStringInTimes("Hello", 3);
        System.out.println(isLeapYear(2021));
        
    }
    
    /*task_1*/
    
    /*static boolean isSumWithin10and20(int x, int y) {
        if (x + y >= 10 && x + y <= 20) {
            return true;
        } else {
            return false;
        }
    }
    задача в комментарии была закомментирована мною изначально для примера логики
    */
    
    static boolean isSumWithin10and20(int x, int y) {
        return (x + y >= 10 && x + y <= 20);
    }
    
    /*task_2*/
    
/*    static void isPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is negative");
        }
    }
    ниже задание исправлено по результатам разбора ДЗ
    */
    static void isPositiveOrNegative(int x) {
        System.out.println(x >= 0? "Number is positive" : "Number is negative");
    }
    
    /*task_3*/
    
    static boolean isNegative(int x) {
        return(x < 0);
    }
    
    /*task_4*/
    
    /*лучше назвать метод repeatString (по результатам разбора ДЗ) */
    static void printStringInTimes(String str, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(str);
        }
    }
    
    /*task_5(*)*/
    
    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
        
    }
    
}