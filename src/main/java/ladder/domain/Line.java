package ladder.domain;

import java.util.List;

public class Line {

    private final Bars bars;

    public Line(int playerCount) {
        validatePlayerCount(playerCount);
        bars = new Bars(new RandomPointGenerator(), playerCount - 1);
    }

    // TODO : Players와 중복된 검증조건. 도메인 분리구조 재정의하기
    private void validatePlayerCount(int playerCount) {
        if (playerCount < Players.MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다.");
        }
    }

    public List<Boolean> toUnmodifiableBars() {
        return bars.toUnmodifiableBars();
    }
}
