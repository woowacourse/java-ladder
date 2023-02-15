package ladder.domain;

public class Person {
    private static final int NAME_LENGTH_LOWER_BOUND_INCLUSIVE = 1;
    private static final int NAME_LENGTH_UPPER_BOUND_INCLUSIVE = 5;
    private static final String NOT_ALLOWED = " ";
    private final String name;

    public Person(String name) {
        validateLength(name);
        validateBlank(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < NAME_LENGTH_LOWER_BOUND_INCLUSIVE || name.length() > NAME_LENGTH_UPPER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException("");
        }
    }

    private void validateBlank(String name) {
        if (name.contains(NOT_ALLOWED)) {
            throw new IllegalArgumentException();
        }
    }
}
