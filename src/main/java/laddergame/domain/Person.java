package laddergame.domain;

public class Person {
    private static final int NAME_LENGTH_BOUND = 5;

    private String name;

    public Person(String name) {
        if (overNameLengthBound(name)) {
            throw new IllegalArgumentException("이름은 5자 이내여야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean overNameLengthBound(String name) {
        return name.length() > NAME_LENGTH_BOUND;
    }
}
