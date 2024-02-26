package laddergame.dto;

import java.util.List;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Line;
import laddergame.domain.name.Name;
import laddergame.domain.name.Names;
import laddergame.domain.ladder.Point;

public record Result(List<String> names, List<List<Boolean>> ladder) {

    public static Result of(final Names names, final Ladder ladder) {
        return new Result(convertNames(names), convertLadder(ladder));
    }

    private static List<String> convertNames(final Names names) {
        return names.getNames().stream()
                .map(Name::getName)
                .toList();
    }

    private static List<List<Boolean>> convertLadder(final Ladder ladder) {
        return ladder.getLines().stream()
                .map(Result::convertLine)
                .toList();
    }

    private static List<Boolean> convertLine(final Line line) {
        return line.getPoints().stream()
                .map(Point::isExist)
                .toList();
    }
}
