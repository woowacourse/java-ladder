package ladder.dto;

import java.util.List;
import ladder.domain.player.Players;

public record PlayersDto(List<String> names) {

    public static PlayersDto from(Players players) {
        return new PlayersDto(players.getNames());
    }
}
