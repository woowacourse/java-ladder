package laddergame.domain.ladder;

import laddergame.domain.connectiongenerator.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RowLineTest {

    @DisplayName("연속된 가로선이 있는 domain.RowLine 객체는 생성되지 않는다")
    @Test
    void successiveRowLineTest() {
        ConnectionGenerator successiveConnectionGenerator = new AllTrueConnectionGenerator();
        assertThrows(IllegalArgumentException.class
                , () -> new RowLine(5, successiveConnectionGenerator));
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
    void rowLineNonmovingTest() {
        RowLine rowLine = new RowLine(5, new AllFalseConnectionGenerator());
        List<Integer> positions = IntStream.range(0, 5).boxed().toList();
        List<Integer> expectedPositions = IntStream.range(0, 5).boxed().toList();
        List<Integer> actualPositions = rowLine.move(positions);

        assertThat(expectedPositions)
                .containsExactlyElementsOf(actualPositions);
    }

    @DisplayName("사다리 연결상태에 따라 position이 좌우로 이동한다.")
    @Test
    void rowLinemovingTest2() {
        RowLine rowLine = new RowLine(5, new TrueFalseConnectionGenerator());
        List<Integer> positions = IntStream.range(0, 5).boxed().toList();
        List<Integer> expectedPositions = Stream.of(1, 0, 3, 2, 4).toList();
        List<Integer> actualPositions = rowLine.move(positions);

        assertThat(actualPositions)
                .containsExactlyElementsOf(expectedPositions);
    }
}
