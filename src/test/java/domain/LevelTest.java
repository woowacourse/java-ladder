package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LevelTest {

    @DisplayName("사다리의 가로층을 생성한다")
    @Test
    public void create() {
        assertThatCode(() -> new Level(0))
                .doesNotThrowAnyException();
    }
}
