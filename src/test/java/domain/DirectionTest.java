package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionTest {

    @DisplayName("true면 RIGHT을 반환한다.")
    @Test
    public void generateRightDirection() {
        assertThat(Direction.generate(true))
                .isSameAs(Direction.RIGHT);
    }

    @DisplayName("false면 DOWN을 반환한다.")
    @Test
    public void generateDownDirection() {
        assertThat(Direction.generate(false))
                .isSameAs(Direction.DOWN);
    }
}
