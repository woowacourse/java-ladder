package laddergame.model.people;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {
    @Test
    @DisplayName("앞 뒤의 공백이 있는 문자열이 입력되면 공백 제거 테스트")
    void Should_Trim_When_FrontAndBackBlank() {
        assertThat(new Prize(" 1000 ").getPrize()).isEqualTo("1000");
    }

    @Nested
    @DisplayName("공백 제거 후 문자열의 길이 범위 테스트")
    class Range {
        @ParameterizedTest(name = "{displayName} [{index}] ==> prize : ''{0}''")
        @ValueSource(strings = {" 200000", "100000", " ", ""})
        @DisplayName("예외 발생")
        void Should_ThrowException_When_OutOfRange(String prize) {
            assertThatThrownBy(() -> new Prize(prize));
        }

        @ParameterizedTest(name = "{displayName} [{index}] ==> prize : ''{0}''")
        @ValueSource(strings = {" 1000 ", "1000", "1"})
        @DisplayName("성공")
        void Should_Success_When_InRange(String prize) {
            assertDoesNotThrow(() -> new Prize(prize));
        }
    }
}
