package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {

    @Test
    void 사다리게임_결과가_잘나오는지_테스트() {
        List<LadderPlayer> players = new ArrayList<>();
        players.add(new LadderPlayer("red"));
        players.add(new LadderPlayer("blue"));
        players.add(new LadderPlayer("green"));
        players.add(new LadderPlayer("black"));

        List<LadderGoal> goals = new ArrayList<>();
        goals.add(new LadderGoal("one"));
        goals.add(new LadderGoal("two"));
        goals.add(new LadderGoal("three"));
        goals.add(new LadderGoal("four"));

        List<LadderWidth> ladders = new ArrayList<>();
        ladders.add(new LadderWidth(new ArrayList<>(Arrays.asList(true,false,true))));
        ladders.add(new LadderWidth(new ArrayList<>(Arrays.asList(false,false,true))));
        ladders.add(new LadderWidth(new ArrayList<>(Arrays.asList(true,false,false))));
        ladders.add(new LadderWidth(new ArrayList<>(Arrays.asList(false,true,false))));

        Ladder ladder = new Ladder(ladders);

        LadderGameResult ladderGameResult = new LadderGameResult(new LadderGamePlayers(players), ladder, new LadderGameGoals(goals));
        assertThat(ladderGameResult.match("red")).isEqualTo("one");
        assertThat(ladderGameResult.match("blue")).isEqualTo("three");
        assertThat(ladderGameResult.match("green")).isEqualTo("two");
        assertThat(ladderGameResult.match("black")).isEqualTo("four");
    }
}
