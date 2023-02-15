package laddergame.domain;

import java.util.List;

public class LadderGame {

    private Players players;
    private Ladder ladder;

    public void setPlayers(List<String> playerNames) {
        players = new Players(playerNames);
    }

    public void makeLadder(int height) {
        ladder = new Ladder(players.size(), new LadderHeight(height));
    }
}
