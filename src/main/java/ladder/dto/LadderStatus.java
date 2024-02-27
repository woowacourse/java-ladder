package ladder.dto;

import ladder.domain.GameResults;
import ladder.domain.Ladder;
import ladder.domain.PlayerNames;

import java.util.List;

public record LadderStatus(List<String> playerNames, List<PathStatuses> pathStatuses, List<String> gameResults) {

    public static LadderStatus of(PlayerNames playerNames, Ladder ladder, GameResults gameResults) {
        List<PathStatuses> pathStatuses = ladder.getPaths()
                .stream()
                .map(paths -> new PathStatuses(paths.getPathStatuses()))
                .toList();

        return new LadderStatus(playerNames.getPlayerNames(), pathStatuses, gameResults.getGameResults());
    }
}
