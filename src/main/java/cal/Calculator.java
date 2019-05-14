package cal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
//    public static int calculate(String expression){
//        List<String> separators =  new ArrayList<>(Arrays.asList(",",";"));
//        System.out.println(String.join("|",separators));
//        List<String> splitedExpression= Arrays.asList(expression.split(String.join("|",separators)));
//        return add(splitedExpression);
//    }

    private static int add(List<String> splitedExpression) {
        int result = 0;
        for (String s : splitedExpression) {
            result+= Integer.parseInt(s);
        }
        return result;
    }

    public static int calculate(String expression){
        expression = expression.substring(2);
        String [] splitedInput = expression.split("₩n");
        List <String> separators =new ArrayList<>(Arrays.asList(splitedInput[0].split("")));
        separators.add(":");
        separators.add(",");
        String a = String.join("", separators);
        List<String> splitedExpression=Arrays.asList(splitedInput[1].split("["+a+"]"));
        return add(splitedExpression);
    }
}
