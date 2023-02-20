package laddergame.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static laddergame.domain.Connection.*;
import static org.assertj.core.api.Assertions.*;

public class LineTest {

    private static PickStrategy randomPicker;

    @BeforeAll
    static void setUp() {
        randomPicker = new RandomBooleanPicker();
    }

    @Nested
    class LineConnectionsTest {

        @ParameterizedTest
        @DisplayName("Players가 두 명 이상이면 Line이 생성된다.")
        @ValueSource(ints = {2, 5, 10})
        void givenTwoMorePlayers_thenCreateLine(final int numberOfPlayers) {
            assertThatCode(() -> Line.of(numberOfPlayers, randomPicker))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("Player가 2명 미만이면 예외가 발생한다")
        void givenTwoLessPlayers_thenFail() {
            assertThatThrownBy(() -> Line.of(1, randomPicker))
                    .isInstanceOf(IllegalStateException.class);
        }

        @Test
        @DisplayName("라인이 생성되면 List<Boolean>이 생성된다.")
        void givenLine_thenCreateBooleanList() {
            //given
            final List<Boolean> connections = List.of(true, false, false);
            final Line line = Line.of(connections.size(), new TestBooleanPicker(connections));

            //then
            assertThat(line.getConnections())
                    .containsExactly(CONNECTED, UNCONNECTED);
        }
    }

    @Test
    @DisplayName("라인이 겹치지 않는다.")
    void givenLine_thenNotOverLap() {
        //given
        final List<Boolean> connections = List.of(true, true, false);
        final Line line = Line.of(connections.size(), new TestBooleanPicker(connections));

        //then
        assertThat(line.getConnections())
                .containsExactly(CONNECTED, UNCONNECTED);
    }
}
