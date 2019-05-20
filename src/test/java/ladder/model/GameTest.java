package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    List<Player> expected = new ArrayList<>();
    List<Player> actual;

    void forTest() {
        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i).toString())
                    .isEqualTo(expected.get(i).toString());
        }
    }

    @Test
    void initTestSame() {
        expected.add(new Player("A", "1"));
        expected.add(new Player("B", "2"));
        expected.add(new Player("C", "3"));
        actual = new Game(
                Arrays.asList("A", "B", "C"),
                Arrays.asList("1", "2", "3"),
                6
        ).getPlayers();
        forTest();
    }

    @Test
    void initTestMorePeople() {
        expected.add(new Player("A", "1"));
        expected.add(new Player("B", "2"));
        expected.add(new Player("C", Game.NIL));
        actual = new Game(
                new ArrayList<>(Arrays.asList("A", "B", "C")),
                new ArrayList<>(Arrays.asList("1", "2")),
                8
        ).getPlayers();
        forTest();
    }

    @Test
    void initTestLessPeople() {
        expected.add(new Player("A", "2"));
        expected.add(new Player("B", "3"));
        actual = new Game(
                new ArrayList<>(Arrays.asList("A", "B")),
                new ArrayList<>(Arrays.asList("1", "2", "3")),
                252
        ).getPlayers();
        forTest();
    }
}