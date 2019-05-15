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
        StringBuilder sb = new StringBuilder();
        sb.append(players.toString());
        sb.append("\n");
        sb.append(ladder.toString());
        return sb.toString();
    }
}
