package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("라인")
public class LineTest {
    @Test
    @DisplayName("특정 위치의 오른쪽에 라인이 있을 경우 오른쪽을 반환한다.")
    void returnRightWhenRightLine() {
        Line line = new Line(List.of(Rung.EMPTY, Rung.BRIDGE, Rung.EMPTY));
        assertEquals(line.findDirection(1), Direction.RIGHT);
    }

    @Test
    @DisplayName("특정 위치의 왼쪽에 라인이 있을 경우 왼쪽을 반환한다.")
    void returnLeftWhenLeftLine() {
        Line line = new Line(List.of(Rung.EMPTY, Rung.BRIDGE, Rung.EMPTY));
        assertEquals(line.findDirection(2), Direction.LEFT);
    }

    @Test
    @DisplayName("플레이어의 오른쪽과 왼쪽에 모두 라인이 없을 경우 아래로 이동한다.")
    void returnDownWhenEmptyLine() {
        Line line = new Line(List.of(Rung.EMPTY, Rung.EMPTY, Rung.EMPTY));
        assertEquals(line.findDirection(1), Direction.DOWN);
    }
}

