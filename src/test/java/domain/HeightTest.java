package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("높이 도메인 테스트")
public class HeightTest {

    @DisplayName("사다리 높이가 0 이하면 생성 검증에 실패한다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void testCreateHeightWithInvalidRange(int value) {
        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 높이는 1 이상이어야 합니다");
    }

    @DisplayName("사다리 높이가 1 이상이면 생성 검증에 성공한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testCreateHeightWithValidRange(int value) {
        assertThatCode(() -> new Height(value))
                .doesNotThrowAnyException();
    }
}
