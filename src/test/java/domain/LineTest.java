package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    @DisplayName("앞 뒤 브릿지가 겹치는 경우 예외를 발생시킨다")
    void createRandomLine() {
        final List<Bridge> bridges = List.of(Bridge.BRIDGE, Bridge.BRIDGE, Bridge.BRIDGE);

        assertThatThrownBy(() -> new Line(bridges)).isInstanceOf(IllegalArgumentException.class);
    }
}
