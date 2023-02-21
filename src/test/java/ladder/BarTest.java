package ladder;

import static org.assertj.core.api.Assertions.*;

import ladder.domain.Bar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BarTest {

    @ParameterizedTest
    @CsvSource(value = {"true:MOVABLE","false:IMMOVABLE"}, delimiter = ':')
    @DisplayName("입력에 알맞은 bar를 생성한다")
    void shouldCreateBarWhenInput(boolean input, Bar expectedBar) {
        // given
        // when
        Bar bar = Bar.of(input);
        // then
        assertThat(bar).isEqualTo(expectedBar);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:true","false:false"}, delimiter = ':')
    @DisplayName("건널 수 있는 bar인지 확인한다.")
    public void shouldReturnWhetherCanMoveWhenRequest(boolean input, boolean expected) {
        //given
        //when
        Bar bar = Bar.of(input);
        //then
        assertThat(bar.isMovable()).isEqualTo(expected);
    }
}
