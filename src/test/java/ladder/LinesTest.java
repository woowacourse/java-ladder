package ladder;

import static org.assertj.core.api.Assertions.*;

import ladder.domain.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    @DisplayName("입력받은 높이에 따른 line을 생성한다")
    void shouldHasSizeOfInputWhenCreateLadder() {
        // given
        // when
        Lines lines = new Lines(3, 4);
        //then
        assertThat(lines.getLines()).hasSize(3);
    }
}
