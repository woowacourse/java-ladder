package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderBuilder {
    private LadderBuildingStrategy strategy;

    public LadderBuilder(LadderBuildingStrategy strategy) {
        this.strategy = strategy;
    }

    public Ladder build(LadderHeight height, int numberOfPeople) {
        return new Ladder(createLines(height, numberOfPeople), numberOfPeople);
    }

    private List<Line> createLines(LadderHeight height, int numberOfPeople) {
        return IntStream.range(0, height.getHeight())
                .mapToObj(it -> new Line(createPoints(numberOfPeople)))
                .collect(Collectors.toList());
    }

    private List<Boolean> createPoints(int numberOfPeople) {
        List<Boolean> points = new ArrayList<>();
        boolean isConnected = false;

        for (int i = 0; i < numberOfPeople; i++) {
            isConnected = connect(i, numberOfPeople, isConnected);
            points.add(isConnected);
        }

        return points;
    }

    private boolean connect(int point, int numberOfPeople, boolean previousPointConnected) {
        if (!isAvailableToConnect(point, numberOfPeople, previousPointConnected)) {
            return false;
        }

        return strategy.generate();
    }

    private boolean isAvailableToConnect(int point, int numberOfPeople, boolean previousPointConnected) {
        return (point < numberOfPeople - 1) && !previousPointConnected;
    }
}
