package ladder.model;

public class LadderGame {
    private static final String GET_ONE_PLAYER_ERROR = "일치하는 플레이어 이름이 없습니다.";
    private static final String NEW_LINE = "\n";
    private static final String SPACE_COLON = " : ";
    private Ladder ladder;
    private Players players;
    private Results results;

    public LadderGame(Players players, Results results, Floor floor) {
        this.players = players;
        this.results = results;
        ladder = new Ladder(floor, players.getPlayerNumber());
    }

    public String getOnePlayerResult(PlayerName playerName) {
        if (!this.players.getPlayerNames().contains(playerName)) {
            throw new IllegalArgumentException(GET_ONE_PLAYER_ERROR);
        }
        int resultIndex = ladder.findOneResult(players.getPlayerIndexByPlayerName(playerName));
        return results.getResultNameByIndex(resultIndex).toString();
    }

    public String getAllPlayerResult() {
        StringBuilder sb = new StringBuilder();
        for (PlayerName playerName : players.getPlayerNames()) {
            sb.append(playerName.toString() + SPACE_COLON + this.getOnePlayerResult(playerName) + NEW_LINE);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return players.toString() + NEW_LINE + ladder.toString() + results.toString() + NEW_LINE;
    }
}
