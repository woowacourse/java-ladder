package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladders {
    private final List<Ladder> ladders;

    private Ladders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public static Ladders of(int width, Height height, BooleanGenerator booleanGenerator) {
        return new Ladders(Stream.generate(() -> new Ladder(width, booleanGenerator))
                .limit(height.getHeight())
                .collect(Collectors.toList()));
    }

    public int getHeight() {
        return ladders.size();
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public int getResult(int current) {
        return IntStream.range(0, getHeight())
                .reduce(current, this::calculateResult);
    }

    private int calculateResult(int total, int currentHeight) {
        return total + ladders.get(currentHeight)
                .getLadder()
                .get(total)
                .getMove();
    }
}
