import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Возможные операции:");
        System.out.println("1 - Добавить");
        System.out.println("2 - Показать");
        System.out.println("3 - Удалить");
        System.out.println("4 - Найти");
        System.out.println("end - Выйти");

        List<String> list = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер операции");
            String input = scanner.nextLine();
            try {
                int operation = Integer.parseInt(input);
                listOperation(operation, list);
            } catch (NumberFormatException e) {
                if ("end".equals(input)) {
                    break;
                }
            }

        }

    }

    public static void listProduct(List<String> list) {
        System.out.println("Список покупок");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i));
        }
    }

    public static void listOperation(int operation, List<String> list) {
        Scanner scanner = new Scanner(System.in);
        String input;
        switch (operation) {
            case 1:
                System.out.println("Какую покупку хотите добавить?");
                list.add(scanner.nextLine());
                break;
            case 2:
                listProduct(list);
                break;
            case 3:
                listProduct(list);
                System.out.println("Какую хотите удалить? Введите номер или название");
                input = scanner.nextLine();
                try {
                    operation = Integer.parseInt(input);
                    System.out.println("Покупка " + list.get(operation - 1) + " удалена");
                    list.remove(operation - 1);
                    listProduct(list);
                } catch (NumberFormatException e) {
                    System.out.println("Покупка " + input + " удалена");
                    list.remove(input);
                    listProduct(list);
                }
                break;
            case 4:
                System.out.println("Введите текст для поиска");
                input = scanner.nextLine();
                String inputLow = input.toLowerCase();
                System.out.println("Найдено:");
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).toLowerCase().contains(inputLow)) {
                        System.out.println((i + 1) + " . " + list.get(i));
                    }
                }
                break;
        }
    }
}