package cal;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static int calculate(String expression){
        List<String> splitedExpression= Arrays.asList(expression.split(","));
        return add(splitedExpression);
    }

    private static int add(List<String> splitedExpression) {
        int result = 0;
        for (String s : splitedExpression) {
            result+= Integer.parseInt(s);
        }
        return result;
    }
}
