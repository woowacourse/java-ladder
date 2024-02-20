package model;

public class Person {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Person(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        int length = name.length();
        if (length < MIN_NAME_LENGTH || length > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최소 1글자 최대 5글자여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
