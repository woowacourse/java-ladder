package domain;

import java.util.Arrays;
import java.util.List;

public class NamesCreator {
    private static final String SEPARATOR = ",";

    public Names create(String names) {
        validateSeparator(names);
        List<String> splitNames = splitName(names);
        return new Names(splitNames.stream().map(Name::new).toList());
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
