/**
 *Java_1_level_HomeWorkFive_OOP
 *
 *@author Marina Bakhareva
 *@version 22.12.2021
 */
class Staffers {
    public static void main(String[]args) {
        Person[]staffers = new Person[5];
        staffers[0] = new Person("Ivan Ivanov", "prodact manager", "iivanov@mail.com", "+79994781067", 200000, 30);
        staffers[1] = new Person("Petr Petrov", "designer", "ppetrov@mail.com", "79994781078", 90000, 27);
        staffers[2] = new Person("Semen Semenov", "frontender", "ssemenov@mail.com", "79994781089", 135000, 41);
        staffers[3] = new Person("Jon Doe", "backender", "jdoe@mail.com", "79994781068", 137000, 52);
        staffers[4] = new Person("Jane Air", "tester", "jair@mail.com", "79994781011", 90000, 39);
        for (Person person: staffers) {
            if (person.getAge() > 40)
                System.out.println(person);
            System.out.println();
        }
    }
}

class Person {
    private String username;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public int getAge() {
        return age;
    }

    Person(String username, String position, String email, String telephone, int salary, int age) {
        this.username = username;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

     @ Override
    public String toString() {
        return "Name: " + username + ";\n" +
        "Position: " + position + ";\n" +
        "Email: " + email + ";\n" +
        "Telephone: " + telephone + ";\n" +
        "Salary: " + salary + ";\n" +
        "Age: " + age;
    }
}
