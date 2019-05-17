package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
        Player testPlayer = new Player("aaa");
        DrawResult testDrawResult = new DrawResult("5000");
        gameResult.addGameResult(testPlayer, testDrawResult);
        gameResult.addGameResult(new Player("aa"), new DrawResult("100"));
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
