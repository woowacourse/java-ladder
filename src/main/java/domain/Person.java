package domain;

import exception.ErrorCode;

public class Person {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private final String name;
    private int position;

    public Person(String name, int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    private void validate(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(ErrorCode.NAME_OUT_OF_RANGE.getMessage(), MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    public void climb(Ladder ladder) {
        position = ladder.findFinalPosition(position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
