package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    @DisplayName("연속으로 줄이 연결되어 있을 시 예외처리 된다.")
    void notConsecutiveDraw() {
        assertThatThrownBy(() -> new Line(List.of(ConnectionStatus.CONNECTION, ConnectionStatus.CONNECTION)))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("해당 위치에서 왼쪽으로 연결된 길이 있는지 알려준다.")
    void checkLeftConnection() {
        Line line = new Line(List.of(ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION, ConnectionStatus.CONNECTION));

        assertAll(
                () -> assertTrue(line.checkLeftConnection(1)),
                () -> assertFalse(line.checkLeftConnection(2))
                );

    }
}
