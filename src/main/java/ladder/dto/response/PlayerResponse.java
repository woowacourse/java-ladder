package ladder.dto.response;

import ladder.domain.player.Player;

public record PlayerResponse(String name) {
    public static PlayerResponse from(final Player player) {
        return new PlayerResponse(player.getName());
    }
}
