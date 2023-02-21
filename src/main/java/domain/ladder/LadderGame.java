package domain.ladder;

import domain.generator.RandomBooleanGenerator;
import domain.player.Players;

import java.util.List;

public class LadderGame {

    private final Players players;

    public LadderGame(List<String> names) {
        this.players = new Players(names);
    }

    public Ladder createLadder(int height) {
        int personCount = players.getPlayers().size();
        return new Ladder(personCount, height, new RandomBooleanGenerator());
    }

    public Players getPlayers() {
        return players;
    }
}
