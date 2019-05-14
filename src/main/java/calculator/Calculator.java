package calculator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static String[] splitString(String input) {
        Matcher m = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        String regex = ",|:";

        if (m.find()) {
            System.out.println("adf");
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter+"|"+regex);
        }

        return input.split(regex);
    }

    public static int sumString(String[] values) {
        return Arrays.stream(values).mapToInt(value -> Integer.parseInt(value)).sum();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(sumString(splitString(scanner.next())));
    }
}
