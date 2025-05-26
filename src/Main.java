import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Main {
    public static String calc(String input) {

        Pattern pattern = Pattern.compile("^\\s*(\\d+)\\s*([+\\-*/])\\s*(\\d+)\\s*$");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Неправильный формат математической операции");
        }

        int a = Integer.parseInt(matcher.group(1));
        String operator = matcher.group(2);
        int b = Integer.parseInt(matcher.group(3));

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }

        int result;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемая арифметическая операция");
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();

        try {
            String output = calc(input);
            System.out.println("Output: " + output);
        } catch (Exception e) {
            System.out.println("throws Exception //" + e.getMessage());
        }
    }
}