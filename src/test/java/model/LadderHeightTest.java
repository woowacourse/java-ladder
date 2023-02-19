package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderHeightTest {
    private static final String MINIMUM_LADDER_HEIGHT_ERROR = "[ERROR] 사다리 높이는 최소 1 이상의 값을 입력해야 합니다.";

    @Test
    @DisplayName("LadderHeight 객체 생성 성공 테스트")
    void createLadderHeightTest() {
        Assertions.assertThatNoException().isThrownBy(() -> new LadderHeight(5));
    }

    @Test
    @DisplayName("LadderHeight가 1 미만일 경우 실패 테스트")
    void validateLadderHeightTest() {
        assertThatThrownBy(() -> new LadderHeight(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MINIMUM_LADDER_HEIGHT_ERROR);
    }

    @Test
    @Disabled("단순 getter 메서드는 테스트하지 않는다.")
    void getHeight() {
    }
}
