/**
 *Java_1_level_HomeWorkSeven_OOP_Cats_&_Plate
 *
 *@author Marina Bakhareva
 *@version 29.12.2021
 */

class Lesson7HW {
    public static void main(String[] args) {
        Cat[]cats = {
            new Cat("Barsik", 10),
            new Cat("Tom", 10),
            new Cat("Leo", 10),
            new Cat("Murzik", 10),
            new Cat("Barsik", 10),
        };

        Plate plate = new Plate(31);

        for (Cat cat: cats) {
            cat.eat(plate);
            System.out.println(cat);
            System.out.println(plate);
        }

        plate.increaseFood(40);
        System.out.println("Add foods. " + plate);

        for (Cat cat: cats) {
            cat.eat(plate);
            System.out.println(cat);
            System.out.println(plate);
        }
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean isFull;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    void eat(Plate plate) {
        if (this.isFull != true) {
            if (plate.getFood() > appetite) {
                plate.decreaseFood(appetite);
                isFull = true;
            }
        }
    }

    @Override
    public String toString() {
        return "Cat " + name + " whith appetite " + appetite + " is full: " + isFull;
    }

}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int appetite) {
        if (food >= appetite) {
            food -= appetite;
        } else {
            food = food;
        }
    }

    int getFood() {
        return food;
    }

    void increaseFood(int inFood) {
        food += inFood;
    }

    @Override
    public String toString() {
        return "In a plate: " + food;
    }
}
