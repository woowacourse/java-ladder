package domain.model;

public class Person {
    private static final int SIZE_LIMIT=5;
    private final String name;

    public Person(final String name) {
        validateNameLength(name);
        validateNonBlank(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void validateNameLength(String name) {
        if (name.length() > SIZE_LIMIT) {
            throw new IllegalStateException("이름은 5글자 이하입니다.");
        }
    }

    public void validateNonBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("공백 이름은 허용하지 않습니다.");
        }
    }
}
