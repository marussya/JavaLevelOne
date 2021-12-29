/**
 *Java 1. HomeWorkSix: OOP_Inheritance_refactoring
 *
 *@author Marina Bakhareva
 *@version 27.12.2021
 */

//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается
//   длина препятствия. Результатом выполнения действия будет печать в консоль.
//   (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
//   плавание: кот не умеет плавать, собака 10 м.).
//4. * Добавить подсчет созданных котов, собак и животных.

class InheritanceRef {
    public static void main(String[] args) {
        Cat cat = new Cat(200);
        Dog dog = new Dog(500, 10);

        IAnimal[] animals = {cat, dog};
        for (IAnimal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.run(110));
            System.out.println(animal.run(210));
            System.out.println(animal.run(510));
            System.out.println(animal.swim(9));
            System.out.println(animal.swim(11));
        }
        System.out.println("Animals were created: " + Animal.getCountOfAnimals());
    }
}

class Cat extends Animal {

    Cat(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }
    
    Cat(int runLimit) {                                 // перегрузка конструктора
        super(runLimit, 0);
    }

    @Override
    public String swim(int distance) {                  //переопределение метода суперкласса
        return getClassName() + " can't swim";
    }

}

class Dog extends Animal {

    Dog(int runLimit, int swimLimit) {
        super(runLimit, runLimit);
    }
}

abstract class Animal implements IAnimal {
    protected int runLimit;
    protected int swimLimit;
    protected String className;
    protected static int countOfAnimals;

    Animal(int runLimit, int swimLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        className = getClass().getSimpleName();         //reflection API 
        countOfAnimals++;
    }
    
    public String getClassName() {
        return className;
    }
    public static int getCountOfAnimals() {
        return countOfAnimals;
    }
    
    @Override
    public String run(int distance) {                   //переопределение метода интерфейса
        if (distance > runLimit) {
            return className + " couldn't run " + distance + " m";
        } else {
            return className + " successfully run " + distance + " m";
        }
    }
    
    @Override
    public String swim(int distance) {                   //переопределение метода интерфейса
        if (distance > swimLimit) {
            return className + " couldn't swim " + distance + " m";
        } else {
            return className + " successfully swim " + distance + " m";
        }
    }

    @Override
    public String toString() {                            //переопределение метода класса Object
        return className + " can run " + runLimit + " m and can swim " + swimLimit + " m";
    }

}

interface IAnimal {
    String run(int distance);
    String swim(int distance);
}