package laddergame.domain;

import java.util.List;

public record Result(List<String> names, List<List<Boolean>> ladder) {

    public static Result of(final Names names, final Ladder ladder) {
        return new Result(names.getNames(), ladder.getLinesState());
    }
}
