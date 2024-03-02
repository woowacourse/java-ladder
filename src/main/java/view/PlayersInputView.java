package view;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayersInputView {
    private static final String SEPARATOR = ",";
    private static final Pattern pattern = Pattern.compile(".*[^a-zA-Z0-9].*");


    public static List<String> getPlayerNames(String rawString) {
        StringSeparator separator = new StringSeparator(SEPARATOR);
        List<String> splitName = separator.splitName(rawString);
        for (String name : splitName) {
            validateNameLength(name);
            validateNameCharacter(name);
            validateNameBlackList(name);
        }
        return splitName;
    }

    private static void validateNameLength(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }

    private static void validateNameCharacter(String name) {
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            throw new IllegalArgumentException("참가자 이름은 알파벳 대소문자와 숫자만으로 이루어져야 합니다.");
        }
    }

    private static void validateNameBlackList(String name) {
        if (name.equals("all")) {
            throw new IllegalArgumentException("참가자 이름은 all이 될 수 없습니다.");
        }
    }
}
