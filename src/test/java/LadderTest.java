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
        assertThatCode(()->Ladder.from(5,4))
                .doesNotThrowAnyException();
    }
}
