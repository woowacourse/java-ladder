package domain;

import java.util.*;
import java.util.stream.IntStream;

public class Lines {
    private List<Line> lines;
    private final int height;
    private final LineGenerator lineGenerator;

    public Lines(final int height, LineGenerator lineGenerator) {
        this.height = height;
        this.lineGenerator = lineGenerator;
        this.lines = new ArrayList<>();
    }

    public Map<Name, Integer> playGame(Names names) {
        Map<Name, Integer> gameResult = initializeResultMap(names);

        for (Name name : names.getNames()) {
            movePlayer(gameResult, name);
        }

        return gameResult;
    }

    private void movePlayer(Map<Name, Integer> gameResult, Name playerName) {
        Integer index = gameResult.get(playerName);
        for (Line line : getLines()) {
            index = line.nextIndex(index);
        }
        gameResult.put(playerName, index);
    }

    private Map<Name, Integer> initializeResultMap(Names names) {
        Map<Name, Integer> playerPositions = new LinkedHashMap<>();

        for (int i = 0; i < names.size(); i++) {
            playerPositions.put(names.getNames().get(i), i);
        }

        return playerPositions;
    }

    private void createLines() {
        this.lines = IntStream.range(0, height)
                .mapToObj(index -> new Line(createPoints()))
                .toList();
    }

    private List<Point> createPoints() {
        return lineGenerator.createPoints();
    }

    public List<Line> getLines() {
        if (lines.isEmpty()) {
            createLines();
        }
        return Collections.unmodifiableList(lines);
    }
}
