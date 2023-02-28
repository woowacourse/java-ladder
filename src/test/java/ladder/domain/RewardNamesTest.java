package ladder.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RewardNamesTest {

    @Test
    void 입력개수_검증_실패() {
        Assertions.assertThatThrownBy(
                () -> new Names("aaa,aaa,aaa,aaa", 3))
            .hasMessage("입력하는 이름의 개수는 3와 같아야 합니다.(입력된 이름의 수 : 4)")
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력개수_검증_성공() {
        assertDoesNotThrow(() -> new Names("aaa,aaa,aaa", 3));
    }

}
