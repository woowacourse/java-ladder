package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리 객체를 정상적으로 생성한다.")
    @Test
    void createLadder() {
        assertThatCode(() -> new Ladder(new RandomLegGenerateStrategy(), new Height(1), 1))
                .doesNotThrowAnyException();
    }
}
