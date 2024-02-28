package domain.ladder;

import domain.player.Players;

public record Width(int value) {
    public static Width from(final Players players) {
        return new Width(players.count() - 1);
    }
}
