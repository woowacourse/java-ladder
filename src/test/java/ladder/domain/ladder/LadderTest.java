package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 높이만큼 라인을 생성한다.")
    void test_1() {
        // given
        Ladder ladder = new Ladder(() -> Bar.TRUE, 5, 4);

        // then
        assertThat(ladder.getLines()).hasSize(5);
    }
}
