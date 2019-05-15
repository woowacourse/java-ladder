package ladder.domain;

public class PlayerName {
    private String name;

    public PlayerName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("빈 이름 오류");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 길이 5초과 오류");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
