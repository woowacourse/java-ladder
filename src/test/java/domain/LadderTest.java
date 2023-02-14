package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("다리가 높이와 라인 수를 입력받고, 각 라인들에 높이만큼의 크기를 가진 Boolean 리스트를 생성한다")
    @Test
    void create_success() {
        LadderHeight ladderHeight = new LadderHeight(3);
        int numberOfLine = 3;
        Ladder ladder = Ladder.create(ladderHeight, numberOfLine, new RandomNumberGenerator());
        List<Line> lines = ladder.getLines();
        assertThat(lines.stream().map(Line::getPointSize).collect(Collectors.toSet()).size()).isEqualTo(1);
    }

    @DisplayName("마지막 라인은 모든 point가 false이다")
    @Test
    void last_line_have_false_only() {
        LadderHeight ladderHeight = new LadderHeight(3);
        int numberOfLine = 3;
        Ladder ladder = Ladder.create(ladderHeight, numberOfLine, new RandomNumberGenerator());
        List<Line> lines = ladder.getLines();
        assertThat(lines.get(lines.size() - 1).getPoints())
                .containsExactly(Point.BLOCKED, Point.BLOCKED, Point.BLOCKED);
    }
}