package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("입력받은 높이에 따른 line을 생성한다")
    void shouldHasSizeOfInputWhenCreateLadder() {
        // given
        // when
        Ladder ladder = new Ladder(3, 4);
        //then
        assertThat(ladder.getLines()).hasSize(3);
    }
}
