package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DestinationTest {
    @DisplayName("실행 결과가 5자를 초과하면 예외를 던진다")
    @Test
    void createNameByOverLength() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Destination("꽝꽝꽝꽝꽝꽝"))
                .withMessage("실행 결과는 5자 이하여야 합니다.");
    }
}
