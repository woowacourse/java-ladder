package ladder.model;

import ladder.model.coin.Always;
import ladder.model.coin.EvenOnly;
import ladder.model.coin.Never;
import ladder.model.coin.OddOnly;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    Players players = new Players(Arrays.asList("a", "b", "c", "d", "e"));

    @Test
    void initTestA() {
        Ladder ladderA = new Ladder(10, 6, new Always());
        ladderA.getLevels().forEach(l ->
            assertThat(new Level(ladderA.getWidth() - 1, new Always()).getLines()).isEqualTo(l.getLines())
        );
    }

    @Test
    void initTestN() {
        Ladder ladderN = new Ladder(11, 7, new Never());
        ladderN.getLevels().forEach(l ->
            assertThat(new Level(ladderN.getWidth() - 1, new Never()).getLines()).isEqualTo(l.getLines())
        );
    }

    @Test
    void initTestO() {
        OddOnly odd = new OddOnly();
        Ladder ladderO = new Ladder(7, 123, new OddOnly());
        ladderO.getLevels().forEach(l ->
            assertThat(new Level(ladderO.getWidth() - 1, odd).getLines()).isEqualTo(l.getLines())
        );
    }

    @Test
    void initTestE() {
        EvenOnly even = new EvenOnly();
        Ladder ladderE = new Ladder(117, 2, new EvenOnly());
        ladderE.getLevels().forEach(l ->
            assertThat(new Level(ladderE.getWidth() - 1, even).getLines()).isEqualTo(l.getLines())
        );
    }

    @Test
    void applyTestA() {
        final Rewards rewards = new Rewards(players, Arrays.asList("1", "2", "3", "4", "5"));
        final List<String> expected = Arrays.asList("2", "1", "4", "3", "5");
        final Ladder ladderA = new Ladder(players.number(), 11, new Always());
        final Rewards actual = ladderA.apply(players, rewards);
        IntStream.range(0, players.number()).boxed().forEach(i -> assertThat(actual.get(i)).isEqualTo(expected.get(i)));
    }

    @Test
    void applyTestN() {
        final Rewards rewards = new Rewards(players, Arrays.asList("1", "2", "3", "4", "5"));
        final List<String> expected = Arrays.asList("1", "2", "3", "4", "5");
        final Ladder ladderA = new Ladder(players.number(), 9, new Never());
        final Rewards actual = ladderA.apply(players, rewards);
        IntStream.range(0, players.number()).boxed().forEach(i -> assertThat(actual.get(i)).isEqualTo(expected.get(i)));
    }

    @Test
    void applyTestO() {
        final Rewards rewards = new Rewards(players, Arrays.asList("1", "2", "3", "4", "5", "6"));
        final List<String> expected = Arrays.asList("2", "1", "3", "5", "4", "6");
        final Ladder ladderA = new Ladder(players.number(), 15, new OddOnly());
        final Rewards actual = ladderA.apply(players, rewards);
        IntStream.range(0, players.number()).boxed().forEach(i -> assertThat(actual.get(i)).isEqualTo(expected.get(i)));
    }

    @Test
    void applyTestE() {
        final Rewards rewards = new Rewards(players, Arrays.asList("1", "2", "3", "4", "5"));
        final List<String> expected = Arrays.asList("1", "3", "2", "4", "5");
        final Ladder ladderA = new Ladder(players.number(), 271, new EvenOnly());
        final Rewards actual = ladderA.apply(players, rewards);
        IntStream.range(0, players.number()).boxed().forEach(i -> assertThat(actual.get(i)).isEqualTo(expected.get(i)));
    }
}