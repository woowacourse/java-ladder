package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private static final int MIN_PLAYER_COUNT = 2;

    private final List<PlayerName> playerNames;
    private final Height height;
    private final LineCreateDecider lineCreateDecider;
    private final Ladder ladder;

    public LadderGame(List<PlayerName> playerNames, Height height, LineCreateDecider lineCreateDecider) {
        validatePlayerCount(playerNames);
        this.playerNames = playerNames;
        this.height = height;
        this.lineCreateDecider = lineCreateDecider;
        this.ladder = generateLadder();
    }

    private void validatePlayerCount(List<PlayerName> playerNames) {
        if (playerNames.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_INVALID_PLAYER_COUNT.getMessage());
        }
    }

    public Ladder generateLadder() {
        int personCount = playerNames.size();
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            rows.add(new Row(personCount, lineCreateDecider));
        }
        return new Ladder(rows);
    }

    public List<PlayerName> getPlayerNames() {
        return playerNames;
    }

    public Ladder getLadder() {
        return ladder;
    }

    private enum ErrorMessage {
        EXCEPTION_INVALID_PLAYER_COUNT("게임을 진행하기 위해서는 두 명 이상의 플레이어가 필요합니다.");
        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }
}
