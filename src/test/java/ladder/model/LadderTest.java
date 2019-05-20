package ladder.model;

import ladder.model.coin.Always;
import ladder.model.coin.EvenOnly;
import ladder.model.coin.Never;
import ladder.model.coin.OddOnly;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    Ladder ladder;
    List<Player> players;
    List<Player> expected;
    List<Player> actual;

    void forTest() {
        for (int i = 0; i < players.size(); i++) {
            assertThat(actual.get(i).toString())
                    .isEqualTo(expected.get(i).toString());
        }
    }

    @Test
    void initTestA() {
        ladder = new Ladder(10, 6, new Always());
        ladder
                .getLevels()
                .forEach(l -> assertThat(new Level(ladder.getWidth() - 1, new Always()).getLines())
                        .isEqualTo(l.getLines()));
    }

    @Test
    void initTestN() {
        ladder = new Ladder(11, 7, new Never());
        ladder
                .getLevels()
                .forEach(l -> assertThat(new Level(ladder.getWidth() - 1, new Never()).getLines())
                        .isEqualTo(l.getLines()));
    }

    @Test
    void initTestO() {
        OddOnly odd = new OddOnly();
        ladder = new Ladder(7, 123, new OddOnly());
        ladder
                .getLevels()
                .forEach(l -> assertThat(new Level(ladder.getWidth() - 1, odd).getLines())
                        .isEqualTo(l.getLines()));
    }

    @Test
    void initTestE() {
        EvenOnly even = new EvenOnly();
        ladder = new Ladder(117, 2, new EvenOnly());
        ladder
                .getLevels()
                .forEach(l -> assertThat(new Level(ladder.getWidth() - 1, even).getLines())
                        .isEqualTo(l.getLines()));
    }

    @Test
    void applyTestA() {
        players = Arrays.asList(
                new Player("A", "1"),
                new Player("B", "2"),
                new Player("C", "3"),
                new Player("D", "4"),
                new Player("E", "5")
        );
        expected = Arrays.asList(
                new Player("A", "2"),
                new Player("B", "1"),
                new Player("C", "4"),
                new Player("D", "3"),
                new Player("E", "5")
        );
        ladder = new Ladder(players.size(), 11, new Always());
        actual = ladder.apply(players);
        forTest();
    }

    @Test
    void applyTestN() {
        players = Arrays.asList(
                new Player("A", "1"),
                new Player("B", "2"),
                new Player("C", "3"),
                new Player("D", "4"),
                new Player("E", "5")
        );
        expected = Arrays.asList(
                new Player("A", "1"),
                new Player("B", "2"),
                new Player("C", "3"),
                new Player("D", "4"),
                new Player("E", "5")
        );
        ladder = new Ladder(players.size(), 9, new Never());
        actual = ladder.apply(players);
        forTest();
    }

    @Test
    void applyTestO() {
        players = Arrays.asList(
                new Player("A", "1"),
                new Player("B", "2"),
                new Player("C", "3"),
                new Player("D", "4"),
                new Player("E", "5"),
                new Player("F", "6")
        );
        expected = Arrays.asList(
                new Player("A", "2"),
                new Player("B", "1"),
                new Player("C", "3"),
                new Player("D", "5"),
                new Player("E", "4"),
                new Player("F", "6")
        );
        ladder = new Ladder(players.size(), 15, new OddOnly());
        actual = ladder.apply(players);
        forTest();
    }

    @Test
    void applyTestE() {
        players = Arrays.asList(
                new Player("A", "1"),
                new Player("B", "2"),
                new Player("C", "3"),
                new Player("D", "4"),
                new Player("E", "5")
        );
        expected = Arrays.asList(
                new Player("A", "1"),
                new Player("B", "3"),
                new Player("C", "2"),
                new Player("D", "4"),
                new Player("E", "5")
        );
        ladder = new Ladder(players.size(), 271, new EvenOnly());
        actual = ladder.apply(players);
        forTest();
    }
}