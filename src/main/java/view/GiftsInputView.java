package view;

import java.util.List;

public class GiftsInputView {
    private static final String SEPARATOR = ",";

    public static List<String> getGiftNames(String rawString) {
        StringSeparator separator = new StringSeparator(SEPARATOR);
        return separator.splitName(rawString);
    }

    public static List<String> getGiftNames(String rawString, int count) {
        StringSeparator separator = new StringSeparator(SEPARATOR);
        return separator.splitName(rawString);
    }
}
