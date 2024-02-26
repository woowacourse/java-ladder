package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizesTest {
    @Test
    @DisplayName("1글자 이상, 5글자 이하면 예외를 발생하지 않는다.")
    void createFail() {
        assertThatCode(() -> new Prizes(List.of("꽝", "꽝", "30000")))
                .doesNotThrowAnyException();
    }
}
