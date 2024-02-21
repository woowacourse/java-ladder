package ladder.dto;

import ladder.domain.player.Player;

public record PlayerDto(String name) {

    public static PlayerDto from(Player player) {
        String name = player.getName();

        return new PlayerDto(name);
    }
}
