package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static String[] splitString(String input) {
        if (StringUtils.isBlank(input)) {
            return new String[]{};
        }
        return splitStringWithSeparator(input);
    }

    private static String[] splitStringWithSeparator(String input) {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher m = pattern.matcher(input.replaceAll("\\\\n", "\n"));
        String regex = ",|:";

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter+"|"+regex);
        }

        return input.split(regex);
    }

    public static int sumString(String[] values) {
        return Arrays.stream(values).mapToInt(value -> Integer.parseInt(value)).sum();
    }

    public void checkCorrectValue(String[] values) {
         if(!Arrays.stream(values).allMatch(value -> value.matches("[0-9]" +
                 "+"))){
            throw new RuntimeException();
         }
    }
}
