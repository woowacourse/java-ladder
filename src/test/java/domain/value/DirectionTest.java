package domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static domain.value.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Direction 은")
class DirectionTest {

    @ParameterizedTest(name = "왼쪽 방향은 음수를 의미한다")
    @ValueSource(ints = {-100, -1, 0, 1, 100})
    void 왼쪽_방향은_음수를_의미한다(final int position) {
        // when & then
        assertThat(LEFT.sign(position))
                .isEqualTo(position * -1);
    }

    @ParameterizedTest(name = "오른쪽으로 방향은 양수를 의미한다")
    @ValueSource(ints = {-100, -1, 0, 1, 100})
    void 오른쪽_방향은_양수를_의미한다(final int position) {
        // when & then
        assertThat(RIGHT.sign(position))
                .isEqualTo(position);
    }

    @ParameterizedTest(name = "NONE 방향은 0을 의미한다")
    @ValueSource(ints = {-100, -1, 0, 1, 100})
    void NONE_으로_이동하면_값은_변하지않는다(final int position) {
        // when & then
        assertThat(NONE.sign(position))
                .isEqualTo(0);
    }
}