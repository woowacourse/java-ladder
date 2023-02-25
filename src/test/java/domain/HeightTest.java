package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import domain.ladder.Height;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @Nested
    @DisplayName("사다리의 높이를 생성한다.")
    class createHeightTest {
        @DisplayName("1 이상 100 이하의 값이 들어오면 사다리를 정상 생성한다.")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 99, 100})
        void validHeightTest(int height) {
            Assertions.assertDoesNotThrow(() -> new Height(height));
        }

        @DisplayName("1 미만 100 초과의 값은 사다리를 생성할 수 없다.")
        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 101, 102})
        void invalidHeightTest(int height) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Height(height));
        }
    }

    @Nested
    @DisplayName("높이 값을 반환할 수 있다.")
    class returnHeightTest {
        @DisplayName("생성된 사다리의 값을 반환할 수 있다.")
        @Test
        void returnValueTest() {
            Height height = new Height(5);
            assertThat(height.getHeight()).isEqualTo(5);
        }
    }
}
