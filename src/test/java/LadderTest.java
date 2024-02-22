import static org.assertj.core.api.Assertions.assertThatCode;

import domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리 객체를 정상적으로 생성한다.")
    @Test
    void createLadder() {
        assertThatCode(() -> new Ladder(5))
                .doesNotThrowAnyException();
    }
}
