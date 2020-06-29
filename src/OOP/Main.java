package OOP;

public class Main {
    public static void main(String[] args) {
        printPersonWithAge40();
    }

    public static void printPersonWithAge40() {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee
                ("Иван", "Иванов", "Иванович", "CEO", "iii@mail.ru",
                        "8-999-999-99-99", 250000, 31);
        employees[1] = new Employee
                ("Еван", "Еванов", "Иванович", "Senior", "eei@mail.ru",
                        "8-999-999-99-99", 170000, 45);
        employees[2] = new Employee
                ("Владимир", "Владимиров", "Владимирович", "Middle", "vvv@mail.ru",
                        "8-999-999-99-99", 100000, 41);
        employees[3] = new Employee
                ("Леонид", "Леонидов", "Леонидович", "Junior", "lll@mail.ru",
                        "8-999-999-99-99", 50000, 21);
        employees[4] = new Employee
                ("Дмитрий", "Дмитров", "Дмитриевич", "None", "ddd@mail.ru",
                        "8-999-999-99-99", 0, 9);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].info();
            }
        }
    }
}
