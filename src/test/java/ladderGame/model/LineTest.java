package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LineTest {
    @Test
    @DisplayName("연속으로 줄이 연결되어 있을 시 예외처리 된다.")
    void notConsecutiveDraw() {
        assertThatThrownBy(() -> new Line(List.of(ConnectionStatus.CONNECTION, ConnectionStatus.CONNECTION)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("해당 위치에서 연결된 길 최종 위치를 알려준다.")
    void checkConnectionAndFindMovePosition() {
        Line line = new Line(List.of(ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION));

        assertAll(
                () -> assertEquals(line.checkConnectionAndFindNextPosition(0), 1),
                () -> assertEquals(line.checkConnectionAndFindNextPosition(1), 0),
                () -> assertEquals(line.checkConnectionAndFindNextPosition(2), 2)
        );
    }
}
