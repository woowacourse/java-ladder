package domain.ladder;

import domain.Goals;
import domain.Height;
import domain.Players;
import util.BooleanGenerator;

import java.util.*;

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

    public void build(final Height height) {
        generateLines(height, players.count(), booleanGenerator);
    }

    private void generateLines(final Height height, final int width, BooleanGenerator booleanGenerator) {
        while (height.isNotBottom()) {
            Line currentLine = Line.of(width, booleanGenerator);
            currentLine.generateSteps();
            this.lines.add(currentLine);
        }
    }

    public Iterator<Iterator<Boolean>> findAllConnectedConditions() {
        return lines.stream()
                .map(Line::findConnectedConditions)
                .iterator();
    }

    public Map<String, String> rideAll() {
        Map<String, String> rideResult = new HashMap<>();
        Iterator<String> playerNames = players.findNames();
        while (playerNames.hasNext()) {
            String playerName = playerNames.next();
            rideResult.put(playerName, ride(playerName));
        }
        return rideResult;
    }

    public String ride(String playerName) {
        int startingSequence = players.findSequenceOf(playerName);
        int goalSequence = ride(startingSequence, 0);
        return goals.findGoalNameOf(goalSequence);
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

    public Iterator<String> findPlayerNames() {
        return players.findNames();
    }

    public Iterator<String> findGoalNames() {
        return goals.findGoalNames();
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                ", booleanGenerator=" + booleanGenerator +
                '}';
    }
}
