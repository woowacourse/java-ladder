package laddergame.domain;

import laddergame.util.RandomPointGenerator;

import java.util.List;

public class LadderGame {

    private Players players;
    private Ladder ladder;

    public void setPlayers(List<String> playerNames) {
        players = new Players(playerNames);
    }

    public void makeLadder(int height) {
        ladder = new Ladder(players.size(), height, new RandomPointGenerator());
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public List<Line> getLadderMap() {
        return ladder.getLadder();
    }
}
