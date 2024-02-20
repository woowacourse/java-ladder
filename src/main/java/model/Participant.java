package model;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Participant(String name) {
        validator(name);
        this.name = name;
    }

    private void validator(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 다섯글자까지 입력 가능하다.");
        }
    }
}
