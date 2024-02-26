package ladder.dto;

import ladder.domain.Lines;
import ladder.domain.PlayerNames;

import java.util.List;

public record LadderResult(List<String> names, List<LineResult> lines) {

    public static LadderResult of(PlayerNames playerNames, Lines lines) {
        return new LadderResult(playerNames.getUserNames(), lines.getLineResults());
    }
}
