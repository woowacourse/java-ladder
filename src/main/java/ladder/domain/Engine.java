package ladder.domain;

import static ladder.util.NotNullValidator.validateNotNull;

public class Engine {
    private Players players;
    private final Ladder ladder;

    public Engine(Ladder ladder, Players playersBeforeGame) {
        validateNotNull(ladder);
        validateNotNull(playersBeforeGame);
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
