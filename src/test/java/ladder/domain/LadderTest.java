package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LadderTest {
    List<Player> players;

    @BeforeEach
    void setUp() {
        players = Arrays.asList(new Player("a", 0), new Player("b", 1),
                new Player("c", 2), new Player("c", 3));
    }

    @Test
    void create_가로_새로_생성() {
        new Ladder(players, 5);
    }

    @Test
    void create_생성_후_ladder_초기화_후_프린트() {
        Ladder ladder = new Ladder(players, 5);
        System.out.println(ladder.drawLadderShape());
    }

    @Test
    void create_생성_후_ladder_초기화() {
        Ladder ladder = new Ladder(players, 5);
        System.out.println(ladder.drawLadderShape());
    }
}