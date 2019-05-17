package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @Test
    void initTestSame() {
        List<Player> expected = Arrays.asList(new Player("A", "1"), new Player("B", "2"), new Player("C", "3"));
        List<Player> actual = new Game(Arrays.asList("A", "B", "C"), Arrays.asList("1", "2", "3"), 6).getPlayers();
        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i).toString()).isEqualTo(expected.get(i).toString());
        }
    }

    @Test
    void initTestMorePeople() {
        List<Player> expected = Arrays.asList(new Player("A", "1"), new Player("B", "2"), new Player("C", Game.NIL));
        List<Player> actual = new Game(
            new ArrayList<>(Arrays.asList("A", "B", "C")),
            new ArrayList<>(Arrays.asList("1", "2")),
            8
        ).getPlayers();
        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i).toString()).isEqualTo(expected.get(i).toString());
        }
    }

    @Test
    void initTestLessPeople() {
        List<Player> expected = Arrays.asList(new Player("A", "2"), new Player("B", "3"));
        List<Player> actual = new Game(
            new ArrayList<>(Arrays.asList("A", "B")),
            new ArrayList<>(Arrays.asList("1", "2", "3")),
            252
        ).getPlayers();
        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i).toString()).isEqualTo(expected.get(i).toString());
        }
    }
}