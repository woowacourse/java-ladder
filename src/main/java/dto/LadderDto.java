package dto;

import domain.game.LadderDestinations;
import domain.ladder.Ladder;
import domain.ladder.Paths;
import domain.player.PlayerNames;

import java.util.ArrayList;
import java.util.List;

public record LadderDto(List<String> playerNames, List<PathStatusesDto> pathStatusDtos, List<String> ladderDestinations) {

    public static LadderDto of(PlayerNames playerNames, Ladder ladder, LadderDestinations ladderDestinations) {
        List<Paths> paths = ladder.getPaths();
        List<PathStatusesDto> pathStatusDtos = new ArrayList<>();
        for (int i = paths.size() - 1; i >= 0; i--) {
            pathStatusDtos.add(PathStatusesDto.of(paths.get(i)));
        }

        return new LadderDto(playerNames.getPlayerNames(), pathStatusDtos, ladderDestinations.getGameResults());
    }
}
