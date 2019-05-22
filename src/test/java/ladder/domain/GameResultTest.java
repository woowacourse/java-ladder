package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    void setUp() {

        Map<Player, DrawResult> testResult = new HashMap<>();
        testResult.put(new Player("a"), new DrawResult("1"));
        testResult.put(new Player("b"), new DrawResult("2"));
        testResult.put(new Player("c"), new DrawResult("3"));

        gameResult = new GameResult(testResult);

    }

    @Test
    void 전체_결과_출력_테스트() {
        assertThat(gameResult.getResult("all")).isEqualTo("a : 1\n" +
                                                        "b : 2\n" +
                                                        "c : 3\n");
    }

    @Test
    void 플레이어_결과_출력_테스트() {
        assertThat(gameResult.getResult("a")).isEqualTo("1");
    }



}
