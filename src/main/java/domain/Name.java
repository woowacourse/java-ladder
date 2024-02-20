package domain;

public class Name {

    private final String name;

    public Name (String inputName) {
        validateLength(inputName);
        this.name = inputName;
    }

    private void validateLength(String inputName) {
        if (inputName.length() < 1 || inputName.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 1글자 이상 5글자 이하여야 합니다.");
        }
    }
}
