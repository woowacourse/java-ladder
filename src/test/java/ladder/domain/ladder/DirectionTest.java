package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    @Test
    void 디렉션_값_확인하기() {
        assertThat(new Direction(true).is()).isEqualTo(true);
    }

    @Test
    void empty메서드_값_확인하기() {
        assertThat(Direction.empty().is()).isEqualTo(false);
    }
}