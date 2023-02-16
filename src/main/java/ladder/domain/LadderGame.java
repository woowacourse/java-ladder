package ladder.domain;

import ladder.utils.LineStrategy;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<List<Boolean>> getLines() {
        return ladder.getLines()
                .stream()
                .map(Line::getParts)
                .collect(Collectors.toList());
    }

    public int getNameMaxLength() {
        return players.getNameMaxLength();
    }
}
