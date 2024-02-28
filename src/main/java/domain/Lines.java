package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import strategy.PointStrategy;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int playerCount, Height height, PointStrategy pointStrategy) {
        return new Lines(IntStream.range(0, height.getHeight())
            .mapToObj(i -> Line.of(pointStrategy, playerCount))
            .toList());
    }

    public int findRewardIndex(int memberIndex) {
        int rewardIndex = memberIndex;
        for (Line line : lines) {
            rewardIndex = line.findNextIndex(rewardIndex);
        }
        return rewardIndex; // TODO: reduce, binary operator
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
