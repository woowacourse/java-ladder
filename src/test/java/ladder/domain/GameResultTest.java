package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
        Player testPlayer1 = new Player("pobi");
        Player testPlayer2 = new Player("crong");
        Player testPlayer3 = new Player("zino");
        Reward testDrawResult1 = new Reward("5000");
        Reward testDrawResult2 = new Reward("100");
        Reward testDrawResult3 = new Reward("꽝");
        gameResult.addGameResult(testPlayer1, testDrawResult1);
        gameResult.addGameResult(testPlayer2, testDrawResult2);
    }

    @Test
    void 전체_결과_출력_테스트() {
        assertThat(gameResult.getResult("all")).isEqualTo("aaa : 5000\n" +
                                                            "aa : 100");
    }

    @Test
    void 플레이어_결과_출력_테스트() {
        assertThat(gameResult.getResult("aaa")).isEqualTo("5000");
    }

}
