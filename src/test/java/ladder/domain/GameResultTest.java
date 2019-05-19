package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    List<Integer> arrival;
    Person person;
    Result result;
    GameResult gameResult;
    @BeforeEach
    void setUp() {
        arrival = Arrays.asList(1, 2, 3);
//        person = new Person(Arrays.asList("pobi", "brown", "woni"));
        result = new Result(Arrays.asList("꽝", "5000", "꽝"));
        gameResult = new GameResult(arrival, person, result);
    }

    @Test
    void 결과_출력() {
        assertThat(gameResult.getResult("woni")).isEqualTo("꽝");
        assertThat(gameResult.getResult("all")).isEqualTo("pobi : 꽝\nbrown : 5000\nwoni : 꽝\n");
    }
}
