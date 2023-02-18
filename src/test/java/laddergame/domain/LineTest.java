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
    static class LineStatusTest {

        @ParameterizedTest
        @DisplayName("Players가 두 명 이상이면 Line이 생성된다.")
        @ValueSource(ints = {2, 5, 10})
        void givenTwoMorePlayers_thenCreateLine(final int numberOfPlayers) {
            assertThatCode(() -> Line.from(numberOfPlayers))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("Player가 2명 미만이면 예외가 발생한다")
        void givenTwoLessPlayers_thenFail() {
            assertThatThrownBy(() -> Line.from(1))
                    .isInstanceOf(IllegalStateException.class);
        }

        @Test
        @DisplayName("라인이 생성되면 List<Boolean>이 생성된다.")
        void givenLine_thenCreateBooleanList() {
            //given
            final List<Boolean> statuses = List.of(true, false, false);
            
            //when
            final Line line = Line.of(statuses.size(), new TestBooleanPicker(statuses));

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
        final List<Boolean> statuses = List.of(true, true, false);
        final Line line = Line.of(statuses.size(), new TestBooleanPicker(statuses));

        //then
        assertThat(line)
                .extracting("statuses")
                .isEqualTo(List.of(true, false));
    }
}
