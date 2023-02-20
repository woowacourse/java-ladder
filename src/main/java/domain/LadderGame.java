package domain;

import domain.ladder.Ladder;

public class LadderGame {

    private static final String PLAYER_RESULT_SIZE_MISMATCH_ERROR_MESSAGE = "게임 참여자와 결과의 개수는 동일하여야 합니다.";

    private final Ladder ladder;
    private final PlayerNames playerNames;
    private final ResultContents resultContents;

    public LadderGame(Ladder ladder, PlayerNames playerNames, ResultContents resultContents) {
        validatePlayerResultsSize(playerNames, resultContents);
        this.ladder = ladder;
        this.playerNames = playerNames;
        this.resultContents = resultContents;
    }

    private void validatePlayerResultsSize(PlayerNames playerNames, ResultContents resultContents) {
        if (playerNames.getPlayerNames().size() != resultContents.getResultContents().size()) {
            throw new IllegalArgumentException(PLAYER_RESULT_SIZE_MISMATCH_ERROR_MESSAGE);
        }
    }

    public void buildBridges() {
        ladder.buildBridges();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public PlayerNames getPlayerNames() {
        return playerNames;
    }
}
