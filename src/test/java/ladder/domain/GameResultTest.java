package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultProcessorTest {
    List<Integer> allResult;
    Person person;
    Result result;
    GameResult resultProcessor;
    @BeforeEach
    void setUp() {
        allResult = Arrays.asList(1, 2, 3);
        person = new Person(Arrays.asList("pobi", "brown", "woni"));
        result = new Result(Arrays.asList("꽝", "5000", "꽝"));
        resultProcessor = new GameResult(allResult, person, result);
    }

    @Test
    void 생성자확인() {
        assertThat(resultProcessor).isEqualTo(new GameResult(allResult, person, result));
    }

    @Test
    void 결과_출력() {
        assertThat(resultProcessor.getResult("woni")).isEqualTo("꽝");
        assertThat(resultProcessor.getResult("all")).isEqualTo("pobi : 꽝\nbrown : 5000\nwoni : 꽝\n");
    }
}
