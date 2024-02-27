package domain;

import java.util.regex.Pattern;

public record Name(String name) {

    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z0-9]+");
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;

    public Name {
        validationNameLength(name);
        isAlphaNumber(name);
    }

    private void validationNameLength(String name) {
        if (name.length() < NAME_LENGTH_MIN || name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(
                    "이름의 길이는 %d ~ %d 자 이어야 합니다.".formatted(NAME_LENGTH_MIN, NAME_LENGTH_MAX));
        }
    }

    private void isAlphaNumber(String name) {
        if (!NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException("이름이 영어와 숫자가 아니라면 예외가 발생한다");
        }
    }
}
