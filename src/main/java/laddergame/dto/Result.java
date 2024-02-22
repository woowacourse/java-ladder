package laddergame.dto;

import java.util.List;
import laddergame.domain.Ladder;
import laddergame.domain.Names;

public record Result(List<String> names, List<List<Boolean>> ladder) {

    public static Result of(final Names names, final Ladder ladder) {
        return new Result(names.getNames(), ladder.getLinesState());
    }
}
