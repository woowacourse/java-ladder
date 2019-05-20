package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    public void setUp() {
        int height = 5;

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(Arrays.asList(true, false, true, false)));
        }

        ladder = new Ladder(lines);
    }

    @Test
    public void 사다리_잘_타는지_확인() {
        String[] names = {"pobi", "cony", "done", "brown"};
        Players players = new Players(names);
        String[] itemNames = {"a", "b", "c", "d"};
        Items items = new Items(itemNames, players);
        List<Item> resultByMe = Arrays.asList(new Item("b"), new Item("a"), new Item("d"), new Item("c"));
        List<Item> resultByLadder = ladder.play(items);

        assertThat(resultByMe).isEqualTo(resultByLadder);
    }
}
