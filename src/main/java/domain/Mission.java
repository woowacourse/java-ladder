package domain;

import java.util.Objects;

public class Mission {

    private static final int MAX_LENGTH_EXCLUSIVE = 5;
    private final String mission;

    public Mission(String mission) {
        this.mission = getMission(mission);
    }

    private static String getMission(String mission) {
        if (mission.isBlank()) {
            throw new IllegalArgumentException("공백 또는 null을 입력할 수 없습니다.");
        }
        if (mission.length() > MAX_LENGTH_EXCLUSIVE) {
            throw new IllegalArgumentException("미션 글자수는 5글자를 초과할 수 없습니다.");
        }
        return mission;
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
