package domain.ladder;

import static domain.ladder.LinePoint.BLOCKED;
import static domain.ladder.LinePoint.PASSABLE;
import static org.assertj.core.api.Assertions.assertThat;

import domain.player.Position;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    //TODO 검증할것이 Player와 똑같다.
    /**
     * |-----|     |-----|     |
     * |     |-----|     |-----|
     * |     |-----|     |-----|
     * |     |-----|     |-----|
     */
    @DisplayName("play()를 통해 게임 결과에 맞는 positon을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:1", "3:5", "4:2", "5:4"}, delimiter = ':')
    void move_result_test(int startPosition, int expectedPosition) {
        // given
        Ladder ladder = new Ladder(createLine());
        Position position = new Position(startPosition);
        // when
        Position actualPosition = ladder.play(position);
        // then
        assertThat(actualPosition).isEqualTo(new Position(expectedPosition));
    }

    private List<Line> createLine() {
        return List.of(
                new Line(List.of(PASSABLE, BLOCKED, PASSABLE, BLOCKED)),
                new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)),
                new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)),
                new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)));
    }

}
