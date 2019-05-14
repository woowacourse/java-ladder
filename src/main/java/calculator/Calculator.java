package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public String[] splitString(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        String regex = ",|:";

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter+"|"+regex);
        }

        return input.split(regex);
    }
}
