package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class HeightTest {
    @Test
    @DisplayName("사다리 높이가 2 미만이면 예외처리 테스트")
    void invalidHeightTest() {
        Assertions.assertThatThrownBy(() -> new Height(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 높이가 2 이상이면 통과하는 테스트")
    void validHeightTest() {
        assertThatCode(() -> new Height(2)).doesNotThrowAnyException();
    }

}