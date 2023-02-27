package laddergame.domain;

import java.util.List;

public class Target {
    private static final String ALL = "all";
    private static final String QUIT = "Q";
    private static final String WRONG_TARGET_NAME_ERROR_MESSAGE = "player 이름, all, Q 만 입력 가능합니다.";

    private String name;

    public Target(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isAll() {
        return name.equals("all");
    }

    public boolean isQuit() {
        return name.equals("Q");
    }

    public void checkNotPlayerNameOrNotKeyword(List<String> playerNames) {
        if (!playerNames.contains(name) && !name.equals(ALL) && !name.equals(QUIT)) {
            throw new IllegalArgumentException(WRONG_TARGET_NAME_ERROR_MESSAGE);
        }
    }
}
