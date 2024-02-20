package domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("사다리는 높이를 가진다.")
    void LadderHeightTest() {
        //given
        Ladder ladder = new Ladder("1");
        //when & then
        Assertions.assertThat(ladder.getHeight()).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리의 높이가 음수일 경우 예외를 발생시킨다.")
    void LadderNegativeInputTest() {
        Assertions.assertThatThrownBy(() -> new Ladder("0"))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
