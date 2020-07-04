package OOP.Employee;

public class Employee {
    private String name;
    private String lastName;
    private String patronymic;
    private String position;
    private String email;
    private String phoneNumber;
    private long salary;
    private int age;

    public Employee(String name, String lastName, String patronymic, String position, String email,
                    String phoneNumber, long salary, int age) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void info() {
        System.out.printf("Имя Фамилия Отчество: %s %s %s\n Должность: %s\n" +
                        " Email: %s\n Номер телефона: %s\n Зарплата: %s\n Возраст: %s\n",
                name, lastName, patronymic, position, email, phoneNumber, salary, age);
    }
}
