package laddergame.domain.participant;

public class ParticipantName {

    private static final char INVALID_INCLUSION = ' ';
    private static final int MAX_LENGTH = 5;
    private final String name;

    private ParticipantName(final String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    public static ParticipantName create(final String name) {
        return new ParticipantName(name);
    }

    private void validateNameBlank(final String name) {
        if (name.indexOf(INVALID_INCLUSION) != -1) {
            throw new IllegalArgumentException("[ERROR] 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름은 다섯 글자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
