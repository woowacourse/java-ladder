package laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static laddergame.domain.ladder.Connection.CONNECTED;
import static laddergame.domain.ladder.Connection.UNCONNECTED;
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
            final int playerCount = connections.size() + 1;
            final Line line = Line.of(playerCount, new TestConnectionMaker(connections));

            //then
            assertThat(line.getConnections()).containsExactly(CONNECTED, UNCONNECTED, UNCONNECTED);
        }
    }

    @Test
    @DisplayName("라인이 겹치지 않는다.")
    void givenLine_thenNotOverLap() {
        //given
        final List<Connection> connections = createConnections(true, true, false);
        final int expectedPlayerCount = connections.size();
        final Line line = Line.of(expectedPlayerCount, new TestConnectionMaker(connections));

        //then
        assertThat(line.getConnections()).containsExactly(CONNECTED, UNCONNECTED);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, false", "1, true", "2, false"})
    @DisplayName("Line과 Postion이 있고 왼쪽으로 움직일 수 있는지 여부를 확인하는 메서드를 실행하면 그 결과가 반환된다.")
    void givenLineAndPosition_whenCanMoveLeft_thenReturnResult(final int position, boolean result) {
        // given
        final List<Connection> connections = createConnections(true, false);
        final int playerCount = connections.size() + 1;
        final Line line = Line.of(playerCount, new TestConnectionMaker(connections));

        // when
        final boolean canMoveLeft = line.canMoveLeft(position);

        // then
        assertThat(canMoveLeft).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, false", "1, true", "2, false"})
    @DisplayName("Line과 Postion이 있고 오른쪽으로 움직일 수 있는지 여부를 확인하는 메서드를 실행하면 그 결과가 반환된다.")
    void givenLineAndPosition_whenCanMoveRight_thenReturnResult(final int position, boolean result) {
        // given
        final List<Connection> connections = createConnections(false, true);
        final int playerCount = connections.size() + 1;
        final Line line = Line.of(playerCount, new TestConnectionMaker(connections));

        // when
        final boolean canMoveRight = line.canMoveRight(position);

        // then
        assertThat(canMoveRight).isEqualTo(result);
    }

    private List<Connection> createConnections(Boolean... isConnected) {
        final List<Boolean> connections = List.of(isConnected);
        return connections.stream()
                .map(Connection::from)
                .collect(toList());
    }
}
