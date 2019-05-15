package ladder.domain;

public class LadderGame {
    private Ladder ladder;
    private Players players;

    public LadderGame(Floor floor, String input) {
        players = new Players(input);
        ladder = new Ladder(floor, players.getPlayerNumber());
    }

    @Override
    public String toString() {
        return players.toString() + "\n" + ladder.toString();
    }
}
