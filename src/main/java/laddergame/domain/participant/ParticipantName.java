package laddergame.domain.participant;

import java.util.Objects;

import static laddergame.domain.game.UserRequestedParticipants.ALL_PARTICIPANTS_COMMAND;

public class ParticipantName {

    public static final int MAX_LENGTH = 5;
    private static final String INVALID_INCLUSION = " ";

    private final String name;

    private ParticipantName(final String name) {
        validateNameNullOrEmpty(name);
        validateNameBlank(name);
        validateNameLength(name);
        validateNameByCommand(name);
        this.name = name;
    }

    public static ParticipantName create(final String name) {
        return new ParticipantName(name);
    }

    public boolean isSameName(final String otherName) {
        return name.equals(otherName);
    }

    private void validateNameNullOrEmpty(final String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름을 입력하셔아 합니다.");
        }
    }

    private void validateNameBlank(final String name) {
        if (name.contains(INVALID_INCLUSION)) {
            throw new IllegalArgumentException(String.format("[ERROR] 이름에 공백이 포함될 수 없습니다. 입력된 이름 : %s", name));
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("[ERROR] 이름은 %d 글자를 초과할 수 없습니다. 입력된 이름 : %s", MAX_LENGTH, name));
        }
    }

    private void validateNameByCommand(final String name) {
        if (name.equals(ALL_PARTICIPANTS_COMMAND)) {
            throw new IllegalArgumentException(String.format("[ERROR] 이름은 \"%s\"일 수 없습니다.", ALL_PARTICIPANTS_COMMAND));
        }
    }

    @Override
    public boolean equals(final Object diffParticipantName) {
        if (this == diffParticipantName) {
            return true;
        }
        if (diffParticipantName == null || getClass() != diffParticipantName.getClass()) {
            return false;
        }
        ParticipantName that = (ParticipantName) diffParticipantName;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ParticipantName{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
