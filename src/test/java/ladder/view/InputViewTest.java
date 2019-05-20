package ladder.view;

import ladder.model.LadderGameGoals;
import ladder.model.LadderGamePlayers;
import ladder.model.LadderGoal;
import ladder.model.LadderPlayer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {
    @Test
    void Player_객체가_올바르게_만들어지는지_테스트() {
        LadderGamePlayers expected = InputView.createLadderGamePlayers("red, blue, green".split(","));
        List<LadderPlayer> players = Arrays.asList(new LadderPlayer("red")
                , new LadderPlayer("blue"), new LadderPlayer("green"));
        LadderGamePlayers actual = new LadderGamePlayers(players);

        assertEquals(expected, actual);
    }

    @Test
    void 사다리_높이가_올바르게_만들어지는지_테스트() {
        assertEquals(InputView.createLadderHeight("5"), 5);
    }

    @Test
    void 사다리_실행_결과_객체가_올바르게_만들어지는지_테스트() {
        LadderGameGoals expected = InputView.createLadderGameGoals("one, two, three".split(","), 3);
        List<LadderGoal> goals = Arrays.asList(new LadderGoal("one")
                , new LadderGoal("two"), new LadderGoal("three"));
        LadderGameGoals actual = new LadderGameGoals(goals, 3);

        assertEquals(expected, actual);
    }
}
