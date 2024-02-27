package model;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        validator(name);
        this.name = name;
    }

    private void validator(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null일 수 없다.");
        }
        if (name.isEmpty() || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 한글자 이상 다섯글자 이하로 입력해야합니다.");
        }
        if (name.equals("all")) {
            throw new IllegalArgumentException("\"all\"이라는 이름은 입력할 수 없다.");
        }
    }

    public String getName() {
        return name;
    }
}
