package textcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextCalculator {
    public List<String> tokenizer(String inputString) {

        String delimeter = getDelimter(inputString);

        return Arrays.asList(inputString.replace("//" + delimeter + "\n", "").split(delimeter));
    }

    public String getDelimter(String text) {
        char a = text.charAt(0);
        char b = text.charAt(3);
        char c = "\n".charAt(0);

        if (text.charAt(0) == '/' && text.charAt(1) == '/' && text.charAt(3) == 10) {
            return Character.toString(text.charAt(2));
        }

        return ",|:";
    }

    public List<Integer> toInt(List<String> tokens) {
        return tokens.stream().map((str) -> {
            if (Integer.parseInt(str) < 0) {
                throw new IllegalArgumentException();
            }
            return Integer.parseInt(str);
        }).collect(Collectors.toList());
    }

    public int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(number -> number).sum();
    }
}
