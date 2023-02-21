package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(List<String> names, int height) {
        this.players = new Players(generatePlayers(names));
        LadderMaker ladderMaker = new LadderMaker(new LadderProperty(names.size() - 1, height));

        this.ladder = ladderMaker.generate();
    }

    private List<Player> generatePlayers(List<String> names) {
        List<Player> gamePlayers = new ArrayList<>();
        for (int startIndex = 0; startIndex < names.size(); startIndex++) {
            gamePlayers.add(new Player(names.get(startIndex), startIndex));
        }
        return gamePlayers;
    }

    public List<String> getNames () {
        return players.getNames();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }
}
