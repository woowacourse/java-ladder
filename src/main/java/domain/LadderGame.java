package domain;

import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;

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
        this.ladder.buildBridges();
    }

    public void runGame() {
        for (int i = 0; i < players.playerAmount(); i++) {
            int resultAt = this.ladder.findResultAtByStartLineAt(i);
            matchPlayerResult(i, resultAt);
        }
    }

    private void matchPlayerResult(int playerAt, int resultAt) {
        ResultContent resultContent = resultContents.getResultContents().get(resultAt);
        Player player = this.players.getPlayers().get(playerAt);

        player.updateResult(resultContent);
    }

    public String getResultByPlayerName(String playerName) {
        Player player = this.players.findByName(playerName);
        return player.getResultContent();
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public Players getPlayers() {
        return this.players;
    }

    public ResultContents getResultContents() {
        return this.resultContents;
    }
}
