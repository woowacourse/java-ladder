package cal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String FORBIDDEN_DELIMITERS = "-";

    private static int add(String[] splitedExpression) {
        int result = 0;
        for (String s : splitedExpression) {
            result += Integer.parseInt(s);
        }
        return result;
    }

    public static int calculate(String expression) {
        expression = checkNull(expression);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(1);
            expression = m.group(2);
        }
        String[] tokens = expression.split("[" + customDelimiter + DEFAULT_DELIMITERS + "]");
        return add(tokens);
    }

    public static String checkNull(String input){
        if(input == null) return "0";
        return input;
    }
}
