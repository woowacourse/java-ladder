package laddergame.domain;

import java.util.List;

public class Target {
    private String name;

    public Target(String name) {
        checkNullOrBlank(name);
        this.name = name;
    }

    private void checkNullOrBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    public void checkNotPlayerNameOrNotAll(List<String> playerNames) {
        if (!playerNames.contains(name) && !name.equals("all")) {
            throw new IllegalArgumentException("player 이름이나 all 을 입력해주세요.");
        }
    }
}
