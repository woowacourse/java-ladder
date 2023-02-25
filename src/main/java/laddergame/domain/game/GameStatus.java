package laddergame.domain.game;

public enum GameStatus {

    CONTINUE,
    END;

    public boolean isContinuing() {
        return this == CONTINUE;
    }
}
