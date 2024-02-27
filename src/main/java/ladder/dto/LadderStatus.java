package ladder.dto;

import ladder.domain.Ladder;
import ladder.domain.PlayerNames;

import java.util.List;

public record LadderStatus(List<String> playerNames, List<PathStatuses> pathStatuses) {

    public static LadderStatus of(PlayerNames playerNames, Ladder ladder) {
        List<PathStatuses> pathStatuses = ladder.getPaths()
                .stream()
                .map(paths -> new PathStatuses(paths.getPathStatuses()))
                .toList();

        return new LadderStatus(playerNames.getPlayerNames(), pathStatuses);
    }
}
