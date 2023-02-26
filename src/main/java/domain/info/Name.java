package domain.info;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(final String name) {
        validateBlank(name);
        validateLength(name);
    }

    private static void validateBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    "[ERROR] 빈 이름(공백)은 입력이 불가능합니다."
            );
        }
    }

    private static void validateLength(final String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d글자 이상 %d글자 이하의 이름만 입력해주세요.", MIN_LENGTH, MAX_LENGTH)
            );
        }
    }

    public String getName() {
        return name;
    }

}
