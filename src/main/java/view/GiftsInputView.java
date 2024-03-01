package view;

import java.util.Arrays;
import java.util.List;

public class GiftsInputView {
    private static final String SEPARATOR = ",";

    public static List<String> getGiftNames(String rawString) {
        validateSeparator(rawString);
        return splitName(rawString);
    }

    private static void validateSeparator(String giftNames) {
        validateStarOrEndWithSeparator(giftNames);
        validateDuplicateSeparator(giftNames);
    }

    private static void validateStarOrEndWithSeparator(String giftNames) {
        boolean startsWith = giftNames.startsWith(SEPARATOR);
        boolean endsWith = giftNames.endsWith(SEPARATOR);
        if (startsWith || endsWith) {
            throw new IllegalArgumentException("입력이 구분자로 시작하거나 끝나면 안됩니다.");
        }
    }

    private static void validateDuplicateSeparator(String names) {
        if (names.contains(SEPARATOR + SEPARATOR)) {
            throw new IllegalArgumentException("입력에 구분자가 연속으로 등장하면 안됩니다.");
        }
    }

    private static List<String> splitName(String giftNames) {
        return Arrays.stream(giftNames.split(SEPARATOR)).toList();
    }
}
