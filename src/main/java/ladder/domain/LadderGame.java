package ladder.domain;

import ladder.utils.LineStrategy;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final LineStrategy lineStrategy;

    public LadderGame(List<String> names, int height, LineStrategy lineStrategy) {
        this.players = new Players(names);
        this.ladder = new Ladder(height);
        ladder.assignLines(lineStrategy, names.size() - 1);
        this.lineStrategy = lineStrategy;
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public int getNameMaxLength() {
        return players.getNameMaxLength();
    }
}
