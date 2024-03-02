package domain.ladder;

import domain.player.PlayerNames;

public record Width(int value) {
    public static Width from(final PlayerNames playerNames) {
        return new Width(playerNames.count() - 1);
    }
}
