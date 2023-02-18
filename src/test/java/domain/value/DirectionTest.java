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

    @ParameterizedTest(name = "왼쪽으로 이동하면 값이 1만큼 감소한다")
    @ValueSource(ints = {-100, -1, 0, 1, 100})
    void 왼쪽으로_이동하면_값이_1만큼_감소한다(final int position) {
        // when & then
        assertThat(LEFT.move(position))
                .isEqualTo(position - 1);
    }

    @ParameterizedTest(name = "오른쪽으로 이동하면 값이 1만큼 증가한다")
    @ValueSource(ints = {-100, -1, 0, 1, 100})
    void 오른쪽으로_이동하면_값이_1만큼_증가한다(final int position) {
        // when & then
        assertThat(RIGHT.move(position))
                .isEqualTo(position + 1);
    }

    @ParameterizedTest(name = "NONE 으로 이동하면 값은 변하지않는다")
    @ValueSource(ints = {-100, -1, 0, 1, 100})
    void NONE_으로_이동하면_값은_변하지않는다(final int position) {
        // when & then
        assertThat(NONE.move(position))
                .isEqualTo(position);
    }
}