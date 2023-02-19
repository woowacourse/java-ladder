package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;

    public LadderGame(List<String> names, int height, LineStrategy lineStrategy) {
        this.players = new Players(names);
        this.ladder = new Ladder(height);
        ladder.assignLines(lineStrategy, names.size() - 1);
    }

    public List<List<Boolean>> getLines() {
        return ladder.getLines()
                .stream()
                .map(Line::getSections)
                .collect(Collectors.toList());
    }

    public int getNameMaxLength() {
        return players.getNameMaxLength();
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }
}
