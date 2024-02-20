package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @DisplayName("높이가 자연수가 아닌 경우 예외가 발생한다.")
    @Test
    void ladderTest(){
        assertThatThrownBy(() -> new Ladder(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
