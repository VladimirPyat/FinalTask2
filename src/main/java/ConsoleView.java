
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
*класс содержит методы для отображения меню и обработки команд меню
*/

public class ConsoleView {

    public void displayMenu(String menuHeader, ArrayList<String> menuText) {
    //метод вывода консольного меню. при необходимости можно переработать для графического отображения
        System.out.println(menuHeader);
                for (String element : menuText) {
            System.out.println(element);
        }
    }

    public int digitInput(int digit) {
    //обработчик команд меню. проверяем что вводимые символы соответствуют номерам пунктов
        Scanner scanner = new Scanner(System.in);
        int result;

        while (true) {
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                result = Integer.parseInt(input);
                if (result >= 0 && result < digit) {
                    break;
                }
            }
        }

        return result;
    }

    public String listInput(ArrayList<String> list) {
        //обработчик команд меню. проверяем что вводимые слова есть в списке
        Scanner scanner = new Scanner(System.in);
        String result;

        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (list.contains(input)) {
                result = input;
                return result;
            }
        }
    }

    public String dateInput() {
        Scanner scanner = new Scanner(System.in);
        String patternString = "^([0-9]|[12][0-9]|3[01])\\.(0[0-9]|1[0-2])\\.(19|20)\\d{2}$";

        Pattern pattern = Pattern.compile(patternString);

        String result;

        while (true) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                result = input;
                return result;
            } else {
                System.out.println("Некорректный формат. Пожалуйста, введите дату в формате dd.MM.yyyy");
            }
        }
    }


}


