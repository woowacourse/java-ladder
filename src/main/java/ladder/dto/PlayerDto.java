package ladder.dto;

import ladder.domain.player.Player;

public record PlayerDto(String name) {

    public static PlayerDto from(final Player player) {
        final String name = player.getName();

        return new PlayerDto(name);
    }
}
