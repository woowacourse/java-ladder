package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {
    private Direction firstDirection;
    
    @BeforeEach
    void setUp() {
        firstDirection = Direction.createFirst(() -> true);
    }
    
    @Test
    @DisplayName("각 Line의 첫 Direction의 Bar는 왼쪽 false, 오른쪽 true이기 때문에, 포지션을 조정할 때 1 플러스한다.")
    void createFirst() {
        int resultPosition = firstDirection.getAdjustedPosition(3);
        assertThat(resultPosition).isEqualTo(4);
    }
    
    @Test
    @DisplayName("각 Line의 중간 Direction의 Bar는 왼쪽이 true인 경우 오른쪽은 무조건 false이기때문에, 포지션을 조정할 때 1 마이너스한다.")
    void createNext() {
        Direction nextDirection = firstDirection.createNext(() -> false);
        int resultPosition = nextDirection.getAdjustedPosition(3);
        assertThat(resultPosition).isEqualTo(2);
    }
}