package laddergame.domain.players;

import laddergame.util.ExceptionMessageFormatter;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("참여자의 이름은 null 또는 빈 문자열일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            String message = String.format("참여자의 이름은 최대 %d글자를 넘을 수 없습니다.", MAX_NAME_LENGTH);
            throw new IllegalArgumentException(ExceptionMessageFormatter.format(message, name.length()));
        }
    }

    public String getValue() {
        return value;
    }
}
