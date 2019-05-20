package laddergame.domain;

import laddergame.domain.rule.Rule;
import laddergame.util.Validator;

import java.util.*;

public class Ladder {
    private static final int MIN_HEIGHT = 1;

    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(int numberOfPlayer, int height, Rule rule) {
        Validator.checkLadderHeight(height, MIN_HEIGHT);

        this.lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(numberOfPlayer, rule));
        }
    }

    public int takeLadder(int point) {
        for (Line line : lines) {
            point = line.moveNextPoint(point);
        }
        return point;
    }

    public LadderGameResult startGame(Players players, Rewards rewards) {
        Validator.checkEqualSize(players.size(), rewards.size());

        Map<Player, Reward> result = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            result.put(players.get(i), rewards.get(takeLadder(i)));
        }
        return new LadderGameResult(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        StringBuilder ladderView = new StringBuilder();
        for (Line line : lines) {
            ladderView.append(line);
            ladderView.append("\n");
        }
        return ladderView.toString();
    }
}
