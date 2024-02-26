package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MoveTest {

    @Test
    @DisplayName("플레이어의 왼쪽에 라인이 있을 경우 오른쪽으로 이동한다.")
    void moveLeftWhenLeftLine() {

    }

    @Test
    @DisplayName("플레이어의 오른쪽과 왼쪽에 모두 라인이 없을 경우 아래로 이동한다.")
    void moveDownWhenRightLine() {

    }

    @Test
    @DisplayName("플레이어가 왼쪽/오른쪽 가장자리에 있을 경우 범위를 벗어나는 오른쪽/왼쪽을 탐색하지 않는지 확인한다.")
    void checkMoveOutOfBound() {

    }

}
