package domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Position 은")
class PositionTest {

    @ParameterizedTest(name = "임의의 정수(ex: {0})를 받아 생성된다.")
    @ValueSource(ints = {-100, -1, 0, 1, 100})
    void 임의의_정수를_받아_생성된다(final int value) {
        // when
        Position position = Position.of(value);

        // then
        assertThat(position.value())
                .isEqualTo(value);
    }

    @ParameterizedTest(name = "isNegative 는 위치가 음수인 경우(ex: {0}) true 를 반환한다")
    @ValueSource(ints = {-100, -1})
    void isNegative_는_위치가_음수인_경우_true_를_반환한다(final int negativeValue) {
        // given
        Position position = Position.of(negativeValue);

        // when & then
        assertThat(position.isNegative()).isTrue();
    }

    @ParameterizedTest(name = "isNegative 는 위치가 0 혹은 양수인 경우(ex: {0}) false 를 반환한다")
    @ValueSource(ints = {0, 1, 100})
    void isNegative_는_위치가_0_혹은_양수인_경우_false_를_반환한다(final int nonNegativeValue) {
        // given
        Position position = Position.of(nonNegativeValue);

        // when & then
        assertThat(position.isNegative()).isFalse();
    }

    @ParameterizedTest(name = "위치가 동일하면 동등하다")
    @ValueSource(ints = {-100, -1, 0, 1, 100})
    void 위치가_동일하면_동등하다(final int value) {
        // given
        Position position1 = Position.of(value);
        Position position2 = Position.of(value);

        // when & then
        assertThat(position1)
                .isEqualTo(position2);
    }
}