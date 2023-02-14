package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightTest {

    @DisplayName("알맞은 사다리 길이를 입력하면 정상적으로 사다리가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {5, 100})
    void create_success(int rightLadderHeight) {
        assertThatNoException().isThrownBy(() -> new LadderHeight(rightLadderHeight));
    }

    @DisplayName("1보다 작은 사다리 길이를 입력하면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0})
    void create_fail(int wrongLadderHeight) {
        assertThatThrownBy(() -> new LadderHeight(wrongLadderHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
}