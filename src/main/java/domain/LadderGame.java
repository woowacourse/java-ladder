package domain;

import domain.ladder.Ladder;

public class LadderGame {

    private static final String PLAYER_RESULT_SIZE_MISMATCH_ERROR_MESSAGE = "게임 참여자와 결과의 개수는 동일하여야 합니다.";

    private final Ladder ladder;
    private final Players players;
    private final ResultContents resultContents;

    public LadderGame(Ladder ladder, Players players, ResultContents resultContents) {
        validatePlayerResultsSize(players, resultContents);
        this.ladder = ladder;
        this.players = players;
        this.resultContents = resultContents;
    }

    private void validatePlayerResultsSize(Players players, ResultContents resultContents) {
        if (players.playerAmount() != resultContents.getResultContents().size()) {
            throw new IllegalArgumentException(PLAYER_RESULT_SIZE_MISMATCH_ERROR_MESSAGE);
        }
    }

    public void buildBridges() {
        ladder.buildBridges();
    }

    public void runGame() {

    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }

    public ResultContents getResultContents() {
        return resultContents;
    }
}
