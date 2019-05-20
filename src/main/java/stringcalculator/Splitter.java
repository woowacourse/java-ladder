package stringcalculator;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Splitter {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String BASIC_DELIMITER_REGEX = ",|:";

    public static List<Integer> split(DelimiterType delimiterType, String formula) {

        if (isBlank(delimiterType)) {
            return Arrays.asList(0);
        }
        if (isCustomDelimiter(delimiterType)) {
            Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(formula);
            matcher.find();
            return Arrays.stream(matcher.group(2).split(matcher.group(1))).map(Integer::parseInt).collect(Collectors.toList());
        }
        return Arrays.stream(formula.split(BASIC_DELIMITER_REGEX)).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static boolean isBlank(DelimiterType delimiterType) {
        return delimiterType.equals(DelimiterType.BLANK);
    }

    private static boolean isCustomDelimiter(DelimiterType delimiterType) {
        return delimiterType.equals(DelimiterType.CUSTOM_DELIMITER);
    }
}
