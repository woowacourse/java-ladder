package ladder.domain;

public class LadderEngine {
    private Players players;
    private final Ladder ladder;

    public LadderEngine(Ladder ladder, Players playersBeforeGame) {
        this.ladder = ladder;
        this.players = playersBeforeGame;
    }

    public Players playLadderGame() {
        while(ladder.hasNextLine()) {
            players = players.goDown(ladder.getNextLine());
        }
        return players;
    }
}
