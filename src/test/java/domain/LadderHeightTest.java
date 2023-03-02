package domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderHeightTest {


    @ParameterizedTest(name = "알맞은 사다리 길이를 입력하면 정상적으로 사다리가 생성된다. 입력 : {0}")
    @ValueSource(ints = {5, 100})
    void create_success(int rightLadderHeight) {
        assertThatNoException().isThrownBy(() -> new LadderHeight(rightLadderHeight, 3));
    }

    @ParameterizedTest(name = "(참여할 사람 수 - 1) 보다 작은 사다리 길이를 입력하면 예외를 반환한다. 입력 : {0}")
    @ValueSource(ints = {-100, -1, 1})
    void create_fail(int wrongLadderHeight) {
        assertThatThrownBy(() -> new LadderHeight(wrongLadderHeight, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 (참여할 사람 수 - 1) 보다 커야합니다.");
    }
}
