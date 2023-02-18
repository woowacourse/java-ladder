package domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderHeightTest {

    @DisplayName("알맞은 사다리 길이를 입력하면 정상적으로 사다리가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {5, 100})
    void create_success(int rightHeight) {
        assertThatNoException().isThrownBy(() -> new LadderHeight(rightHeight));
    }

    @DisplayName("1보다 작은 사다리 길이를 입력하면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0})
    void create_fail(int wrongHeight) {
        assertThatThrownBy(() -> new LadderHeight(wrongHeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리 길이는 양수여야합니다.");
    }
}
