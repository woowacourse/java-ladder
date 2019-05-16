package ladder.domain;

public class LadderGame {
    private static final String GET_ONE_PLAYER_ERROR = "일치하는 플레이어 이름이 없습니다.";
    private Ladder ladder;
    private Players players;
    private Results results;

    public LadderGame(Players players, Results results, Floor floor) {
        this.players = players;
        this.results = results;
        ladder = new Ladder(floor, players.size());
    }

    public String getOnePlayerResult(Name name) {
        if (!this.players.getNames().contains(name)) {
            throw new IllegalArgumentException(GET_ONE_PLAYER_ERROR);
        }
        int resultIndex = ladder.findOneResult(players.indexOf(name));
        return results.get(resultIndex).toString();
    }

    public String getAllPlayerResult() {
        StringBuilder sb = new StringBuilder();
        for (Name name : players.getNames()) {
            sb.append(name.toString() + " : " + this.getOnePlayerResult(name) + "\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return players.toString() + "\n" + ladder.toString() + results.toString() + "\n";
    }
}
