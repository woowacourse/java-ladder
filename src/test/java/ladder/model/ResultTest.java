package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    Game game = new Game(Arrays.asList("a", "b", "c", "d", "e"), Arrays.asList("1", "2", "3", "4", "5"), 12);

    @Test
    void getAllTest() {
        Result r = new Result(game.getPlayers(), game.getRewards(), game.getLadder(), Arrays.asList("all"));
        int size = 0;
        while (r.hasNext()) {
            r.next();
            size++;
        }
        assertThat(size).isEqualTo(5);
    }

    @Test
    void getSomeTestA() {
        Result r = new Result(game.getPlayers(), game.getRewards(), game.getLadder(), Arrays.asList("a"));
        int size = 0;
        while (r.hasNext()) {
            r.next();
            size++;
        }
        assertThat(size).isEqualTo(1);
    }

    @Test
    void getSomeTestB() {
        Result r = new Result(game.getPlayers(), game.getRewards(), game.getLadder(), Arrays.asList("a", "b"));
        int size = 0;
        while (r.hasNext()) {
            r.next();
            size++;
        }
        assertThat(size).isEqualTo(2);
    }

    @Test
    void getNoneTest() {
        Result r = new Result(game.getPlayers(), game.getRewards(), game.getLadder(), Arrays.asList("f"));
        int size = 0;
        while (r.hasNext()) {
            r.next();
            size++;
        }
        assertThat(size).isEqualTo(0);
    }
}