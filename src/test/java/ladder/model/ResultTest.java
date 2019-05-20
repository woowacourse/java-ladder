package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    List<Player> players = Arrays.asList(
        new Player("A", "1"),
        new Player("B", "2"),
        new Player("C", "3"),
        new Player("D", "4"),
        new Player("E", "5")
    );
    Ladder ladder = new Game(players, 12).getLadder();

    @Test
    void getAllTest() {
        Result r = new Result(players, ladder, Arrays.asList("all"));
        int size = 0;
        while (r.hasNext()) {
            r.next();
            size++;
        }
        assertThat(size).isEqualTo(5);
    }

    @Test
    void getSomeTestA() {
        Result r = new Result(players, ladder, Arrays.asList("A"));
        int size = 0;
        while (r.hasNext()) {
            r.next();
            size++;
        }
        assertThat(size).isEqualTo(1);
    }

    @Test
    void getSomeTestB() {
        Result r = new Result(players, ladder, Arrays.asList("A", "B"));
        int size = 0;
        while (r.hasNext()) {
            r.next();
            size++;
        }
        assertThat(size).isEqualTo(2);
    }

    @Test
    void getNoneTest() {
        Result r = new Result(players, ladder, Arrays.asList("F"));
        int size = 0;
        while (r.hasNext()) {
            r.next();
            size++;
        }
        assertThat(size).isEqualTo(0);
    }
}