package ladder.model;

import ladder.model.generator.RandomValueGenerator;

import ladder.model.generator.RandomValueGenerator;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private final List<Direction> lines;

    private Row(List<Direction> lines) {
        this.lines = lines;
    }

    static Row of(List<Direction> lines) {
        return new Row(lines);
    }

    static Row generateRandomRow(final int numberOfMember) {
        return new Row(generateRow(numberOfMember));
    }

    private static List<Direction> generateRow(final int numberOfMember) {
        List<Direction> lines = new ArrayList<>();
        Direction direction = Direction.first(RandomValueGenerator.generateRandomValue());
        lines.add(direction);
        for (int i = 0; i < numberOfMember; i++) {
            direction = direction.next(RandomValueGenerator.generateRandomValue());
        }
        lines.add(direction.last());
        return lines;
    }

    public int move(int position) {
        return position + lines.get(position).move();
    }
}
