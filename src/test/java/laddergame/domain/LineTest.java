package laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Nested
    static class LineWidthTest {

        @ParameterizedTest
        @DisplayName("최소 너비가 한 칸 이상이면 Line이 생성된다.")
        @ValueSource(ints = {1, 5, 10})
        void givenOneMoreWidth_thenCreateLine(final int width) {
            assertThatCode(() -> new Line(width))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("너비가 1 미만이면 예외가 발생한다")
        void givenOneLessWidth_thenFail() {
            assertThatThrownBy(() -> new Line(0))
                    .isInstanceOf(IllegalStateException.class);
        }
    }

}
