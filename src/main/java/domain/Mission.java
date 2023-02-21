package domain;

public class Mission {

    private final String mission;

    public Mission(String mission) {
        this.mission = getMission(mission);
    }

    private static String getMission(String mission) {
        if (mission.isBlank()) {
            throw new IllegalArgumentException("공백 또는 null을 입력할 수 없습니다.");
        }
        if (mission.length() > 5) {
            throw new IllegalArgumentException("미션 글자수는 5글자를 초과할 수 없습니다.");
        }
        return mission;
    }

    public String getMission() {
        return mission;
    }
}
