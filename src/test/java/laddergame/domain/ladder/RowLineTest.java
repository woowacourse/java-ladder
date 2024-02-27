package laddergame.domain.ladder;

import laddergame.domain.connectiongenerator.AllTrueConnectionGenerator;
import laddergame.domain.connectiongenerator.ConnectionGenerator;
import laddergame.domain.connectiongenerator.RandomConnectionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
