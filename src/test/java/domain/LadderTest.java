package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("다리가 높이와 라인 수를 입력받고, 각 라인들에 높이만큼의 크기를 가진 Point 리스트를 생성한다")
    @Test
    void create_success() {
        Ladder ladder = createLadder(3,3);

        List<Line> lines = ladder.getLines();
        int numberOfPoint = lines.stream()
                .map(Line::getPointSize)
                .collect(Collectors.toSet())
                .size();

        assertThat(numberOfPoint).isEqualTo(1);
    }

    @DisplayName("마지막 라인은 모든 point가 false이다")
    @Test
    void last_line_have_false_only() {
        Ladder ladder = createLadder(3,3);

        List<Line> lines = ladder.getLines();
        List<Point> points = getLastLinePoints(lines);

        assertThat(points).containsExactly(Point.BLOCKED, Point.BLOCKED, Point.BLOCKED);
    }

    private Ladder createLadder(int height, int numberOfLine) {
        LadderHeight ladderHeight = new LadderHeight(height);
        Ladder ladder = Ladder.create(ladderHeight, numberOfLine, new RandomNumberGenerator());
        return ladder;
    }

    private List<Point> getLastLinePoints(List<Line> lines) {
        return lines.get(lines.size() - 1).getPoints();
    }
}
