package ladder.domain;

import java.util.List;

public class Line {

    private final StepPoints stepPoints;

    public Line(int playerCount) {
        validatePlayerCount(playerCount);
        stepPoints = new StepPoints(new RandomStepPointGenerator(), playerCount - 1);
    }

    private void validatePlayerCount(int playerCount) {
        if (playerCount < Players.MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참가자는 1명이하일 수 없습니다.");
        }
    }

    public List<Boolean> toUnmodifiableStepPoints() {
        return stepPoints.toUnmodifiableStepPoints();
    }
}
