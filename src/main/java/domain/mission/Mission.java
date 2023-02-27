package domain.mission;

import java.util.Objects;

public class Mission {

    private static final int MAX_LENGTH_EXCLUSIVE = 5;

    private final String mission;

    public Mission(String mission) {
        validateMission(mission);
        this.mission = mission;
    }

    private void validateMission(String mission) {
        // TODO: `NullPointerException`을 `String.isBlank()`로 잡을 수가 없다..!
        if (mission == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
        if (mission.isBlank()) {
            throw new IllegalArgumentException("공백으로 미션을 생성할 수 없습니다.");
        }
        if (mission.length() > MAX_LENGTH_EXCLUSIVE) {
            throw new IllegalArgumentException("미션 글자수는 5글자를 초과할 수 없습니다.");
        }
    }

    public String getMission() {
        return mission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mission mission1 = (Mission) o;
        return Objects.equals(mission, mission1.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mission);
    }
}
