package ladder.controller;

import ladder.domain.generator.MockBooleanGenerator;
import ladder.domain.ladder.Line;
import ladder.domain.player.Name;
import ladder.domain.player.Player;
import ladder.domain.reward.Reward;
import ladder.view.MockInputView;
import ladder.view.MockResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static ladder.domain.ladder.Bar.MOVABLE_BAR;
import static ladder.domain.ladder.Bar.UNMOVABLE_BAR;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderControllerTest {

    private LadderController ladderController;

    @Test
    @DisplayName("사다리 컨트롤러 정상 테스트")
    void ladderControllerTest() {
        MockInputView inputView = new MockInputView(
                List.of(List.of("a","b","c","d")),
                List.of(3),
                List.of(List.of("1","2","3","4")),
                List.of(List.of("all")),
                List.of("n"));
        MockResultView resultView = new MockResultView();
        MockBooleanGenerator booleanGenerator = new MockBooleanGenerator(List.of(true, false));
        ladderController = new LadderController(inputView, resultView, booleanGenerator);
        ladderController.run();
        List<String> resultPlayers = resultView.getPlayers();
        List<Line> resultLadder = resultView.getLadder();
        List<Reward> rewards = resultView.getRewards();
        Map<Player, Reward> gameResult = resultView.getGameResult();

        assertThat(resultPlayers).isEqualTo(List.of("a","b","c","d"));
        assertThat(resultLadder.get(0).getLine()).isEqualTo(List.of(MOVABLE_BAR, UNMOVABLE_BAR, UNMOVABLE_BAR));
        assertThat(resultLadder.get(1).getLine()).isEqualTo(List.of(MOVABLE_BAR, UNMOVABLE_BAR, UNMOVABLE_BAR));
        assertThat(resultLadder.get(2).getLine()).isEqualTo(List.of(MOVABLE_BAR, UNMOVABLE_BAR, UNMOVABLE_BAR));
        assertThat(rewards.get(0).getReward()).isEqualTo("1");
        assertThat(rewards.get(1).getReward()).isEqualTo("2");
        assertThat(rewards.get(2).getReward()).isEqualTo("3");
        assertThat(rewards.get(3).getReward()).isEqualTo("4");
        assertThat(gameResult.get(new Player(new Name("a"))).getReward()).isEqualTo("2");
        assertThat(gameResult.get(new Player(new Name("b"))).getReward()).isEqualTo("1");
        assertThat(gameResult.get(new Player(new Name("c"))).getReward()).isEqualTo("3");
        assertThat(gameResult.get(new Player(new Name("d"))).getReward()).isEqualTo("4");
    }

    @Test
    @DisplayName("사다리 컨트롤러 예외 후 정상 테스트")
    void ladderControllerExceptionTest() {
        MockInputView inputView = new MockInputView(
                List.of(List.of("a","b","c","c"), List.of("aaaaaa","b","c","d"), List.of("a","b","c","d")),
                List.of(0, 3),
                List.of(List.of("1","2","3"), List.of("1","2","3","4")),
                List.of(List.of("e", "a"), List.of("all")),
                List.of("No", "n"));
        MockResultView resultView = new MockResultView();
        MockBooleanGenerator booleanGenerator = new MockBooleanGenerator(List.of(true, false));
        ladderController = new LadderController(inputView, resultView, booleanGenerator);
        ladderController.run();
        List<String> resultPlayers = resultView.getPlayers();
        List<Line> resultLadder = resultView.getLadder();
        List<Reward> rewards = resultView.getRewards();
        Map<Player, Reward> gameResult = resultView.getGameResult();
        boolean resultError = resultView.hasError();

        assertThat(resultError).isTrue();
        assertThat(resultPlayers).isEqualTo(List.of("a","b","c","d"));
        assertThat(resultLadder.get(0).getLine()).isEqualTo(List.of(MOVABLE_BAR, UNMOVABLE_BAR, UNMOVABLE_BAR));
        assertThat(resultLadder.get(1).getLine()).isEqualTo(List.of(MOVABLE_BAR, UNMOVABLE_BAR, UNMOVABLE_BAR));
        assertThat(resultLadder.get(2).getLine()).isEqualTo(List.of(MOVABLE_BAR, UNMOVABLE_BAR, UNMOVABLE_BAR));
        assertThat(rewards.get(0).getReward()).isEqualTo("1");
        assertThat(rewards.get(1).getReward()).isEqualTo("2");
        assertThat(rewards.get(2).getReward()).isEqualTo("3");
        assertThat(rewards.get(3).getReward()).isEqualTo("4");
        assertThat(gameResult.get(new Player(new Name("a"))).getReward()).isEqualTo("2");
        assertThat(gameResult.get(new Player(new Name("b"))).getReward()).isEqualTo("1");
        assertThat(gameResult.get(new Player(new Name("c"))).getReward()).isEqualTo("3");
        assertThat(gameResult.get(new Player(new Name("d"))).getReward()).isEqualTo("4");
    }

}
