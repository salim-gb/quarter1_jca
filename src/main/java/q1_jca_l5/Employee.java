package q1_jca_l5;

public class Employee {
    private static int employeeCount = 0;
    private final String firstName;
    private final String surname;
    private final String position;
    private final String email;
    private final String phone;
    private final int salary;
    private final int age;
    private final String sex;
    private final int employeeNumber;

    public Employee(String firstName,
                    String surname,
                    String position,
                    String email,
                    String phone,
                    int salary,
                    int age,
                    String sex)
    {
        employeeCount++;
        this.employeeNumber = employeeCount;
        this.firstName = firstName;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
    }

    public void info() {
        System.out.println("Information about this employee is:");
        System.out.printf("Имя: %s\nФамилия: %s\nДолжность: %s\nemail: %s\n" +
                "телефон: %s\nЗараплата: %d\nВозраст: %d\nПол: %s\nПенсионер: %b\n",
                this.firstName, this.surname, this.position,
                this.email, this.phone, this.salary, this.age, this.sex, this.isRetired());
        System.out.printf("Этот сотрудник в компании, идет под номером: %d\n", employeeNumber);
    }

    public int getAge() {
        return this.age;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public boolean isRetired() {
        if (this.sex.equals("м") && this.age > 65) {
            return true;
        } else return this.sex.equals("ж") && this.age > 60;
    }
}
