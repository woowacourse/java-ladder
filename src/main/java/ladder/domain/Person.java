package ladder.domain;

import static ladder.constant.ErrorMessage.MAX_PERSON_NAME_LENGTH;
import static ladder.constant.ErrorMessage.PERSON_NAME_NOT_BLANK;

public class Person {
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Person(String name) {
        this.name = name.strip();
        validate(this.name);
    }

    public static int getMaxLength() {
        return MAX_LENGTH;
    }

    private void validate(String name) {
        validateLength(name);
        validateBlank(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(MAX_PERSON_NAME_LENGTH.generate());
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(PERSON_NAME_NOT_BLANK.generate());
        }
    }

    public String getName() {
        return name;
    }
}
