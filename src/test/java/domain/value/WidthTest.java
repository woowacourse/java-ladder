package domain.value;

import domain.value.Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Width 는")
class WidthTest {

    @ParameterizedTest(name = "너비는 1 이상이어야 한다")
    @ValueSource(ints = {-100, -1, 0})
    void 너비는_1_이상이어야_한다(final int notNaturalNumber) {
        // when & then
        assertThatThrownBy(() -> Width.of(notNaturalNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "생성될 때 전달받은 값을 가진다")
    @ValueSource(ints = {1, 10, 50, 100})
    void 생성될_때_전달받은_값을_가진다(final int number) {
        // given
        Width width = Width.of(number);

        // when
        int value = width.value();

        // then
        assertThat(value).isEqualTo(number);
    }

    @ParameterizedTest(name = "값이 같으면 동등하다")
    @ValueSource(ints = {1, 10, 50, 100})
    void 값이_같으면_동등하다(final int number) {
        // given
        Width width1 = Width.of(number);
        Width width2 = Width.of(number);

        // when & then
        assertThat(width1).isEqualTo(width2);
    }
}