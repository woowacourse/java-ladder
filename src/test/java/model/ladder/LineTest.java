package model.ladder;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static model.ladder.StepStatus.CONNECTED;
import static model.ladder.StepStatus.DISCONNECTED;

import java.util.Arrays;
import model.ladder.generator.AlwaysConnectStatusGenerator;
import model.ladder.generator.AlwaysDisconnectStatusGenerator;
import model.laddergame.Direction;
import model.players.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 *     |-----|     |-----|
 */
class LineTest {

    @DisplayName("사다리의 한 라인을 생성한다.")
    @Test
    void createLine() {
        Line actual = Line.from(new Width(3), new AlwaysConnectStatusGenerator());
        Line expected = createLine(CONNECTED, DISCONNECTED, CONNECTED);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private Line createLine(StepStatus... stepStatuses) {
        return Arrays.asList(stepStatuses)
                .stream()
                .map(Step::from)
                .collect(collectingAndThen(toList(), Line::new));
    }

    @DisplayName("오른쪽으로 연결되어있는 지점인 경우 오른쪽 방향을 반환한다.")
    @Test
    void findRightDirection() {
        Line line = Line.from(new Width(3), new AlwaysConnectStatusGenerator());
        Direction direction = line.getDirection(new Position(2));
        Assertions.assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("왼쪽으로 연결되어있는 지점인 경우 왼쪽 방향을 반환한다.")
    @Test
    void findLeftDirection() {
        Line line = Line.from(new Width(3), new AlwaysConnectStatusGenerator());
        Direction direction = line.getDirection(new Position(1));
        Assertions.assertThat(direction).isEqualTo(Direction.LEFT);
    }

    @DisplayName("아무것도 연결되어있지 않은 지점인 경우 직진 방향을 반환한다.")
    @Test
    void findStraightDirection() {
        Line line = Line.from(new Width(3), new AlwaysDisconnectStatusGenerator());
        Direction direction = line.getDirection(new Position(1));
        Assertions.assertThat(direction).isEqualTo(Direction.STRAIGHT);
    }
}
