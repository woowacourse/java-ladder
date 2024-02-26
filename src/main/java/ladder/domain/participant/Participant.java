package ladder.domain.participant;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_REGEX = "^[a-zA-Z]*$";

    private final String name;

    public Participant(String name) {
        name = name.trim();
        validateNameLength(name);
        validateIsAlphabetic(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1에서 5자 사이로 입력해 주세요.");
        }
    }

    private static void validateIsAlphabetic(final String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("이름은 영어로 입력해 주세요.");
        }
    }

    public String getName() {
        return name;
    }
}
