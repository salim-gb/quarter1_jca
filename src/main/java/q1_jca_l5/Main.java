package q1_jca_l5;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
          new Employee("Иван", "Смирнов", "Учитель", "ivanivanovich@yandex.ru", "89267657834", 58000, 36, "м"),
          new Employee("Андрей", "Кузнецов", "Инженер", "andrey34@yandex.ru", "89261812209", 30000, 48, "м"),
          new Employee("Татьяна", "Иванова", "Бухгалтер", "tatyana.m23@yandex.ru", "89280341578", 32000, 62, "ж"),
          new Employee("Владимир", "Соколов", "Врач", "vladimir91@yandex.ru", "89050918754", 45000, 32, "м"),
          new Employee("Светлана", "Семенова", "Медсестра", "svet0021@yandex.ru", "89260986646", 42000, 30, "ж"),
          new Employee("Александр", "Козлов", "Инженер", "sasha23mn@yandex.ru", "89260986646", 42000, 30, "м"),
          new Employee("Юрий", "Попов", "Водитель", "yuri1209@gmail.com", "89679870035", 27000, 67, "м")
        };

        for (Employee e : employees) {
            if (e.getAge() > 40) {
                e.info();
                System.out.println();
                System.out.println();
            }
        }

        System.out.printf("Количество сотрудников в компании: %d\n", Employee.getEmployeeCount());
    }
}
