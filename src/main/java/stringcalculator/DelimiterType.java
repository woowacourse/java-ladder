package stringcalculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum DelimiterType {
    BLANK {
        @Override
        boolean matchDelimiterType(String formula) {
            return StringUtils.isBlank(formula);
        }
    },
    CUSTOM_DELIMITER {
        @Override
        boolean matchDelimiterType(String formula) {
            return Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(formula).find();
        }
    },
    BASIC_DELIMITER {
        @Override
        boolean matchDelimiterType(String formula) {
            return !Pattern.compile(NOT_BASIC_DELIMITER_PATTERN).matcher(formula).find();
        }
    };
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String NOT_BASIC_DELIMITER_PATTERN = "[^0-9,:]";
    abstract boolean matchDelimiterType(String formula);

    public static DelimiterType findDelimiterType(String formula) {
        return Arrays.stream(DelimiterType.values())
                .filter(delimiterType -> delimiterType.matchDelimiterType(formula))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 문자열을 입력해주세요"));
    }
}
