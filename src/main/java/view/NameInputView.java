package view;

import domain.ExceptionType;
import domain.LadderGameException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameInputView {
    static final int MAX_NAMES_COUNT = 10;
    static final int MAX_NAME_LENGTH = 5;

    private static final String SEPARATOR = ",";

    private static final Pattern NAME_CHARACTER_REGEX = Pattern.compile("^[^a-zA-Z]+$");


    public static List<String> getNames(Supplier<String> supplier) {
        String names = supplier.get();
        validateSeparator(names);
        List<String> splitNames = splitName(names);
        validateNameCount(splitNames);
        splitNames.forEach(NameInputView::validateNameCharacters);
        splitNames.forEach(NameInputView::validateNameLength);
        return splitNames;
    }

    private static void validateSeparator(String names) {
        boolean startsWith = names.startsWith(SEPARATOR);
        boolean endsWith = names.endsWith(SEPARATOR);
        if (startsWith || endsWith) {
            throw new LadderGameException(ExceptionType.NAMES_SEPARATOR);
        }
    }

    private static List<String> splitName(String names) {
        return Arrays.stream(names.split(SEPARATOR)).toList();
    }

    private static void validateNameCount(List<String> splitNames) {
        if (splitNames.size() > MAX_NAMES_COUNT) {
            throw new LadderGameException(ExceptionType.NAMES_COUNT);
        }
    }

    private static void validateNameCharacters(String name) {
        Matcher matcher = NAME_CHARACTER_REGEX.matcher(name);
        if (matcher.matches()) {
            throw new LadderGameException(ExceptionType.NAME_CHARACTER);
        }
    }

    private static void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new LadderGameException(ExceptionType.NAME_LENGTH_RANGE);
        }
    }
}
