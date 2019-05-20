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

    void testForm(int expectedSize, String... strList) {
        Result result = new Result(players, ladder, Arrays.asList(strList));
        int size = 0;
        while (result.hasNext()) {
            result.next();
            size++;
        }
        assertThat(size).isEqualTo(expectedSize);
    }

    @Test
    void getAllTest() {
        testForm(5, "all");
    }

    @Test
    void getSomeTestA() {
        testForm(1, "A");
    }

    @Test
    void getSomeTestB() {
        testForm(2, "A", "B");
    }

    @Test
    void getNoneTest() {
        testForm(0, "F");
    }
}