package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameResultTest {
    List<Integer> arrival;
    Person person;
    Result result;
    GameResult gameResult;

    @BeforeEach
    void setUp() {
        arrival = Arrays.asList(1, 2, 3);
        person = new Person("pobi,brown,woni");
        result = new Result("꽝,5000,꽝", person);
        gameResult = GameResult.generateGameResult(arrival, person, result);
    }

    @Test
    void 초기이름에_미포함_결과이름_요청() {
        assertThrows(IllegalArgumentException.class, () -> {
            gameResult.getGameResult("buddy", person);
        });
    }

    @Test
    void 결과_출력() {
        assertThat(gameResult.getGameResult("woni", person)).isEqualTo("꽝");
        assertThat(gameResult.getGameResult("all", person)).isEqualTo("pobi : 꽝\nbrown : 5000\nwoni : 꽝\n");
    }
}
