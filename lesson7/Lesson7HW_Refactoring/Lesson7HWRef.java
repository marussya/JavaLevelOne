/**
 *Java_1_level_HomeWorkSeven_OOP_Cats_&_Plate_refactoring
 *
 *@author Marina Bakhareva
 *@version 29.12.2021
 */
/*
Эту версию кода преподаватель показал на занятии, но она не выполняет
все поставленные в ДЗ задачи:  в этом коде коты едят, даже если сыты.

ДЗ звучало так:
1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного
количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой
тарелки и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
7. На вебинаре преподаватель поставил дополнительное условие:
кот не должен есть из тарелки, если он сыт.
 */

class Lesson7HWRef {
    public static void main(String[]args) {
        Cat[]cats = {
            new Cat("Barsik", 15),
            new Cat("Tom", 10),
            new Cat("Leo", 20),
        };

        Plate plate = new Plate(50, 30);
        System.out.println(plate);

        //feeding cats first time
        for (Cat cat: cats) {
            cat.eat(plate);
            System.out.println(cat);
        }

        //adding food in the plate
        System.out.println(plate);
        plate.increaseFood(40);
        System.out.println("Add foods. " + plate);

        //feeding cats first time
        for (Cat cat: cats) {
            cat.setFullness(false);
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
    }
}

class Cat {
    private String name;
    private int appetite; //ability toeat for 1 time
    private boolean isFull; //satiety status

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    void setFullness(boolean status) {
        isFull = status;
    }

    void eat(Plate plate) {
        if (!isFull) {
            isFull = plate.decreaseFood(appetite);
        }
    }

    @Override
    public String toString() {
        return "Cat " + name + " whith appetite " + appetite + " is full: " + isFull;
    }

}

class Plate {
    private int volume;
    private int food;

    Plate(int volume, int food) {
        this.volume = volume;
        this.food = food;
    }

    boolean decreaseFood(int appetite) {
        if (food < appetite) {
            return false;
        }
        food -= appetite;
        return true;
    }

    void increaseFood(int food) {
        if (this.food + food <= volume) {
            this.food += food;
        }
    }

    @Override
    public String toString() {
        return "In a plate: " + food;
    }
}
