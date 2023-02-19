package domain;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(String.format("이름은 공백이거나 비어있을 수 없습니다. 입력값 : %s", name));
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 1글자 이상, 5글자 이하여야합니다. 입력값 : %s", name));
        }
    }

    public String getName() {
        return name;
    }
}
