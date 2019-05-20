package ladder.view;

import ladder.model.LadderGameResult;
import ladder.model.LadderGoal;
import ladder.model.LadderPlayer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {

    @Test
    void 플레이어_이름이_올바르게_만들어_지는지_테스트() {
        List<LadderPlayer> expected = InputView.makeLadderPlayers("red,blue,green".split(","));
        List<LadderPlayer> actual = new ArrayList<>(Arrays.asList(new LadderPlayer("red"), new LadderPlayer("blue"), new LadderPlayer("green")));

        assertEquals(expected, actual);
    }

    @Test
    void 사다리_높이_올바르게_만들어_지는지_테스트() {
        assertEquals(InputView.makeLadderHeight("5"), 5);
    }

    @Test
    void 사다리_실행_결과가_올바르게_입력되는지_테스트() {
        List<LadderGoal> expected = InputView.makeLadderGoals("one,two,three".split(","), 3);
        List<LadderGoal> actual = new ArrayList<>(Arrays.asList(new LadderGoal("one"), new LadderGoal("two"), new LadderGoal("three")));

        assertEquals(expected, actual);
    }
}
