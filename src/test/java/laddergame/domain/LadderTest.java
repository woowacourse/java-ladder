package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.IntPredicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderTest {

    @Test
    @DisplayName("층수가 1미만이면 예외가 발생한다.")
    void givenUnderOneFloor_thenFail() {
        //then
        assertThatThrownBy(() -> new Ladder(0, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100})
    @DisplayName("층수가 1이상이면 List<Line>이 생성된다.")
    void givenOverOneFloor_thenSuccess(int floor) {
        //given
        final Ladder ladder = new Ladder(floor, 3);

        //then
        assertThat(ladder.getLines()).hasSize(floor);
    }
}
