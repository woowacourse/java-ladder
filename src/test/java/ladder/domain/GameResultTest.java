package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
    }

    @Test
    void 동명이인_테스트() {
        Player testPlayer = new Player("aa");
        DrawResult testDrawResult = new DrawResult("5000");
        gameResult.addGameResult(testPlayer, testDrawResult);
        gameResult.addGameResult(new Player("aa"), new DrawResult("100"));
        assertThat(gameResult.getResult(testPlayer)).isEqualTo(testDrawResult);
    }
}
