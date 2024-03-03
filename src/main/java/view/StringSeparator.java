package view;

import java.util.Arrays;
import java.util.List;

class StringSeparator {
    private final String separator;

    StringSeparator(String separator) {
        this.separator = separator;
    }

    List<String> splitName(String separatedString) {
        validateSeparator(separatedString);
        return Arrays.stream(separatedString.split(separator)).toList();
    }

    private void validateSeparator(String separatedString) {
        validateStarOrEndWithSeparator(separatedString);
        validateDuplicateSeparator(separatedString);
    }

    private void validateStarOrEndWithSeparator(String separatedString) {
        boolean startsWith = separatedString.startsWith(separator);
        boolean endsWith = separatedString.endsWith(separator);
        if (startsWith || endsWith) {
            throw new IllegalArgumentException("입력이 구분자로 시작하거나 끝나면 안됩니다.");
        }
    }

    private void validateDuplicateSeparator(String separatedString) {
        if (separatedString.contains(separator + separator)) {
            throw new IllegalArgumentException("입력에 구분자가 연속으로 등장하면 안됩니다.");
        }
    }
}
