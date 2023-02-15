package ladder.domain;

import java.util.List;

public class Line {

    private final Points points;

    public Line(int playerCount) {
        validatePlayerCount(playerCount);
        points = new Points(new RandomPointGenerator(), playerCount - 1);
    }

    private void validatePlayerCount(int playerCount) {
        if (playerCount <= 1) {
            throw new IllegalArgumentException("참가자는 1명이하일 수 없습니다.");
        }
    }

    public List<Boolean> toUnmodifiablePoints() {
        return points.toUnmodifiablePoints();
    }
}
