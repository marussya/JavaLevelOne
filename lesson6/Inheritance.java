/**
 *Java_1_level_HomeWorkSix_OOP_Inheritance
 *
 *@author Marina Bakhareva
 *@version 25.12.2021
 */

//
//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается
//   длина препятствия. Результатом выполнения действия будет печать в консоль.
//   (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
//   плавание: кот не умеет плавать, собака 10 м.).

class Inheritance {
    public static void main(String[]args) {
        IAnimal cat = new Cat("Murzic", 200, 0);
        IAnimal dog = new Dog("Polcan", 500, 10);
        IAnimal[]animals = {
            cat,
            dog
        };
        for (IAnimal a: animals) {
            System.out.println(a);
            System.out.println(a.voice());
            System.out.println(a.run(200));
            System.out.println(a.swim(11));
        }
    }
}

class Cat extends Animal {

    Cat(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
    }

     @ Override
    public String voice() {
        return "Meow!";
    }

     @ Override
    public String run(int distance) {
        return (distance <= maxRunDistance) ? "The " + name + " run " + distance + " m" :
        "The " + name + " couldn't run " + distance + " m";
    }

     @ Override
    public String swim(int distance) {
        return "I can't swim! Meow!";
    }

}

class Dog extends Animal {

    Dog(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
    }

     @ Override
    public String voice() {
        return "gaf-gaf!";
    }

     @ Override
    public String run(int distance) {
        return (distance <= maxRunDistance) ? "The " + name + " run " + distance + " m" :
        "The " + name + " couldn't run " + distance + " m";
    }

     @ Override
    public String swim(int distance) {
        return (distance <= maxSwimDistance) ? "The " + name + " swim " + distance + " m" :
        "The " + name + " couldn't swim " + distance + " m";
    }

}

interface IAnimal {
    String voice();
    String run(int distance);
    String swim(int distance);
}

abstract class Animal implements IAnimal {
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;

    Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

     @ Override
    public String toString() {
        return name /*+ ", can run " + maxRunDistance + " m and can swim " + maxSwimDistance + " m"*/;
    }

}
