package domain.game;

import domain.ladder.Ladder;
import domain.ladder.Row;

import java.util.List;

import static java.util.stream.IntStream.rangeClosed;

public class LadderGame {
    public static PathMapper play(final Ladder ladder) {
        List<Integer> path = rangeClosed(0, ladder.getWidth()).boxed().toList();
        for (final Row row : ladder.getRows()) {
            path = LadderClimber.climbDownRow(path, row);
        }
        return new PathMapper(path);
    }
}
