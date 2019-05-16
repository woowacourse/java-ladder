package ladder.domain;

public class LadderGame {
    private static final String PLAYERS_RESULTS_NUMBER_ERROR = "플레이어수와 결과수가 다릅니다.";
    private Ladder ladder;
    private Players players;
    private Results results;

    public LadderGame(Floor floor, String playersInput, String resultsInput) {
        players = new Players(playersInput);
        results = new Results(resultsInput);
        checkPlayersResultsNumber();
        ladder = new Ladder(floor, players.getPlayerNumber());
    }

    private void checkPlayersResultsNumber() {
        if(players.getPlayerNumber() != results.getResultNumber()){
            throw new IllegalArgumentException(PLAYERS_RESULTS_NUMBER_ERROR);
        }
    }

    public String getOnePlayerResult(PlayerName playerName) {
        if(!this.players.getPlayerNames().contains(playerName)){
            throw new IllegalArgumentException("일치하는 플레이어 이름이 없습니다.");
        }
        int resultIndex = ladder.findOneResult(players.getPlayerIndex(playerName));
        return results.getResultName(resultIndex).toString().trim();
    }

    public String getAllPlayerResult() {
        StringBuilder sb = new StringBuilder();
        for(PlayerName playerName : players.getPlayerNames()) {
            sb.append(playerName.toString().trim() + " : " + this.getOnePlayerResult(playerName).trim() + "\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return players.toString() + "\n" + ladder.toString() + results.toString() + "\n";
    }
}
