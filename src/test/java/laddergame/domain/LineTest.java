package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Nested
    static class LineWidthTest {

        @ParameterizedTest
        @DisplayName("최소 너비가 한 칸 이상이면 Line이 생성된다.")
        @ValueSource(ints = {1, 5, 10})
        void givenOneMoreWidth_thenCreateLine(final int width) {
            assertThatCode(() -> Line.from(width))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("너비가 1 미만이면 예외가 발생한다")
        void givenOneLessWidth_thenFail() {
            assertThatThrownBy(() -> Line.from(0))
                    .isInstanceOf(IllegalStateException.class);
        }

        @Test
        @DisplayName("라인이 생성되면 List<Boolean>이 생성된다.")
        void givenLine_thenCreateBooleanList() {
            //given
            final List<Boolean> booleans = List.of(true, false, false);
            final Line line = Line.of(3, new TestBooleanPicker(booleans));

            //then
            assertThat(line)
                    .extracting("statuses")
                    .isEqualTo(List.of(true, false));
        }
    }

    @Test
    @DisplayName("라인이 겹치지 않는다.")
    void givenLine_thenNotOverLap() {
        //given
        final List<Boolean> booleans = List.of(true, true, false);
        final Line line = Line.of(3, new TestBooleanPicker(booleans));

        //then
        assertThat(line)
                .extracting("statuses")
                .isEqualTo(List.of(true, false));
    }
}
