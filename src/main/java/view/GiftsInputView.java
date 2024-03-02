package view;

import java.util.List;

public class GiftsInputView {
    private static final String SEPARATOR = ",";

    public static List<String> getGiftNames(String rawString, int count) {
        StringSeparator separator = new StringSeparator(SEPARATOR);
        List<String> splitNames = separator.splitName(rawString);
        validateSplitNamesCount(count, splitNames);
        for (String splitName : splitNames) {
            validateNameLength(splitName);
        }
        return splitNames;
    }

    private static void validateSplitNamesCount(int count, List<String> splitNames) {
        if (splitNames.size() != count) {
            throw new IllegalArgumentException("상품 이름이 너무 많거나 너무 적습니다.");
        }
    }

    private static void validateNameLength(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("상품 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }
}
