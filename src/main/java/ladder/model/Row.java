package ladder.model;

import ladder.model.generator.RandomValueGenerator;

import ladder.model.generator.RandomValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        for (int i = 1; i < numberOfMember - 1; i++) {
            direction = direction.next(RandomValueGenerator.generateRandomValue());
            lines.add(direction);
        }
        lines.add(direction.last());
        return lines;
    }

    public int move(int position) {
        return position + lines.get(position).move();
    }

    public List<Boolean> isLinked() {
        return lines.stream()
                .map(Direction::isMovable)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Row row = (Row) o;
        return Objects.equals(lines, row.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
