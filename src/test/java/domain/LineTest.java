package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.AbsentStepGenerator;
import utils.PresentStepGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    @Test
    @DisplayName("한 층이 잘 생성된다.")
    void makeLineTest() {
        Line line = new Line(3, new PresentStepGenerator());

        assertThat(line.getStepPoints()).isEqualTo(List.of(StepPoint.PRESENT, StepPoint.ABSENT, StepPoint.PRESENT));
    }

    @Test
    @DisplayName("해당 위치에 가로 라인이 있는지 확인한다.")
    void isStepExistAtTest() {
        Line line = new Line(3, new PresentStepGenerator());

        assertThat(line.isStepExistAt(1)).isFalse();
    }

    @Test
    @DisplayName("현재 위치를 이용해 이후 위치를 결정한다.")
    void findNextLocationTest1() {
        Line line = new Line(3, new PresentStepGenerator());
        List<Player> players = List.of(
                new Player("a", 0),
                new Player("b", 1),
                new Player("c", 2),
                new Player("d", 3));
        for (Player player : players) {
            line.findNextLocation(player);
        }

        assertAll(() -> assertEquals(players.get(0).getPosition(), new Position(1)),
                () -> assertEquals(players.get(1).getPosition(), new Position(0)),
                () -> assertEquals(players.get(2).getPosition(), new Position(3)),
                () -> assertEquals(players.get(3).getPosition(), new Position(2)));
    }

    @Test
    @DisplayName("현재 위치를 이용해 이후 위치를 결정한다.")
    void findNextLocationTest2() {
        Line line = new Line(3, new AbsentStepGenerator());
        List<Player> players = List.of(
                new Player("a", 0),
                new Player("b", 1),
                new Player("c", 2),
                new Player("d", 3));
        for (Player player : players) {
            line.findNextLocation(player);
        }

        assertAll(() -> assertEquals(players.get(0).getPosition(), new Position(0)),
                () -> assertEquals(players.get(1).getPosition(), new Position(1)),
                () -> assertEquals(players.get(2).getPosition(), new Position(2)),
                () -> assertEquals(players.get(3).getPosition(), new Position(3)));
    }

}
