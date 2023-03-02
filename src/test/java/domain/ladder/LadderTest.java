package domain.ladder;

import static domain.ladder.Direction.DOWN;
import static domain.ladder.Direction.LEFT;
import static domain.ladder.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import domain.player.Name;
import domain.player.Player;
import domain.player.Position;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

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
        Ladder ladder = new Ladder(createLines());
        Position position = new Position(startPosition);
        Player player = new Player(new Name("name"), position);
        // when
        ladder.play(player);
        Position actualPosition = player.getPosition();
        // then
        assertThat(actualPosition).isEqualTo(new Position(expectedPosition));
    }

    private List<Line> createLines() {
        return List.of(
                createLine(RIGHT, LEFT, RIGHT, LEFT, DOWN),
                createLine(DOWN, RIGHT, LEFT, RIGHT, LEFT),
                createLine(DOWN, RIGHT, LEFT, RIGHT, LEFT),
                createLine(DOWN, RIGHT, LEFT, RIGHT, LEFT)
        );
    }

    private Line createLine(Direction... directions) {
        List<LinePoint> points = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            points.add(new LinePoint(directions[i], new Position(i + 1)));
        }
        return new Line(points);
    }

}
