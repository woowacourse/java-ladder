package ladder.domain;

public class Person {
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Person(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 사람 이름의 길이는 5자를 넘을 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
