package domain.result;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("상품은")
class PrizeTest {
    @Nested
    @DisplayName("생성 시")
    class GenerateTest {
        @ParameterizedTest
        @DisplayName("길이가 1 이상 5 이하이면 정상 생성된다.")
        @ValueSource(strings = {"꽝", "5000", "500"})
        void validGenerateTest(final String prizeName) {
            assertDoesNotThrow(() -> new Prize(prizeName));
        }

        @ParameterizedTest
        @DisplayName("길이가 1 미만 5 초과이면 익셉션이 발생한다.")
        @ValueSource(strings = {"", "500000", "111111"})
        void invalidGenerateTest(final String prizeName) {
            assertThatThrownBy(() -> new Prize((prizeName)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
