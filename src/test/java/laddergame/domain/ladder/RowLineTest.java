package laddergame.domain.ladder;

import laddergame.domain.Position;
import laddergame.domain.connectiongenerator.*;
import laddergame.domain.gameelements.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RowLineTest {

    @DisplayName("연속된 가로선이 있는 domain.RowLine 객체는 생성되지 않는다")
    @Test
    void successiveRowLineTest() {
        ConnectionGenerator successiveConnectionGenerator = new AllTrueConnectionGenerator();

        assertThatThrownBy(() -> new RowLine(5, successiveConnectionGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 가로선이 연속되었습니다.");

    }

    @DisplayName("연속된 가로선이 없는 domain.RowLine 객체는 생성할 수 있다")
    @Test
    void unsuccessiveRowLineTest() {
        ConnectionGenerator unsuccesivelineGenerator = new RandomConnectionGenerator();
        assertDoesNotThrow(
                () -> new RowLine(5, unsuccesivelineGenerator));

    }

    @DisplayName("참여자의 수가 n일 때, RowLine의 connection 길이는 n-1이다")
    @ParameterizedTest
    @ValueSource(ints = {100, 1, 2})
    void rowLineConnectionSizeTest(int n) {
        List<Connection> connection = new RowLine(n, new RandomConnectionGenerator()).getConnections();
        assertThat(connection).hasSize(n - 1);
    }

    @DisplayName("사다리가 연결되어 있지 않으면 position은 이동하지 않는다.")
    @Test
    void rowLineNonmovingTest2() {
        RowLine rowLine = new RowLine(5, new AllFalseConnectionGenerator());
        Players testPlayers = new Players(List.of("0", "1", "2", "3", "4"));

        List<Position> expectedPositions = IntStream.range(0, 5)
                .mapToObj(Position::new)
                .toList();

        rowLine.move(testPlayers);
        List<Position> actualPositions = testPlayers.getPlayers()
                .stream()
                .map(i -> i.getPlayerPosition())
                .toList();

        assertThat(expectedPositions)
                .containsExactlyElementsOf(actualPositions);
    }


    @DisplayName("사다리 연결상태에 따라 position이 좌우로 이동한다.")
    @Test
    void rowLinemoving2Test() {
        RowLine rowLine = new RowLine(5, new TrueFalseConnectionGenerator());


        Players testPlayers = new Players(List.of("0", "1", "2", "3", "4"));
        List<Position> expectedPositions = Stream.of(1, 0, 3, 2, 4)
                .map(Position::new)
                .toList();

        rowLine.move(testPlayers);
        List<Position> actualPositions = testPlayers.getPlayers()
                .stream()
                .map(i -> i.getPlayerPosition())
                .toList();

        assertThat(expectedPositions)
                .containsExactlyElementsOf(actualPositions);
    }
}
