package domain;

import java.util.Arrays;
import java.util.List;

public class NameCreator {
    static final int MAX_NAMES_COUNT = 10;
    static final int MIN_NAMES_COUNT = 2;
    private static final String SEPARATOR = ",";

    public Names create(String names) {
        validateSeparator(names);
        List<String> splitNames = splitName(names);
        validateDuplicateName(splitNames);
        validateNameCount(splitNames);
        return new Names(splitNames.stream().map(Name::new).toList());
    }

    private void validateNameCount(List<String> splitNames) {
        if (splitNames.size() < MIN_NAMES_COUNT || splitNames.size() > MAX_NAMES_COUNT) {
            throw new LadderGameException(ExceptionType.INVALID_NAMES_RANGE);
        }
    }

    private void validateDuplicateName(List<String> splitNames) {
        long distinctCount = splitNames.stream().distinct().count();
        if (distinctCount != splitNames.size()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DUPLICATE_NAME);
        }
    }

    private void validateSeparator(String names) {
        boolean startsWith = names.startsWith(SEPARATOR);
        boolean endsWith = names.endsWith(SEPARATOR);
        if (startsWith || endsWith) {
            throw new LadderGameException(ExceptionType.INVALID_NAMES_SEPARATOR);
        }
    }

    private List<String> splitName(String names) {
        return Arrays.stream(names.split(SEPARATOR)).toList();
    }
}
