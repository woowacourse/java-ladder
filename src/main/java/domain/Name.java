package domain;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(""); // TODO 예외 메시지 넣어주기
        }
        if (name.length() > MAX_NAME_LENGTH) { // TODO 상수 처리
            throw new IllegalArgumentException();   // TODO 예외 메시지 넣어주기
        }
    }
}
