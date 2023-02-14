package laddergame.domain.participant;

public class ParticipantName {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public ParticipantName(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름은 공백일 수 없습니다.");
        }
        if (isOutOfRange(name)) {
            throw new IllegalArgumentException("[ERROR] 이름은 다섯 글자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    private boolean isOutOfRange(final String name) {
        return name.length() > MAX_LENGTH;
    }
}
