package ladder;

import static org.assertj.core.api.Assertions.*;

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
}
