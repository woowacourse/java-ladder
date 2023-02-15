package model;

public class Name {

    public static final int MAXIMUM_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자까지만 가능합니다.");
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
