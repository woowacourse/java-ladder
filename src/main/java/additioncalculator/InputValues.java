package additioncalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValues {

    public static List<Integer> extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] array = extractExpression(input).split(makeRegex(input));

        for (String a : array) {
            numbers.add(Integer.parseInt(a));
        }

        return numbers;
    }

    public static boolean validateInput(String input) {
        String expression = extractExpression(input);
        String regex = makeRegex(input);

        return isNumeric(expression, regex);
    }

    private static boolean isNumeric(String expression, String regex) {
        String[] numbers = expression.split(regex);
        boolean numeric = true;

        for (int i = 0; i < numbers.length && numeric; i++) {
            numeric = checkNumeric(numbers[i]);
        }

        return numeric;
    }

    private static boolean checkNumeric(String number) {
        return number.matches("-?\\d+(\\.\\d+)?");
    }

    private static String extractExpression(String input) {
        String[] arr = input.split("\n");
        int index = arr.length - 1;
        return arr[index];
    }

    protected static String makeRegex(String text) {
        StringBuilder regex = new StringBuilder("[,]|[:]");
        Matcher matcher = Pattern.compile("//(.+)\n").matcher(text);

        while (matcher.find()) {
            regex.append("|(").append(matcher.group(1)).append(")");
        }
        return regex.toString();
    }

}
