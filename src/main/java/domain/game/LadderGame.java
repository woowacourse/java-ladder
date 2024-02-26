package domain.game;

import domain.ladder.Ladder;
import domain.ladder.Line;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class LadderGame {
    public static Result play(final Ladder ladder) {
        List<Integer> from = range(0, ladder.getWidth() + 1).boxed().toList();
        List<Integer> to = new ArrayList<>(from);
        for (Line line : ladder.getLines()) {
            to = new LineMover(line, to).getResult();
        }
        return new Result(from, to);
    }
}
