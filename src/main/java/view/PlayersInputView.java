package view;

import java.util.List;

public class PlayersInputView {
    private static final String SEPARATOR = ",";

    public static List<String> getPlayerNames(String rawString) {
        StringSeparator separator = new StringSeparator(SEPARATOR);
        return separator.splitName(rawString);
    }
}
