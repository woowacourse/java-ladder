package domain.ladder;

import domain.Goals;
import domain.Height;
import domain.Players;
import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();
    private final BooleanGenerator booleanGenerator;
    private final Players players;
    private final Goals goals;

    public Ladder(BooleanGenerator booleanGenerator, Players players, Goals goals) {
        this.booleanGenerator = booleanGenerator;
        this.players = players;
        this.goals = goals;
    }

    public static Ladder of(BooleanGenerator booleanGenerator, Players players, Goals goals) {
        return new Ladder(booleanGenerator, players, goals);
    }

    public void build(final Height height, final int width) {
        generateLines(height, width, booleanGenerator);
    }

    private void generateLines(final Height height, final int width, BooleanGenerator booleanGenerator) {
        while (height.isNotBottom()) {
            Line currentLine = Line.of(width, booleanGenerator);
            currentLine.generateSteps();
            this.lines.add(currentLine);
        }
    }

    public List<List<Boolean>> getConnectedToRightConditionsOfAll() {
        return lines.stream()
                .map(Line::getConnectedToRightConditions)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                ", booleanGenerator=" + booleanGenerator +
                '}';
    }

    public String ride(String participantName) {
        int startingPoint = players.getSequenceOf(participantName);
        return goals.getNameOfSequence(ride(startingPoint, 0));
    }

    private int ride(int startingPoint, int indexFromTop) {
        if (indexFromTop == lines.size()) {
            return startingPoint;
        }

        Line line = lines.get(indexFromTop);
        if (line.isConnectedToLeft(startingPoint)) {
            return ride(startingPoint - 1, indexFromTop + 1);
        }
        if (line.isConnectedToRight(startingPoint)) {
            return ride(startingPoint + 1, indexFromTop + 1);
        }
        return ride(startingPoint, indexFromTop + 1);
    }

    public Players getNames() {
        return players;
    }

    public Goals getGoals() {
        return goals;
    }
}
