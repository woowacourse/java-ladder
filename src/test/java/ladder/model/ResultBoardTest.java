package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class ResultBoardTest {


    @Test
    @DisplayName("플레이어와 실행 결과가 사다리 결과에 맞게 매치되는지 테스트")
    void rewardTest() {
        List<String> playerNames = new ArrayList<>(List.of("a,b,c,d".split(",")));
        Players players = new Players(playerNames.stream().map(Player::new).collect(Collectors.toList()));

        List<Reward> rewardNames = new ArrayList<>(List.of(new Reward("꽝1"), new Reward("꽝2"), new Reward("3000"), new Reward("5000")));
        Rewards rewards = new Rewards(rewardNames, players.getSize());

        LadderGenerator generator = new LadderGenerator(new LadderGeneratorTest.TestLineCreateDecider(newArrayList(true, false, true, false, true, true)));
        Ladder ladder = generator.generateLadder(players.getSize(), new Height(2));
        /*
        사다리 모양
        a     b     c     d
        |-----|     |-----|
        |     |-----|     |
        꽝1   꽝2   3000  5000
         */
        ResultBoard resultBoard = new ResultBoard(players, ladder, rewards);
        assertThat(resultBoard.getRewardOf("a").getReward()).isEqualTo("3000");
        assertThat(resultBoard.getRewardOf("b").getReward()).isEqualTo("꽝1");
        assertThat(resultBoard.getRewardOf("c").getReward()).isEqualTo("5000");
        assertThat(resultBoard.getRewardOf("d").getReward()).isEqualTo("꽝2");
    }

}
