package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 20})
    @DisplayName("사다리 높이 생성 성공: 1부터 20까지 가능")
    void test_ok(int height) {
        assertThat(new Height(height).getValue())
                .isEqualTo(height);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 21})
    @DisplayName("사다리 높이 생성 실패: 높이 경계값 -1, 0, 21")
    void test_exception_outOfRange(int height) {
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
