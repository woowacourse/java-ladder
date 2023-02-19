package ladder.domain;

import ladder.util.ExceptionMessageFormatter;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format("참여자의 이름은 최대 " + MAX_NAME_LENGTH + "글자를 넘을 수 없습니다.",
                            name.length()));
        }
    }

    public String getValue() {
        return value;
    }
}
