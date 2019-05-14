package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String INTEGER_REGEX = "^[0-9]$";

    int add(String text) {
        if (isTextEmpty(text)) {
            return 0;
        }
        text = text.trim();

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] texts = getTexts(matcher, text);

        return sumResult(texts);
    }

    private boolean isTextEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    private String[] getTexts(Matcher matcher, String text) {
        String delimiter = DEFAULT_DELIMITER;
        if (matcher.find()) {
            delimiter = checkDelimiterType(matcher.group(1));
            text = matcher.group(2);
        }

        return text.split(delimiter);
    }

    private String checkDelimiterType(String delimiter) {
        if(Pattern.matches(INTEGER_REGEX, delimiter)){
            throw new IllegalArgumentException("구분자는 숫자가 될수 없습니다.");
        }

        return delimiter;
    }

    private int sumResult(String[] texts) {
        try{
            return Arrays.stream(texts).mapToInt(Integer::parseInt).filter(i -> {
                if (i < 0) {
                    throw new RuntimeException("음수는 입력값이 될 수 없습니다.");
                }
                return true;
            }).sum();
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
    }
}
