package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    Direction first;

    @BeforeEach
    void setUp() {
        first = Direction.first(true);
    }

    @Test
    void 첫번째_방향_테스트() {
        assertThat(first).isEqualTo(Direction.of(false, true));
    }

    @Test
    void 마지막_방향_테스트() {
        assertThat(first.last()).isEqualTo(Direction.of(true, false));
    }

    @Test
    void 오른쪽_이동_테스트() {
        assertThat(first.move()).isEqualTo(1);
    }

    @Test
    void 왼쪽_이동_테스트() {
        assertThat(first.last().move()).isEqualTo(-1);
    }

    @Test
    void 이동가능한지_테스트() {
        assertThat(first.isMovable()).isTrue();
    }
}
