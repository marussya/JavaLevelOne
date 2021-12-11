/*task_1*/
class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }
    /*task_2*/
    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    /*task_3*/
    static void checkSumSign() {
        int a = 10, b = 15, sum = a + b;
        System.out.println(sum >= 0 ? "Sum positive" : "Sum negative");
    }

    /*task_4*/
    static void printColor() {
        int value = 102;

        if (value <= 0) {
            System.out.println("Red");
        } else if (value > 0 && value <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }
    /*task_5*/
    static void compareNumbers() {
        int a = 5, b = 5;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }
}
