package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

record Player(String name) {
    private static final Pattern pattern = Pattern.compile(".*[^a-zA-Z0-9].*");

    Player {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            throw new IllegalArgumentException("참가자 이름은 알파벳 대소문자와 숫자만으로 이루어져야 합니다.");
        }
    }
}
