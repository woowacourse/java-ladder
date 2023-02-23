package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderGameTest {

    /**
    ako   split     ash
      |-------|       |
      |-------|       |
      |-------|       |
      |-------|       |
      |-------|       |
     꽝    5000       꽝
     */
    @Test
    void 사다리_게임을_실행하면_사다리_결과를_반환한다() {
        //given
        List<Player> player = List.of(new Player("ako"), new Player("split"), new Player("ash"));
        Players players = new Players(player);
        int height = 5;
        TestGenerator testGenerator = setUpTestGenerator();
        Ladder ladder = Ladder.generateLadder(height, players, testGenerator);
        List<Prize> prize = List.of(new Prize("꽝"), new Prize("5000"), new Prize("꽝"));
        Prizes prizes = new Prizes(players.getPlayersSize(),prize);
        LadderGame ladderGame = new LadderGame(players, ladder, prizes);

        //when
        Map<Player, Prize> result = ladderGame.playGame(players, ladder, prizes);

        //then
        Assertions.assertThat(result.get(player.get(0))).isEqualTo(prize.get(1));
        Assertions.assertThat(result.get(player.get(1))).isEqualTo(prize.get(0));
        Assertions.assertThat(result.get(player.get(2))).isEqualTo(prize.get(2));
    }

    private TestGenerator setUpTestGenerator() {
        List<Boolean> testData = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testData.add(true);
        }
        return new TestGenerator(testData);
    }

    class TestGenerator implements BooleanGenerator {

        private List<Boolean> testData;

        public TestGenerator(List<Boolean> testData) {
            this.testData = testData;
        }

        @Override
        public boolean generate() {
            return testData.remove(0);
        }
    }

}
