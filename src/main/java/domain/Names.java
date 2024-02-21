package domain;

import java.util.Arrays;
import java.util.List;

public class Names {
    private final List<Name> names;

    Names(String names) {
        validateSeparator(names);
        List<String> splitNames = splitName(names);
        validateDuplicateName(splitNames);
        validateNameCount(splitNames);
        this.names = splitNames.stream().map(Name::new).toList();
    }

    private static List<String> splitName(String names) {
        return Arrays.stream(names.split(",")).toList();
    }

    private static void validateNameCount(List<String> splitNames) {
        if (splitNames.size() > 10) {
            throw new LadderGameException(ExceptionType.NAMES_COUNT);
        }
    }

    private void validateDuplicateName(List<String> splitNames) {
        long distinctCount = splitNames.stream().distinct().count();
        if (distinctCount != splitNames.size()) {
            throw new LadderGameException(ExceptionType.NAMES_DUPLICATE);
        }
    }

    private void validateSeparator(String names) {
        boolean startsWith = names.startsWith(",");
        boolean endsWith = names.endsWith(",");
        if (startsWith || endsWith) {
            throw new LadderGameException(ExceptionType.NAMES_SEPARATOR);
        }
    }

    List<Name> getNames() {
        return names;
    }

    int getNameCount() {
        return names.size();
    }
}
