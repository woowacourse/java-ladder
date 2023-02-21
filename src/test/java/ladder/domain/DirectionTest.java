package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {
    
    @Test
    @DisplayName("각 Line의 첫 Direction의 Bar는 왼쪽 false, 오른쪽 true로 생성되기 때문에, 포지션을 조정할 때 1 플러스한다.")
    void createFirst() {
        Direction firstDirection = Direction.createFirst(() -> true);
        int resultPosition = firstDirection.adjustedPosition(3);
        assertThat(resultPosition).isEqualTo(4);
    }
}