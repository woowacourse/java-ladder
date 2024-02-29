package laddergame.dto;

import java.util.Map.Entry;
import laddergame.domain.name.Name;
import laddergame.domain.result.Result;

public record MatchingResult(String name, String result) {

    public static MatchingResult from(final Entry<Name, Result> entry) {
        return new MatchingResult(entry.getKey().getName(), entry.getValue().getResult());
    }
}
