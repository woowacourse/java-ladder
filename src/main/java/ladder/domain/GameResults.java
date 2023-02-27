package ladder.domain;

import ladder.domain.ladder.Bar;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.people.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResults {
    private final List<String> names;
    private final List<String> results;
    private final Ladder ladder;

    public GameResults(List<String> names, List<String> results, Ladder ladder) {
        this.names = names;
        this.results = results;
        this.ladder = ladder;
    }

    public Map<String, String> calculateGameResults() {
        Map<String, String> gameResults = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            Position position = new Position(i);
            goDownLadder(ladder, position);
            gameResults.put(names.get(i), results.get(position.getPosition()));
        }
        return gameResults;
    }

    private void goDownLadder(Ladder ladder, Position position) {
        for (Line line : ladder.getLines()) {
            Bar leftBar = line.getIndexBar(position.getPosition());
            Bar rightBar = line.getIndexBar(position.getPosition() + 1);
            position.movePosition(directMove(leftBar, rightBar));
        }
    }

    private int directMove(Bar leftBar, Bar rightBar) {
        if (leftBar == Bar.TRUE) {
            return -1;
        }
        if (rightBar == Bar.TRUE) {
            return 1;
        }
        return 0;
    }
}
