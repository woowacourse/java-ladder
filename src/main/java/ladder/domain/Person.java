package ladder.domain;

import ladder.constant.Command;

public class Person {
    private static final int MAX_LENGTH = 5;
    private static final String MAX_PERSON_NAME_LENGTH = "사람 이름의 길이는 5자를 넘을 수 없습니다.";
    private static final String PERSON_NAME_NOT_BLANK = "사람 이름의 비어있거나 공백일 수 없습니다.";
    private static final String COMMAND_NOT_USE_AS_NAME = "지정된 명령어는 이름으로 사용할 수 없습니다.";

    private final String name;

    public Person(String name) {
        this.name = name.strip();
        validate(this.name);
    }

    private void validate(String name) {
        validateLength(name);
        validateBlank(name);
        validateCommand(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(MAX_PERSON_NAME_LENGTH);
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(PERSON_NAME_NOT_BLANK);
        }
    }

    private void validateCommand(String name) {
        if (Command.exist(name)) {
            throw new IllegalArgumentException(COMMAND_NOT_USE_AS_NAME);
        }
    }

    public String getName() {
        return name;
    }
}
