package laddergame.domain.participant;

public class ParticipantName {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public ParticipantName(final String name) {
        if (name.indexOf(' ') != -1) {
            throw new IllegalArgumentException("[ERROR] 이름에 공백이 포함될 수 없습니다.");
        }
        if (isOutOfRange(name)) {
            throw new IllegalArgumentException("[ERROR] 이름은 다섯 글자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    private boolean isOutOfRange(final String name) {
        return name.length() > MAX_LENGTH;
    }

    public String getName() {
        return name;
    }
}
