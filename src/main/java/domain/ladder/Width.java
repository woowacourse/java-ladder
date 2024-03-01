package domain.ladder;

import domain.player.Names;

public record Width(int value) {
    public static Width from(final Names names) {
        return new Width(names.count() - 1);
    }
}
