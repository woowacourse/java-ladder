package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @Test
    @DisplayName("연속으로 줄이 연결되어 있을 시 예외처리 된다.")
    void notConsecutiveDraw() {
        assertThatThrownBy(() -> new Line(List.of(ConnectionStatus.CONNECTION, ConnectionStatus.CONNECTION)))
                .isInstanceOf(IllegalStateException.class);
    }
}
