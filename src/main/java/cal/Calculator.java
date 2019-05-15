package cal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    static final String defaultSeparators = ",;";

    static List<String> customSeparators = Arrays.asList(defaultSeparators);

    private static int add(String[] splitedExpression) {
        int result = 0;
        for (String s : splitedExpression) {
            result += Integer.parseInt(s);
        }
        return result;
    }

    public static int calculate(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(1);
            expression = m.group(2);
        }
        String[] tokens = expression.split("[" + customDelimiter + ",:" + "]");
        return add(tokens);
    }
}
