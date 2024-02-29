package laddergame.dto;

import java.util.List;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Line;
import laddergame.domain.name.Name;
import laddergame.domain.name.Names;
import laddergame.domain.ladder.Point;
import laddergame.domain.result.Result;
import laddergame.domain.result.Results;

public record LadderResult(
        List<String> names,
        List<List<Boolean>> ladder,
        List<String> results
) {

    public static LadderResult of(final Names names, final Ladder ladder, final Results results) {
        return new LadderResult(convertNames(names), convertLadder(ladder), convertResults(results));
    }

    private static List<String> convertNames(final Names names) {
        return names.getNames().stream()
                .map(Name::getName)
                .toList();
    }

    private static List<List<Boolean>> convertLadder(final Ladder ladder) {
        return ladder.getLines().stream()
                .map(LadderResult::convertLine)
                .toList();
    }

    private static List<String> convertResults(final Results results) {
        return results.getResults().stream()
                .map(Result::getResult)
                .toList();
    }

    private static List<Boolean> convertLine(final Line line) {
        return line.getPoints().stream()
                .map(Point::isExist)
                .toList();
    }
}
