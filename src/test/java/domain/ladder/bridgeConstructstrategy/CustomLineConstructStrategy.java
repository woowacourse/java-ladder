package domain.ladder.bridgeConstructstrategy;

import domain.ladder.Bridge;
import domain.ladder.Line;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class CustomLineConstructStrategy implements LineConstructStrategy {

    private final List<List<Bridge>> lines;

    public CustomLineConstructStrategy(List<List<Bridge>> lines) {
        this.lines = new LinkedList<>(lines);
    }

    @Override
    public Line generate(int count) {
        List<Bridge> firstBridges = lines.remove(0);
        List<Bridge> generatedBridges = IntStream.range(0, count)
                .mapToObj(firstBridges::get)
                .toList();
        return new Line(generatedBridges);
    }
}
