package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    private Players players;
    private Items items;

    @BeforeEach
    public void setUp() {
        String[] playerNames = {"pobi", "cony", "done", "woni"};
        String[] itemNames = {"꽝1", "당첨", "꽝2", "꽝3"};
        players = new Players(playerNames);
        items = new Items(itemNames, players);
    }

    @Test
    public void 결과를_잘_구하는지_확인() {
        Point point1 = new Point(new Direction(true, false));
        Point point2 = new Point(new Direction(false, true));

        Line line = new Line(new ArrayList<>(Arrays.asList(point2, point1, point2, point1)));
        Ladder ladder = new Ladder(new ArrayList<>(Arrays.asList(line, line, line)));
        LadderResult resultByLadder = ladder.makeResult(players, items);

        assertThat(resultByLadder.getItemByPlayer(new Player("pobi"))).isEqualTo(new Item("당첨"));
        assertThat(resultByLadder.getItemByPlayer(new Player("cony"))).isEqualTo(new Item("꽝1"));
        assertThat(resultByLadder.getItemByPlayer(new Player("done"))).isEqualTo(new Item("꽝3"));
        assertThat(resultByLadder.getItemByPlayer(new Player("woni"))).isEqualTo(new Item("꽝2"));
    }
}
