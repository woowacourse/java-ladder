package domain;

import exception.ErrorMessage;

public class User {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final Position position;

    //TODO : 추후 리팩토링시 생성자 삭제
    public User(final String name) {
        validateLength(name);
        validateBlank(name);
        this.name = name;
        this.position = Position.from(0);
    }

    public User(final String name, final int position) {
        validateLength(name);
        validateBlank(name);
        this.name = name;
        this.position = Position.from(position);
    }

    public String getName() {
        return name;
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.USER_NAME_LENGTH_EXCEPTION.getMessage());
        }
    }

    private void validateBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.USER_NAME_BLANK_EXCEPTION.getMessage());
        }
    }
}
