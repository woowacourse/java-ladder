import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @DisplayName("사다리 객체를 정상적으로 생성한다.")
    @Test
    void createLadder() {
        assertThatCode(()->new Ladder(5))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 높이가 0이하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void createLadderWithUnderZero(int invalidHeight) {
        assertThatThrownBy(() -> new Ladder(invalidHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
