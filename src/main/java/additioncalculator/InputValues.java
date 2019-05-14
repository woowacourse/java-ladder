package additioncalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValues {

    public String findPattern(String input) {
        String[] array = input.split("\n");
        String source = null;

        if (array.length > 1) {
            source = array[0];
            if (!source.startsWith("//")) {
                throw new IllegalArgumentException("커스텀 구분자의 ");
            }
        }

        return source.substring(2, source.length());
    }

    public boolean validateInput(String input) {
        String[] arr = input.split("\n");
        int index = arr.length - 1;
        String expression = arr[index];
        String regex = makeRegex(input);
        List<String> test = new ArrayList<>(Arrays.asList(expression.split(regex)));
        for (String s : test) {
            Integer.parseInt(s);
        }
        return true;
    }

    protected String makeRegex(String text) {
        StringBuilder regex = new StringBuilder("[,]|[:]");
        Matcher matcher = Pattern.compile("//(.+)\n").matcher(text);

        while (matcher.find()) {
            regex.append("|(").append(matcher.group(1)).append(")");
        }

        return regex.toString();
    }
}
