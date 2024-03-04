package model.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import model.ladder.generator.StepStatusGenerator;
import model.laddergame.Direction;
import model.players.Position;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Height height, Width width, StepStatusGenerator generator) {
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < height.size(); index++) {
            lines.add(Line.from(width, generator));
        }
        return new Ladder(lines);
    }

    public int move(Position position) {
        for (Line line : lines) {
            Direction direction = line.getDirection(position);
            position.move(direction);
        }
        return position.getValue();
    }

    public int size() {
        return lines.size();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
