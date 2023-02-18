package domain.value;

import domain.value.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Height 는")
class HeightTest {

    @ParameterizedTest(name = "높이는 1 이상이어야 한다")
    @ValueSource(ints = {-100, -1, 0})
    void 높이는_1_이상이어야_한다(final int notNaturalNumber) {
        // when & then
        assertThatThrownBy(() -> Height.of(notNaturalNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "생성될 때 전달받은 값을 가진다")
    @ValueSource(ints = {1, 10, 50, 100})
    void 생성될_때_전달받은_값을_가진다(final int number) {
        // given
        Height height = Height.of(number);

        // when
        int value = height.value();

        // then
        assertThat(value).isEqualTo(number);
    }

    @ParameterizedTest(name = "값이 같으면 동등하다")
    @ValueSource(ints = {1, 10, 50, 100})
    void 값이_같으면_동등하다(final int number) {
        // given
        Height height1 = Height.of(number);
        Height height2 = Height.of(number);

        // when & then
        assertThat(height1).isEqualTo(height2);
    }
}