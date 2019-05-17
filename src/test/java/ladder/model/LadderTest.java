package ladder.model;

import ladder.model.Coin.Always;
import ladder.model.Coin.EvenOnly;
import ladder.model.Coin.Never;
import ladder.model.Coin.OddOnly;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void initTestA() {
        Ladder ladderA = new Ladder(10, 6, new Always());
        ladderA.getLevels().forEach(l ->
            assertThat(new Level(ladderA.getWidth() - 1, new Always()).getVerticalLines()).isEqualTo(l.getVerticalLines())
        );
    }

    @Test
    void initTestN() {
        Ladder ladderN = new Ladder(11, 7, new Never());
        ladderN.getLevels().forEach(l ->
            assertThat(new Level(ladderN.getWidth() - 1, new Never()).getVerticalLines()).isEqualTo(l.getVerticalLines())
        );
    }

    @Test
    void initTestO() {
        OddOnly odd = new OddOnly();
        Ladder ladderO = new Ladder(7, 123, new OddOnly());
        ladderO.getLevels().forEach(l ->
            assertThat(new Level(ladderO.getWidth() - 1, odd).getVerticalLines()).isEqualTo(l.getVerticalLines())
        );
    }

    @Test
    void initTestE() {
        EvenOnly even = new EvenOnly();
        Ladder ladderE = new Ladder(117, 2, new EvenOnly());
        ladderE.getLevels().forEach(l ->
            assertThat(new Level(ladderE.getWidth() - 1, even).getVerticalLines()).isEqualTo(l.getVerticalLines())
        );
    }

    @Test
    void applyTestA() {
        List<Player> players = Arrays.asList(
            new Player("A", "1"),
            new Player("B", "2"),
            new Player("C", "3"),
            new Player("D", "4"),
            new Player("E", "5")
        );
        List<Player> expected = Arrays.asList(
            new Player("A", "2"),
            new Player("B", "1"),
            new Player("C", "4"),
            new Player("D", "3"),
            new Player("E", "5")
        );
        Ladder ladderA = new Ladder(players.size(), 11, new Always());
        List<Player> actual = ladderA.apply(players);
        for (int i = 0; i < players.size(); i++) {
            assertThat(actual.get(i).toString()).isEqualTo(expected.get(i).toString());
        }
    }

    @Test
    void applyTestN() {
        List<Player> players = Arrays.asList(
                new Player("A", "1"),
                new Player("B", "2"),
                new Player("C", "3"),
                new Player("D", "4"),
                new Player("E", "5")
        );
        List<Player> expected = Arrays.asList(
                new Player("A", "1"),
                new Player("B", "2"),
                new Player("C", "3"),
                new Player("D", "4"),
                new Player("E", "5")
        );
        Ladder ladderN = new Ladder(players.size(), 9, new Never());
        List<Player> actual = ladderN.apply(players);
        for (int i = 0; i < players.size(); i++) {
            assertThat(actual.get(i).toString()).isEqualTo(expected.get(i).toString());
        }
    }

    @Test
    void applyTestO() {
        List<Player> players = Arrays.asList(
            new Player("A", "1"),
            new Player("B", "2"),
            new Player("C", "3"),
            new Player("D", "4"),
            new Player("E", "5"),
            new Player("F", "6")
        );
        List<Player> expected = Arrays.asList(
            new Player("A", "2"),
            new Player("B", "1"),
            new Player("C", "3"),
            new Player("D", "5"),
            new Player("E", "4"),
            new Player("F", "6")
        );
        Ladder ladderO = new Ladder(players.size(), 15, new OddOnly());
        List<Player> actual = ladderO.apply(players);
        for (int i = 0; i < players.size(); i++) {
            assertThat(actual.get(i).toString()).isEqualTo(expected.get(i).toString());
        }
    }

    @Test
    void applyTestE() {
        List<Player> players = Arrays.asList(
            new Player("A", "1"),
            new Player("B", "2"),
            new Player("C", "3"),
            new Player("D", "4"),
            new Player("E", "5")
        );
        List<Player> expected = Arrays.asList(
            new Player("A", "1"),
            new Player("B", "3"),
            new Player("C", "2"),
            new Player("D", "4"),
            new Player("E", "5")
        );
        Ladder ladderE = new Ladder(players.size(), 271, new EvenOnly());
        List<Player> actual = ladderE.apply(players);
        for (int i = 0; i < players.size(); i++) {
            assertThat(actual.get(i).toString()).isEqualTo(expected.get(i).toString());
        }
    }
}