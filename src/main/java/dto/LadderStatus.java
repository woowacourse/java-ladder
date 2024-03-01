package dto;

import domain.game.LadderDestinations;
import domain.ladder.Ladder;
import domain.ladder.Paths;
import domain.player.PlayerNames;

import java.util.ArrayList;
import java.util.List;

public record LadderStatus(List<String> playerNames, List<PathStatuses> pathStatuses, List<String> gameResults) {

    public static LadderStatus of(PlayerNames playerNames, Ladder ladder, LadderDestinations ladderDestinations) {
        List<Paths> paths = ladder.getPaths();
        List<PathStatuses> pathStatuses = new ArrayList<>();
        for (int i = paths.size() - 1; i >= 0; i--) {
            pathStatuses.add(PathStatuses.of(paths.get(i)));
        }

        return new LadderStatus(playerNames.getPlayerNames(), pathStatuses, ladderDestinations.getGameResults());
    }
}
