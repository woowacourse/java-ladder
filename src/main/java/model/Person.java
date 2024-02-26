package model;

public class Person {

    private final String name;

    public Person(final String name) {
        this.name = name;
        validateNameLength();
        validateNonBlank();
    }

    public String getName() {
        return this.name;
    }

    public void validateNameLength() {
        if (this.name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하입니다.");
        }
    }

    public void validateNonBlank() {
        if (this.name.isBlank()) {
            throw new IllegalArgumentException("공백 이름은 허용하지 않습니다.");
        }
    }
}
