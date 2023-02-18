package ladder.domain;

import java.util.List;

public class Line {

    private final Bars bars;

    public Line(int playerCount) {
        validatePlayerCount(playerCount);
        bars = new Bars(new RandomBarGenerator(), playerCount - 1);
    }

    private void validatePlayerCount(int playerCount) {
        if (playerCount < Players.MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참가자는 1명이하일 수 없습니다.");
        }
    }

    public List<Boolean> toUnmodifiableBars() {
        return bars.toUnmodifiableBars();
    }
}
