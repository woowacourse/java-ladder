package domain;

import domain.player.Players;

public class ResultViewPlayer {

    private static final String ALL_COMMEND = "all";

    private final String name;

    public ResultViewPlayer(String name, Players players) {
        validateExistingPlayerOrCommend(name, players);

        this.name = name;
    }

    private static void validateExistingPlayerOrCommend(String name, Players players) {
        if (!players.isPlayerExistByName(name) && !name.equals(ALL_COMMEND)) {
            String message = String.format("%s이나 기존 사용자 이름을 입력해야 합니다.", ALL_COMMEND);
            throw new IllegalArgumentException(message);
        }
    }

    public boolean isAll() {
        return name.equals(ALL_COMMEND);
    }

    public String getName() {
        return this.name;
    }
}
