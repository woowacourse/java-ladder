package ladder.dto;

import ladder.domain.Lines;
import ladder.domain.UserNames;

import java.util.List;

public record LadderResult(List<String> names, List<LineResult> lines) {

    public static LadderResult of(UserNames userNames, Lines lines) {
        return new LadderResult(userNames.getUserNames(), lines.getLineResults());
    }
}
