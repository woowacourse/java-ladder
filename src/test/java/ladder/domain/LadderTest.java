package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import ladder.utils.BooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("입력받은 높이에 따른 line을 생성한다")
    void shouldHasSizeOfInputWhenCreateLadder() {
        // given
        // when
        Ladder ladder = Ladder.generate(3, 4, new BooleanGenerator());
        //then
        assertThat(ladder.getLines()).hasSize(3);
    }
}
