package domain;

import factory.LadderFactory;
import factory.PlayersFactory;

import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;

    public LadderGame(final List<String> playerNames, final int ladderHeight) {
        ladder = LadderFactory.generate(playerNames.size(), ladderHeight);
        players = PlayersFactory.generate(playerNames);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

}
