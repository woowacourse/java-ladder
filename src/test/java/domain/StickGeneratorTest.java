package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StickGeneratorTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Assertions.assertThatCode(() -> new StickGenerator())
                .doesNotThrowAnyException();
    }

    @DisplayName("0을 입력하면 비어있는 막대를 반환한다.")
    @Test
    void generateEmptyStick() {
        StickGenerator stickGenerator = new StickGenerator();

        Stick stick = stickGenerator.generate(0);

        Assertions.assertThat(stick).isEqualTo(Stick.EMPTY);
    }

    @DisplayName("1을 입력하면 채워진 막대를 반환한다.")
    @Test
    void generateFilledStick() {
        StickGenerator stickGenerator = new StickGenerator();

        Stick stick = stickGenerator.generate(1);

        Assertions.assertThat(stick).isEqualTo(Stick.FILLED);
    }

    @DisplayName("0과 1이 아닌 값은 허용하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 2})
    void validateZeroOrOne(int source) {
        StickGenerator stickGenerator = new StickGenerator();

        Assertions.assertThatThrownBy(() -> stickGenerator.generate(source))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
