package ladder.dto;

import ladder.domain.GameResults;
import ladder.domain.Ladder;
import ladder.domain.Paths;
import ladder.domain.PlayerNames;

import java.util.ArrayList;
import java.util.List;

public record LadderStatus(List<String> playerNames, List<PathStatuses> pathStatuses, List<String> gameResults) {

    public static LadderStatus of(PlayerNames playerNames, Ladder ladder, GameResults gameResults) {
        List<Paths> paths = ladder.getPaths();
        List<PathStatuses> pathStatuses = new ArrayList<>();
        for (int i = paths.size() - 1; i >= 0; i--) {
            pathStatuses.add(new PathStatuses(paths.get(i).getPathStatuses()));
        }

        return new LadderStatus(playerNames.getPlayerNames(), pathStatuses, gameResults.getGameResults());
    }
}
