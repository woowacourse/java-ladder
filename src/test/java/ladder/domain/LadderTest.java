package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("사다리 높이만큼 라인을 생성한다.")
    void test_1() {
        // given
        Ladder ladder = new Ladder();

        // when
        ladder.create(() -> true, 5, 4);

        // then
        Assertions.assertThat(ladder.getLines().size()).isEqualTo(5);
    }
}
