package model.participant;

import dto.ParticipantName;
import java.util.Objects;
import utils.Constant;

public class Participant {
    private final String name;

    public Participant(String name) {
        validator(name);
        this.name = name;
    }

    private void validator(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null일 수 없다.");
        }
        if (name.isEmpty() || name.isBlank() || name.length() > Constant.STEP_LENGTH) {
            throw new IllegalArgumentException("이름은 1 ~ " + Constant.STEP_LENGTH + " 길이의 문자이어야합니다.");
        }
        if (name.equals(Constant.TOTAL_RESULT_KEYWORD)) {
            throw new IllegalArgumentException("\"" + Constant.TOTAL_RESULT_KEYWORD + "\"이라는 이름은 입력할 수 없다.");
        }
    }

    public String getName() {
        return name;
    }

    public ParticipantName convertToParticipantName() {
        return new ParticipantName(name);
    }

    public boolean hasEquivalentName(String name) {
        return name.equals(this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
