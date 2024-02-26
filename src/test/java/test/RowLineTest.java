package test;

import ladder.domain.PositionRow;
import ladder.domain.RowLine;
import ladder.domain.linegenerator.LineGenerator;
import ladder.domain.linegenerator.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.linegenerator.AlternativeLineGenerator;
import test.linegenerator.SuccessiveLineGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RowLineTest {
    @DisplayName("peopleNumber가 1이상 100이하가 아닐 때, domain.RowLine 객체를 생성할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101})
    void peopleNumbersInvalidInput(int peopleNumber) {
        LineGenerator unsuccesivelineGenerator = new RandomLineGenerator();
        assertThrows(IllegalArgumentException.class
                , () -> {
                    new RowLine(peopleNumber, unsuccesivelineGenerator);
                });
    }

    @DisplayName("peopleNumber가 1이상 100이하일 때, domain.RowLine 객체를 생성할 수 있다")
    @Test
    void peopleNumbersValidInput() {
        assertDoesNotThrow(
                () -> {
                    new RowLine(100, new RandomLineGenerator());
                });
    }

    @DisplayName("연속된 가로선이 있는 domain.RowLine 객체는 생성되지 않는다")
    @Test
    void successiveRowLineTest() {
        LineGenerator successiveLineGenerator = new SuccessiveLineGenerator();
        assertThrows(IllegalArgumentException.class
                , () -> {
                    new RowLine(5, successiveLineGenerator);
                });
    }

    @DisplayName("연속된 가로선이 없는 domain.RowLine 객체는 생성할 수 있다")
    @Test
    void unsuccessiveRowLineTest() {
        LineGenerator unsuccesivelineGenerator = new RandomLineGenerator();
        assertDoesNotThrow(
                () -> {
                    new RowLine(5, unsuccesivelineGenerator);
                });
    }

    @DisplayName("참여자의 수가 n일 때, RowLine의 connection 길이는 n-1이다")
    @ParameterizedTest
    @ValueSource(ints = {100, 1, 2})
    void rowLineConnectionSizeTest(int n) {
        List<Boolean> connection = new RowLine(n, new RandomLineGenerator()).getConnection();
        assertThat(connection).hasSize(n - 1);
    }

    @DisplayName("RowLine의 상태에 따라 PositionRow 객체를 움직일 수 있다")
    @Test
    void movePositionRowTest() {
        int start = 0;
        int peopleNumber = 5;
        RowLine rowLine = new RowLine(peopleNumber - 1,
                new AlternativeLineGenerator());
        PositionRow positionRow = new PositionRow(start, peopleNumber);

        rowLine.move(positionRow);
        assertThat(positionRow.getPosition()).isEqualTo(start + 1);
        rowLine.move(positionRow);
        assertThat(positionRow.getPosition()).isEqualTo(start);
    }
}
