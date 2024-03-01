package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

record Player(String name) {
    private static final Pattern pattern = Pattern.compile(".*[^a-zA-Z0-9].*");

    Player {
        validateNameLength(name);
        validateNameCharacter(name);
        validateNameBlackList(name);
    }

    private void validateNameLength(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }

    private void validateNameCharacter(String name) {
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            throw new IllegalArgumentException("참가자 이름은 알파벳 대소문자와 숫자만으로 이루어져야 합니다.");
        }
    }

    private void validateNameBlackList(String name) {
        if (name.equals("all")) {
            throw new IllegalArgumentException("참가자 이름은 all이 될 수 없습니다.");
        }
    }

}
