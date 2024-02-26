package domain.game;

import domain.ladder.Ladder;
import domain.ladder.Line;

import java.util.List;

import static java.util.stream.IntStream.range;

public class LadderGame {
    public static Result play(final Ladder ladder) {
        List<Integer> from = range(0, ladder.getWidth() + 1).boxed().toList();
        for (Line line : ladder.getLines()) {
            from = new LineMover(line, from).getResult();
        }
        return new Result(from);
    }
}
