package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder makeDefaultLadder(int numberOfPlayers, int height, BooleanGenerator booleanGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int numberOfLines = 0; numberOfLines < height; numberOfLines++) {
            lines.add(Line.makeDefaultLine(numberOfPlayers - 1, booleanGenerator));
        }
        return new Ladder(lines);
    }

    public void generateRandomLadder() {
        for (Line line : this.lines) {
            line.generateRandomLine();
        }
    }

    public void movePlayers(Players players) {
        for (Player player : players.getPlayers()) {
            movePlayerInLines(player);
        }
    }

    private void movePlayerInLines(Player player) {
        for (Line line : lines) {
            line.movePlayerInLine(player);
        }
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
