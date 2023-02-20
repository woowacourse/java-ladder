package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderTest {

    @DisplayName("사다리 높이가 참가자 수 미만이면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource({"3,4", "4,5"})
    void throwExceptionWhenHeightIsLessThanPersonCount(int height, int personCount) {
        assertThatThrownBy(() -> new Ladder(new RandomBooleanGenerator(), height, personCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 참가자 수 이상이어야 합니다.");
    }

    @DisplayName("사다리 높이가 참가자 수 이상이면 예외를 발생시키지 않는다.")
    @ParameterizedTest
    @CsvSource({"4,3", "5,5"})
    void doesNotThrowExceptionWhenHeightIsNotLessThanPersonCount(int height, int personCount) {
        assertThatCode(() -> new Ladder(new RandomBooleanGenerator(), height, personCount))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리를 타고 내려갔을 때의 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,3", "1,1", "2,0", "3,2"})
    void shouldReturnResultOfLadder(int index, int expected) {
        Ladder ladder = new Ladder(new TestBooleanGenerator(
                Lists.newArrayList(true, false, false, true, true, true, false, false, false)),
                4,
                4);
        assertThat(ladder.move(index)).isEqualTo(expected);
    }
}
