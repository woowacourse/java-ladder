package ladder.model;

import java.util.List;

public class LadderGame {

    private static final int MIN_PLAYER_COUNT = 2;
    private Ladder ladder;

    public LadderGame(List<String> playerNames) {
        validatePlayerCount(playerNames);
    }

    private void validatePlayerCount(List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_INVALID_PLAYER_COUNT.getMessage());
        }
    }

    private enum ErrorMessage {
        EXCEPTION_INVALID_PLAYER_COUNT("게임을 진행하기 위해서는 두 명 이상의 플레이어가 필요합니다.");
        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
