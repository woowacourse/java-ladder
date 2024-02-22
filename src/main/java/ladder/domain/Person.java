package ladder.domain;

public record Person(String name) {

    private static final int MAX_NAME_LENGTH = 5;

    public Person {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 %d글자 이하로 입력해주세요.".formatted(MAX_NAME_LENGTH));
        }
    }
}
