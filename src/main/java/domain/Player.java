package domain;

public class Player {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
        validateCharacter(name);
    }

    private void validateCharacter(String name) {
        if (isAlphabet(name)) {
            throw new IllegalArgumentException(String.format("이름은 영어만 가능합니다. 입력한 이름:%s", name));
        }
    }

    private boolean isAlphabet(String name) {
        return name.chars().noneMatch(character -> isUpperCase(character) || isLowerCase(character));
    }

    private boolean isUpperCase(int character) {
        return 'A' <= character && character <= 'Z';
    }

    private boolean isLowerCase(int character) {
        return 'a' <= character && character <= 'z';
    }

    private void validateLength(String name) {
        if (name == null || name.isBlank() || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("1글자 이상 5글자 이하의 이름만 입력하세요. 입력한 이름: %s", name));
        }
    }

    public String getName() {
        return name;
    }
}
