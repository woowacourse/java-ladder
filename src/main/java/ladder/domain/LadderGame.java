package ladder.domain;

public class LadderGame {
    private static final String GET_ONE_PLAYER_ERROR = "일치하는 플레이어 이름이 없습니다.";
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
        int resultIndex = ladder.findOneResult(players.getPlayerIndex(playerName));
        return results.getResultName(resultIndex).toString().trim();
    }

    public String getAllPlayerResult() {
        StringBuilder sb = new StringBuilder();
        for (PlayerName playerName : players.getPlayerNames()) {
            sb.append(playerName.toString().trim() + " : " + this.getOnePlayerResult(playerName).trim() + "\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return players.toString() + "\n" + ladder.toString() + results.toString() + "\n";
    }
}
