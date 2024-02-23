package view;

import domain.ExceptionType;
import domain.LadderGameException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class NameInputView {
    static final int MAX_NAMES_COUNT = 10;
    private static final String SEPARATOR = ",";


    public static List<String> getNames(Supplier<String> supplier) {
        String names = supplier.get();
        validateSeparator(names);
        List<String> splitNames = splitName(names);
        validateNameCount(splitNames);
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
}
