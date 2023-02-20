package laddergame.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderTest {

    private static PickStrategy randomPicker;

    @BeforeAll
    static void init() {
        randomPicker = new RandomBooleanPicker();
    }

    @Test
    @DisplayName("높이가 1미만이면 예외가 발생한다.")
    void givenUnderOneHeight_thenFail() {
        //then
        assertThatThrownBy(() -> new Ladder(0, 3, randomPicker))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 높이가 1이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100})
    @DisplayName("높이가 1이상이면 List<Line>이 생성된다.")
    void givenOverOneHeight_thenSuccess(int height) {
        //given
        final Ladder ladder = new Ladder(height, 3, randomPicker);

        //then
        assertThat(ladder.getLines()).hasSize(height);
    }
}
