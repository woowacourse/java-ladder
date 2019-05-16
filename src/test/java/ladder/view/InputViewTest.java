package ladder.view;

import ladder.model.LadderGoal;
import ladder.model.LadderPlayer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    @Test
    void 구분자를_포함한_이름들을_입력받아서_LadderPlayer_객체들을_반환하는_메소드_테스트() {
        String[] names = {"red", "blue", "green"};
        List<LadderPlayer> players = InputView.makeLadderPlayers(names);
        assertThat(players.get(0).getName()).isEqualTo("red");
        assertThat(players.get(1).getName()).isEqualTo("blue");
        assertThat(players.get(2).getName()).isEqualTo("green");
    }

    @Test
    void 이름이_1개_밖에_없는_경우() {
        String[] names = {"red"};
        assertThrows(IllegalArgumentException.class, () ->{
            InputView.makeLadderPlayers(names);
        });
    }

    @Test
    void 이름이_중복된_경우() {
        String[] names = {"red","red","blue","green"};
        assertThrows(IllegalArgumentException.class, () ->{
            InputView.makeLadderPlayers(names);
        });
    }

    @Test
    void 사다리_높이가_NULL_이거나_빈칸인_경우() {
        assertThrows(IllegalArgumentException.class, () ->{
            InputView.makeLadderHeight(null);
        });
        assertThrows(IllegalArgumentException.class, () ->{
            InputView.makeLadderHeight("");
        });
        assertThrows(IllegalArgumentException.class, () ->{
            InputView.makeLadderHeight(" ");
        });
    }

    @Test
    void 높이가_정수_외_문자열을_입력한_경우() {
        assertThrows(NumberFormatException.class, () -> {
            InputView.makeLadderHeight("a");
        });
        assertThrows(NumberFormatException.class, () -> {
            InputView.makeLadderHeight("1.1");
        });
    }

    @Test
    void 구분자를_포함한_사다리_목표들을_입력받아서_LadderGoal_객체들을_반환하는_메소드_테스트() {
        String[] goalNames = {"one", "two", "three"};
        List<LadderGoal> ladderGoals = InputView.makeLadderGoals(goalNames, 3);
        assertThat(ladderGoals.get(0).getGoalName()).isEqualTo("one");
        assertThat(ladderGoals.get(1).getGoalName()).isEqualTo("two");
        assertThat(ladderGoals.get(2).getGoalName()).isEqualTo("three");
    }

    @Test
    void 사다리_목표가_참여자의_수와_다른경우() {
        String[] goalNames = {"one","two","three"};
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.makeLadderGoals(goalNames, 4);
        });
    }

    @Test
    void 사다리_목표가_중복인_경우() {
        String[] goalNames = {"one","one","two","three"};
        assertThrows(IllegalArgumentException.class, () ->{
            InputView.makeLadderGoals(goalNames,4);
        });
    }
}
