package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String INTEGER_REGEX = "^[0-9]$";
    private static final String MAKE_CUSTOM_DELIMTER = "//(.)\n(.*)";

    int add(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }
        text = text.trim();

        Matcher matcher = Pattern.compile(MAKE_CUSTOM_DELIMTER).matcher(text);
        String[] texts = getTexts(matcher, text);

        return sumResult(texts);
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
