package domain;

public class Prize {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private final String prizeName;

    public Prize(String prizeName) {
        validate(prizeName);
        this.prizeName = prizeName;
    }

    private void validate(String inputName) {
        validateAvailableLength(inputName);
        validateBlank(inputName);
        validateContainBlankInName(inputName);
    }

    private void validateAvailableLength(String inputName) {
        if (inputName.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("하나당 최대 5자까지만 입력 가능합니다.");
        }
    }

    private void validateBlank(String initialInput) {
        if (initialInput.isBlank()) {
            throw new IllegalArgumentException("공백으로만 이루어진 입력은 사용할 수 없습니다.");
        }
    }

    private void validateContainBlankInName(String inputName) {
        if (inputName.contains(" ")) {
            throw new IllegalArgumentException("중간에 공백이 포함된 입력은 사용할 수 없습니다.");
        }
    }

    public String toString() {
        return this.prizeName;
    }

}
