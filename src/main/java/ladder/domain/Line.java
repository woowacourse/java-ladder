package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private List<Boolean> points;

    public Line(int playerCount) {
        validatePlayerCount(playerCount);
        points = new ArrayList<>();
        initializePoints(playerCount);
    }

    private void validatePlayerCount(int playerCount) {
        if (playerCount <= 1) {
            throw new IllegalArgumentException("참가자는 1명이하일 수 없습니다.");
        }
    }

    private void initializePoints(int count) {
        for (int i = 0; i < count - 1; i++) {
            points.add(true);
        }
    }

    public List<Boolean> toUnmodifiablePoints() {
        return Collections.unmodifiableList(points);
    }
}
