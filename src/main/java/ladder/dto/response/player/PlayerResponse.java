package ladder.dto.response.player;

import ladder.domain.player.Player;

public record PlayerResponse(String name) {
    public static PlayerResponse from(Player player) {
        String name = player.name();

        return new PlayerResponse(name);
    }
}
