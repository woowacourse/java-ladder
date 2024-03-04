package model.ladder;

import static model.line.Path.EXIST;
import static model.line.Path.NOT_EXIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.Index;
import model.line.Line;
import model.line.FixedLinesGenerator;
import model.people.PersonCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리를 생성한다.")
    void createLadder() {
        Line line = new Line(List.of(EXIST, NOT_EXIST));
        List<Line> expectedLines = List.of(line);
        FixedLinesGenerator pathGenerator = new FixedLinesGenerator(expectedLines);
        Height height = new Height(1);
        PersonCount personCount = new PersonCount(2);

        Ladder ladder = Ladder.from(height, personCount, pathGenerator);
        assertThat(ladder.getLines()).isEqualTo(expectedLines);
    }

    @Test
    @DisplayName("높이에 맞지 않는 라인의 수가 생성되면 안된다.")
    void createLadderThrowException() {
        Line line1 = new Line(List.of(EXIST, NOT_EXIST));
        Line line2 = new Line(List.of(NOT_EXIST, NOT_EXIST));
        List<Line> expectedLines = List.of(line1, line2);
        FixedLinesGenerator pathGenerator = new FixedLinesGenerator(expectedLines);

        Height height = new Height(1);
        PersonCount personCount = new PersonCount(2);

        assertThatThrownBy(() -> Ladder.from(height, personCount, pathGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이에 맞지 않는 라인의 수가 생성되었습니다.");
    }

    @Test
    @DisplayName("사다리의 개인별 결과를 확인한다.")
    void climbLadderPersonResult() {
        Height height = new Height(5);
        PersonCount personCount = new PersonCount(4);
        FixedLinesGenerator pathGenerator = new FixedLinesGenerator(
                List.of(new Line(List.of(EXIST, NOT_EXIST, EXIST)),
                        new Line(List.of(NOT_EXIST, EXIST, NOT_EXIST)),
                        new Line(List.of(EXIST, NOT_EXIST, NOT_EXIST)),
                        new Line(List.of(NOT_EXIST, EXIST, NOT_EXIST)),
                        new Line(List.of(EXIST, NOT_EXIST, EXIST)))
        );
        Ladder ladder = Ladder.from(height, personCount, pathGenerator);
        Index startIndex = new Index(0);
        assertThat(ladder.climb(startIndex)).isEqualTo(startIndex);
    }

    @Test
    @DisplayName("사다리의 전체 결과를 확인한다.")
    void climbLadderAllResult() {
        Height height = new Height(5);
        PersonCount personCount = new PersonCount(4);
        FixedLinesGenerator pathGenerator = new FixedLinesGenerator(
                List.of(new Line(List.of(EXIST, NOT_EXIST, EXIST)),
                        new Line(List.of(NOT_EXIST, EXIST, NOT_EXIST)),
                        new Line(List.of(EXIST, NOT_EXIST, NOT_EXIST)),
                        new Line(List.of(NOT_EXIST, EXIST, NOT_EXIST)),
                        new Line(List.of(EXIST, NOT_EXIST, EXIST)))
        );
        Ladder ladder = Ladder.from(height, personCount, pathGenerator);
        assertThat(ladder.climbAll()).isEqualTo(List.of(new Index(0), new Index(3), new Index(2), new Index(1)));
    }
}
