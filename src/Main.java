import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать объект класса A");
            System.out.println("2. Создать объект класса B");
            System.out.println("3. Выход");

            // Проверка на корректный ввод
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        A a = new A();
                        System.out.println("Создан объект A: " + a);
                        break;
                    case 2:
                        B b = new B();
                        System.out.println("Создан объект B: " + b);
                        break;
                    case 3:
                        System.out.println("Выход из программы.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Неверный ввод, попробуйте снова.");
                }
            } else {
                // Если ввод не является целым числом
                System.out.println("Пожалуйста, введите целое число.");
                scanner.next(); // Очистка некорректного ввода
            }
        }
    }
}
