package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {
    private Direction firstDirectionTrue;
    private Direction firstDirectionFalse;
    
    @BeforeEach
    void setUp() {
        firstDirectionTrue = Direction.createFirst(() -> true);
        firstDirectionFalse = Direction.createFirst(() -> false);
    }
    
    @Test
    @DisplayName("각 Line의 첫 Direction의 Bar가 왼쪽 false, 오른쪽 true일 때, 포지션을 +1 한다.")
    void createFirstTrue() {
        int resultPosition = firstDirectionTrue.getAdjustedPosition(3);
        assertThat(resultPosition).isEqualTo(4);
    }
    
    @Test
    @DisplayName("각 Line의 첫 Direction의 Bar가 왼쪽 false, 오른쪽 false일 때, 포지션을 그대로 반환한다.")
    void createFirstFalse() {
        int resultPosition = firstDirectionFalse.getAdjustedPosition(3);
        assertThat(resultPosition).isEqualTo(3);
    }
    
    @Test
    @DisplayName("각 Line의 중간 Direction의 Bar가 왼쪽이 true인 경우 오른쪽은 무조건 false이기 때문에, 포지션을 -1 한다.")
    void createNextLeft() {
        Direction nextDirection = firstDirectionTrue.createNext(() -> false);
        int resultPosition = nextDirection.getAdjustedPosition(3);
        assertThat(resultPosition).isEqualTo(2);
    }
    
    @Test
    @DisplayName("각 Line의 중간 Direction의 Bar가 왼쪽이 false, 오른쪽 true인 경우, 포지션을 +1 한다.")
    void createNextRight() {
        Direction nextDirection = firstDirectionFalse.createNext(() -> true);
        int resultPosition = nextDirection.getAdjustedPosition(3);
        assertThat(resultPosition).isEqualTo(4);
    }
    
    @Test
    @DisplayName("각 Line의 중간 Direction의 Bar가 왼쪽이 false, 오른쪽 false인 경우, 포지션을 그대로 반환한다.")
    void createNextMiddle() {
        Direction nextDirection = firstDirectionFalse.createNext(() -> false);
        int resultPosition = nextDirection.getAdjustedPosition(3);
        assertThat(resultPosition).isEqualTo(3);
    }
    
    @Test
    @DisplayName("각 Line의 마지막 Direction의 Bar가 왼쪽이 false, 오른쪽 false인 경우, 포지션을 그대로 반환한다.")
    void createLastMiddle() {
        Direction nextDirection = firstDirectionFalse.createLast();
        int resultPosition = nextDirection.getAdjustedPosition(3);
        assertThat(resultPosition).isEqualTo(3);
    }
    
    @Test
    @DisplayName("각 Line의 마지막 Direction의 Bar가 왼쪽이 true, 오른쪽 false인 경우, 포지션을 -1 한다.")
    void createLastLeft() {
        Direction nextDirection = firstDirectionTrue.createLast();
        int resultPosition = nextDirection.getAdjustedPosition(3);
        assertThat(resultPosition).isEqualTo(2);
    }
}