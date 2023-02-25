package domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderGameTest {

    /**
     * ako   split     ash
     * |-------|       |
     * |-------|       |
     * |-------|       |
     * |-------|       |
     * |-------|       |
     * 꽝    5000       꽝
     */
    @Test
    void 사다리_게임을_실행하면_사다리_결과를_반환한다() {
        //given
        Players players = generatePlayer();
        Ladder ladder = getLadder(players);
        Prizes prizes = generatePrize(players.getPlayersSize());
        LadderGame ladderGame = new LadderGame(players, ladder, prizes);

        //when
        LadderGameResult result = ladderGame.playGame();

        //then
        Assertions.assertThat(result.getPrizeOfPlayer(players.getPlayer(0))).isEqualTo(prizes.getPrize(1));
        Assertions.assertThat(result.getPrizeOfPlayer(players.getPlayer(1))).isEqualTo(prizes.getPrize(0));
        Assertions.assertThat(result.getPrizeOfPlayer(players.getPlayer(2))).isEqualTo(prizes.getPrize(2));
    }

    private Players generatePlayer() {
        List<Player> players = List.of(new Player("ako"), new Player("split"), new Player("ash"));
        return new Players(players);
    }

    private Prizes generatePrize(int playerCount) {
        List<Prize> prize = List.of(new Prize("꽝"), new Prize("5000"), new Prize("꽝"));
        return new Prizes(playerCount, prize);
    }

    private Ladder getLadder(Players players) {
        int height = 5;
        TestGenerator testGenerator = setUpTestGenerator();
        Ladder ladder = Ladder.generateLadder(height, players, testGenerator);
        return ladder;
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
