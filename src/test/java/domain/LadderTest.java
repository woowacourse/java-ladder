package domain;

import exception.InvalidLadderHeightException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사다리의 높이가 조건에 맞을 경우 객체를 생성한다.")
    @Test
    void ladderSuccess() {
        try {
            new Ladder(10);
        } catch (IllegalArgumentException exception) {
            Assertions.fail("높이가 조건에 맞을 경우 객체를 생성해야 합니다.");
        }
    }

    @DisplayName("사다리의 높이가 10을 넘을 경우 오류를 던진다.")
    @Test
    void heightOver10() {
        Assertions.assertThatThrownBy(() -> new Ladder(11))
            .isExactlyInstanceOf(InvalidLadderHeightException.class);
    }

    @DisplayName("사다리의 높이가 1보다 작을 경우 오류를 던진다.")
    @Test
    void heightLessThan1() {
        Assertions.assertThatThrownBy(() -> new Ladder(0))
            .isExactlyInstanceOf(InvalidLadderHeightException.class);
    }
}
