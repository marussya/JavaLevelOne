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

class InheritanceMain {
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