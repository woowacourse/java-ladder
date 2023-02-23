package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import strategy.PassGenerator;

public class Ladder {

    private static final int MINIMUM_HEIGHT = 1;

    private final List<Line> lines = new ArrayList<>();
    private final Players players;

    public Ladder(int height, Players players, PassGenerator passGenerator) {
        validateMinHeight(height);
        this.players = players;
        while (height-- > 0) {
            lines.add(new Line(players.getPlayersName().size(), passGenerator));
        }
    }

    private void validateMinHeight(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("높이는 최소 1 이상이어야 합니다");
        }
    }

    public List<List<String>> getLadder() {
        return lines.stream()
            .map(Line::getLineBlockPass)
            .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public Players getPlayers() {
        return players;
    }
}
