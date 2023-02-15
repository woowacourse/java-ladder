package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "10000"})
    @DisplayName("1 이상의 정수 범위의 사다리 높이가 들어오면, 예외가 발생하지 않는다.")
    void ladder_height_success_test(String height){
        // given
        LadderFactory ladderFactory = new LadderFactory();

        // when & then
        assertDoesNotThrow(() -> ladderFactory.createLadder(height));
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi", "23fgie", "@#$%$"})
    @DisplayName("정수 값이 아닌 사다리 높이가 들어오면, 예외가 발생한다.")
    void ladder_height_type_test(String height){
        // given
        LadderFactory ladderFactory = new LadderFactory();

        // when & then
        assertThatThrownBy(() -> ladderFactory.createLadder(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10001"})
    @DisplayName("1~10000 범위를 벗어난 사다리 높이가 입력되면, 예외가 발생한다.")
    void ladder_height_range_test(String height){
        // given
        LadderFactory ladderFactory = new LadderFactory();

        // when & then
        assertThatThrownBy(() -> ladderFactory.createLadder(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
