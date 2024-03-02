package domain.ladder;

import static domain.connection.Connection.DISCONNECTION;
import static domain.connection.Connection.LEFT_CONNECTION;
import static domain.connection.Connection.RIGHT_CONNECTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.ColumnPosition;
import domain.line.Point;
import domain.line.RowLine;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 테스트")
class LadderTest {

    @DisplayName("출발 인덱스를 전달받아 도착 인덱스를 계산할 수 있다")
    @Test
    void testDriveLadder() {
        RowLine line1 = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), DISCONNECTION),
                new Point(new ColumnPosition(3), DISCONNECTION)
        ));

        RowLine line2 = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), RIGHT_CONNECTION),
                new Point(new ColumnPosition(3), LEFT_CONNECTION)
        ));
        List<RowLine> rowLines = List.of(line1, line2);
        Ladder ladder = new Ladder(rowLines);

        assertAll(
                () -> assertThat(ladder.drive(new ColumnPosition(0))).isEqualTo(new ColumnPosition(0)),
                () -> assertThat(ladder.drive(new ColumnPosition(1))).isEqualTo(new ColumnPosition(1)),
                () -> assertThat(ladder.drive(new ColumnPosition(2))).isEqualTo(new ColumnPosition(3)),
                () -> assertThat(ladder.drive(new ColumnPosition(3))).isEqualTo(new ColumnPosition(2))
        );

    }

    @DisplayName("인덱스를 전달받아 해당하는 줄을 반환할 수 있다")
    @Test
    void testGetRowLineByIndex() {
        RowLine line1 = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), DISCONNECTION),
                new Point(new ColumnPosition(3), DISCONNECTION)
        ));

        RowLine line2 = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), RIGHT_CONNECTION),
                new Point(new ColumnPosition(3), LEFT_CONNECTION)
        ));
        List<RowLine> rowLines = List.of(line1, line2);
        Ladder ladder = new Ladder(rowLines);

        assertThat(ladder.getLineByIndex(0)).isEqualTo(line1);
    }

    @DisplayName("줄의 개수를 반환할 수 있다")
    @Test
    void testGetLineCount() {
        RowLine line1 = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), DISCONNECTION),
                new Point(new ColumnPosition(3), DISCONNECTION)
        ));

        RowLine line2 = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), RIGHT_CONNECTION),
                new Point(new ColumnPosition(3), LEFT_CONNECTION)
        ));

        List<RowLine> rowLines = List.of(line1, line2);
        Ladder ladder = new Ladder(rowLines);

        assertThat(ladder.getRowLineCount()).isEqualTo(2);
    }

    @DisplayName("열의 개수를 반환할 수 있다")
    @Test
    void testGetColumnCount() {
        RowLine line1 = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), DISCONNECTION),
                new Point(new ColumnPosition(3), DISCONNECTION)
        ));

        RowLine line2 = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), RIGHT_CONNECTION),
                new Point(new ColumnPosition(3), LEFT_CONNECTION)
        ));
        List<RowLine> rowLines = List.of(line1, line2);
        Ladder ladder = new Ladder(rowLines);

        assertThat(ladder.getColumnCount()).isEqualTo(4);
    }

    @DisplayName("모든 줄이 같은 사이즈를 가져야 생성 검증에 통과한다")
    @Test
    void testCreateLadderWithDifferentSizeLines() {
        RowLine line1 = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), DISCONNECTION),
                new Point(new ColumnPosition(3), DISCONNECTION)
        ));

        RowLine line2 = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), RIGHT_CONNECTION),
                new Point(new ColumnPosition(3), LEFT_CONNECTION)
        ));
        List<RowLine> rowLines = List.of(line1, line2);

        assertThatCode(() -> new Ladder(rowLines)).doesNotThrowAnyException();
    }

    @DisplayName("모든 줄이 같은 사이즈를 가지지 않을 경우 생성 검증에 실패한다")
    @Test
    void testCreateLadderWithSameSizeLines() {
        RowLine line1 = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), DISCONNECTION),
                new Point(new ColumnPosition(3), DISCONNECTION)
        ));

        RowLine line2 = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), RIGHT_CONNECTION)
        ));
        List<RowLine> rowLines = List.of(line1, line2);

        assertThatThrownBy(() -> new Ladder(rowLines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리를 구성하는 줄들의 길이가 같지 않습니다");
    }
}
