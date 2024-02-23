package ladder.dto.response;

import ladder.domain.player.Player;

public record PlayerResponse(String name) {
    public static PlayerResponse from(Player player) {
        String name = player.getName();

        return new PlayerResponse(name);
    }
}
