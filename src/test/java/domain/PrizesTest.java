package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizesTest {
    @Test
    @DisplayName("참여자의 수와 동일하면, 예외를 발생하지 않는다.")
    void createSuccess() {
        assertThatCode(() -> Prizes.of(List.of("꽝", "꽝", "30000"), 3))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("참여자의 수와 동일하지 않다면, 예외를 발생한다.")
    void createFail() {
        assertThatCode(() -> Prizes.of(List.of("꽝", "꽝", "30000"), 4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
