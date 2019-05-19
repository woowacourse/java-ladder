package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameResultTest {
    List<Integer> arrival;
    Person person;
    Result result;
    GameResult gameResult;

    @BeforeEach
    void setUp() {
        arrival = Arrays.asList(1, 2, 3);
        person = new Person("pobi,brown,woni");
        result = new Result("꽝,5000,꽝", person.getCountOfPerson());
        gameResult = new GameResult(arrival, person, result);
    }

    @Test
    void 초기이름에_미포함_결과이름_요청() {
        assertThrows(IllegalArgumentException.class, () -> {
            gameResult.getResult("buddy", person);
        });
    }

    @Test
    void 결과_출력() {
        assertThat(gameResult.getResult("woni", person)).isEqualTo("꽝");
        assertThat(gameResult.getResult("all", person)).isEqualTo("pobi : 꽝\nbrown : 5000\nwoni : 꽝\n");
    }
}
