package ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Row {
    private final List<Direction> row;

    private Row(List<Direction> row) {
        this.row = row;
    }

    public static Row of(List<Direction> row) {
        return new Row(row);
    }

    public int move(int position) {
        return position + row.get(position).move();
    }

    public List<Boolean> isLinked() {
        return row.stream()
                .map(Direction::isMovable)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Row row = (Row) o;
        return Objects.equals(this.row, row.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row);
    }
}
