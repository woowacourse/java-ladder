package stringcalculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public enum DelimiterType {
    BLANK{
        @Override
        boolean matchDelimiterType(String formula) {
            return StringUtils.isBlank(formula);
        }

        @Override
        List<Integer> separateString(String formula) {
            List<Integer> separatedNumbers = new ArrayList<Integer>();
            separatedNumbers.add(0);
            return separatedNumbers;
        }
    },
    CUSTOM_DELIMITER{
        @Override
        boolean matchDelimiterType(String formula) {
            return formula.matches(CUSTOM_DELIMITER_PATTERN);
        }

        @Override
        List<Integer> separateString(String formula) {
            Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(formula);
            matcher.find();
            String customDelimiter = matcher.group(1);
            return Arrays.stream(matcher.group(2).split(customDelimiter))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
    },
    BASIC_DELIMITER{
        @Override
        boolean matchDelimiterType(String formula) {
            return !formula.matches(NOT_BASIC_DELIMITER_PATTERN);
        }

        @Override
        List<Integer> separateString(String formula) {
            return Arrays.stream(formula.split(BASIC_DELIMITER_REGEX))
                    .map(number -> Integer.parseInt(number.trim()))
                    .collect(Collectors.toList());
        }
    };
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String NOT_BASIC_DELIMITER_PATTERN = "[^0-9,:]";
    private static final String BASIC_DELIMITER_REGEX = ",|:";

    abstract boolean matchDelimiterType(String formula);
    abstract List<Integer> separateString(String formula);

    public static DelimiterType findDelimiterType(String formula){
        return Arrays.stream(DelimiterType.values()).filter(delimiterType -> delimiterType.matchDelimiterType(formula)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 문자열을 입력해주세요"));
    }
}
