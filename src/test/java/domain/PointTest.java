package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @DisplayName("방향값을 갖는 Point를 생성한다.")
    @Test
    public void create() {
        assertThatCode(() -> new Point(Direction.DOWN))
                .doesNotThrowAnyException();
    }
}
