package ladder.domain;

import ladder.utils.LineStrategy;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Results results;

    public LadderGame(Command command, LineStrategy lineStrategy) {
        this.players = new Players(command.getNames());
        this.ladder = new Ladder(command.getWidth(), command.getHeight(), lineStrategy);
        this.results = new Results(command.getResults());
    }

    public List<List<Boolean>> getLadder() {
        return ladder.getLines();
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }
}
