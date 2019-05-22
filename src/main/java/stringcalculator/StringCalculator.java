package stringcalculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final String DELIMITER_REGEX = "[,:]";
    private List<Integer> numbers = new ArrayList<>();

    public StringCalculator(String formula) {
        if (StringUtils.isBlank(formula)) {
            numbers.add(0);
        }
        if (isCustomDelimiter(formula)) {
            numbers = getNumbersByCustomDelimiter(formula);
        }
        if (numbers.isEmpty()) {
            numbers = Arrays.stream(formula.split(DELIMITER_REGEX))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        if (numbers.isEmpty() || numbers.stream().anyMatch(number -> number < 0)) {
            throw new RuntimeException("잘못된 문자열입니다.");
        }
    }

    private List<Integer> getNumbersByCustomDelimiter(String formula) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(formula);
        m.find();
        String customDelimiter = m.group(1);
        return Arrays.stream(m.group(2).split(customDelimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int calculate() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private boolean isCustomDelimiter(String formula) {
        return (formula != null) && (Pattern.compile("//(.)\n(.*)").matcher(formula).find());
    }
}