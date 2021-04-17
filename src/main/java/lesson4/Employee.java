package lesson4;

/**
 * 1 Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
 * 2 Конструктор класса должен заполнять эти поля при создании объекта;
 * 3 Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
 * 4 Вывести при помощи методов из пункта 3 ФИО и должность.
 * 5 Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 * 6* Создать метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;
 * 7** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
 */

public class Employee {

    private String lastName;
    private String firstName;
    private String middleName;
    private String position;
    private String phone;
    private double salary;
    private int age;

    private static int counter = 0;
    private int number;

    Employee(String lastName, String firstName, String middleName, String position, String phone, double salary, int age) {
        this.number = ++Employee.counter;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

//-------------------------------GET------------------------------------

    public int getNumber() {
        return number;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void raceSalary() {
        if (age >= 40)
            salary += 10000;
    }

//-------------------------------------------------------------------

    public static void main(String[] args) {

        Employee empl1 = new Employee("Tigashov", "Valeriy", "Evgen'evich",
                "DevOps", "+7-999-000-00-00", 40000.0, 33);

        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("| "+empl1.getNumber()+" | "+empl1.getLastName()+" "+empl1.getFirstName()+" "+empl1.getMiddleName()+" "+empl1.getPosition());
        System.out.println("|------------------------------------------------------------------------------|");

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov-1", "Ivan-1", "Ivanovich-1",
                "DevOps-1", "+7-111-111-11-11", 30000.0, 23);
        employees[1] = new Employee("Ivanov-2", "Ivan-2", "Ivanovich-2",
                "DevOps-2", "+7-222-222-22-22", 30000.0, 43);
        employees[2] = new Employee("Ivanov-3", "Ivan-3", "Ivanovich-3",
                "DevOps-3", "+7-333-333-33-33", 30000.0, 48);
        employees[3] = new Employee("Ivanov-4", "Ivan-4", "Ivanovich-4",
                "DevOps-4", "+7-444-444-44-44", 30000.0, 34);
        employees[4] = new Employee("Ivanov-5", "Ivan-5", "Ivanovich-5",
                "DevOps-5", "+7-555-555-55-55", 30000.0, 59);

        for (int i = 0; i < 5; i++) {
            if (employees[i].age > 40)
                System.out.println("| "+employees[i].getNumber()+" | "+employees[i].getLastName()+" "+employees[i].getFirstName()+" "
                        +employees[i].getMiddleName()+" | "+employees[i].getPosition()+" | "
                        +employees[i].getPhone()+" | "+employees[i].getSalary()+" | "+employees[i].getAge()+" |");

        }

        System.out.println("|------------------------------------------------------------------------------|");

        for (int i = 0; i < 5; i++) {
            employees[i].raceSalary();
            System.out.println("| "+employees[i].getNumber()+" | "+employees[i].getLastName()+" "+employees[i].getFirstName()+" "
                    +employees[i].getMiddleName()+" | "+employees[i].getPosition()+" | "
                    +employees[i].getPhone()+" | "+employees[i].getSalary()+" | "+employees[i].getAge()+" |");
        }

        System.out.println("|------------------------------------------------------------------------------|");

    }

}
