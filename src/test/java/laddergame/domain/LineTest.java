package laddergame.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static laddergame.domain.Connection.CONNECTED;
import static laddergame.domain.Connection.UNCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    private static ConnectionStrategy randomPicker;

    @BeforeAll
    static void setUp() {
        randomPicker = new RandomLineMaker();
    }

    @Nested
    class LineConnectionsTest {

        @ParameterizedTest
        @DisplayName("Players가 두 명 이상이면 Line이 생성된다.")
        @ValueSource(ints = {2, 5, 10})
        void givenTwoMorePlayers_thenCreateLine(final int numberOfPlayers) {
            assertThatCode(() -> Line.of(numberOfPlayers, randomPicker)).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("Player가 2명 미만이면 예외가 발생한다")
        void givenTwoLessPlayers_thenFail() {
            assertThatThrownBy(() -> Line.of(1, randomPicker)).isInstanceOf(IllegalStateException.class);
        }

        @Test
        @DisplayName("라인이 생성되면 List<Boolean>이 생성된다.")
        void givenLine_thenCreateBooleanList() {
            //given
            final List<Connection> connections = createConnections(true, false, false);
            final Line line = Line.of(connections.size(), new TestConnectionMaker(connections));

            //then
            assertThat(line.getConnections()).containsExactly(CONNECTED, UNCONNECTED);
        }
    }

    @Test
    @DisplayName("라인이 겹치지 않는다.")
    void givenLine_thenNotOverLap() {
        //given
        final List<Connection> connections = createConnections(true, true, false);
        final Line line = Line.of(connections.size(), new TestConnectionMaker(connections));

        //then
        assertThat(line.getConnections()).containsExactly(CONNECTED, UNCONNECTED);
    }

    private List<Connection> createConnections(Boolean... isConnected) {
        final List<Boolean> connections = List.of(isConnected);
        return connections.stream().map(Connection::from).collect(Collectors.toList());
    }
}
