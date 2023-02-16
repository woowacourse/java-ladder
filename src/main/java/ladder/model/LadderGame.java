package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private static final int MIN_PLAYER_COUNT = 2;

    private final List<PlayerName> playerNames;
    private final LineCreateDecider lineCreateDecider;
    private Ladder ladder;

    public LadderGame(List<PlayerName> playerNames, LineCreateDecider lineCreateDecider) {
        validatePlayerCount(playerNames);
        this.playerNames = playerNames;
        this.lineCreateDecider = lineCreateDecider;
    }

    public void generateLadder(int height) {
        int personCount = playerNames.size();
        List<Raw> raws = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Raw raw = new Raw(personCount);
            raw.createLineAt(0, lineCreateDecider.decide());
            for (int k = 1; k < personCount - 1; k++) {
                if (!raw.isLeftPointHasLine(k)) {
                    raw.createLineAt(k, lineCreateDecider.decide());
                }
            }
            raws.add(raw);
        }
        this.ladder = new Ladder(raws);
    }

    private void validatePlayerCount(List<PlayerName> playerNames) {
        if (playerNames.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_INVALID_PLAYER_COUNT.getMessage());
        }
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

        public String getMessage() {
            return message;
        }
    }
}
