package laddergame.dto;

import java.util.List;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Name;
import laddergame.domain.Names;
import laddergame.domain.Point;

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
