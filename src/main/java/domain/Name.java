package domain;

public class Name {

    public static final int MAX_OF_NAME_LENGTH = 5;
    String name;

    public Name(String name) {
        validateNoName(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNoName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름이 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_OF_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "[ERROR] 이름의 길이는 " + MAX_OF_NAME_LENGTH + "글자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
