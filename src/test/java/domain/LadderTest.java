package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.AbsentStepGenerator;
import utils.PresentStepGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderTest {

    @Test
    @DisplayName("층의 개수가 올바르게 생성된다.")
    void ladderHeightTest() {
        int floor = 5;
        Ladder ladder = new Ladder(floor, 3, new RandomStepGenerator());
        int expected = floor;
        int actual = ladder.getLines().size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("칸의 개수가 올바르게 생성된다.")
    void ladderNumberOfCellTest() {
        int participantsCount = 3;
        Ladder ladder = new Ladder(5, participantsCount, new RandomStepGenerator());
        int expected = participantsCount - 1;
        Line firstLine = ladder.getLines().get(0);
        int actual = firstLine.getStepPoints().size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("마지막 위치를 확인한다.")
    void findLastLocationTest1() {
        List<Player> players = List.of(
                new Player("a", 0),
                new Player("b", 1),
                new Player("c", 2),
                new Player("d", 3));
        Ladder ladder = new Ladder(3, players.size(), new PresentStepGenerator());
        for (Player player : players) {
            ladder.findLastLocation(player);
        }

        assertAll(() -> assertEquals(players.get(0).getPosition(), new Position(1)),
                () -> assertEquals(players.get(1).getPosition(), new Position(0)),
                () -> assertEquals(players.get(2).getPosition(), new Position(3)),
                () -> assertEquals(players.get(3).getPosition(), new Position(2)));
    }

    @Test
    @DisplayName("마지막 위치를 확인한다.")
    void findLastLocationTest2() {
        List<Player> players = List.of(
                new Player("a", 0),
                new Player("b", 1),
                new Player("c", 2),
                new Player("d", 3));
        Ladder ladder = new Ladder(3, players.size(), new AbsentStepGenerator());
        for (Player player : players) {
            ladder.findLastLocation(player);
        }

        assertAll(() -> assertEquals(players.get(0).getPosition(), new Position(0)),
                () -> assertEquals(players.get(1).getPosition(), new Position(1)),
                () -> assertEquals(players.get(2).getPosition(), new Position(2)),
                () -> assertEquals(players.get(3).getPosition(), new Position(3)));
    }

}
