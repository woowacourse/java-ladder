package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final Width width, final Height height, final ScaffoldGenerator scaffoldGenerator) {
        this.lines = Stream.generate(() -> new Line(width, scaffoldGenerator))
                .limit(height.getValue())
                .collect(Collectors.toUnmodifiableList());
    }

    public Map<String, String> calculateMatching(final Names names, final Prizes prizes) {
        Map<String, String> totalResult = new HashMap<>();
        IntStream.range(0, names.size())
                .forEach(position -> totalResult.put(names.getNameByIndex(position).getValue(),
                        calculateSingleMatching(prizes, position))
        );
        return new HashMap<>(totalResult);
    }

    private String calculateSingleMatching(final Prizes prizes, final int startPosition) {
        int currentPosition = startPosition;
        for (Line line : lines) {
            currentPosition = line.move(currentPosition);
        }
        return prizes.getPrizeByIndex(currentPosition).getValue();
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).size();
    }

    public List<Line> getLines() {
        return lines;
    }
}