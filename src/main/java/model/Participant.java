package model;

public class Participant {
    private final String name;

    public Participant(String name) {
        validator(name);
        this.name = name;
    }

    private void validator(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 다섯글자까지 입력 가능하다.");
        }
    }
}
