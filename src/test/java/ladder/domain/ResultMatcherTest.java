package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultMatcherTest {
    List<Integer> allResult;
    Person person;
    Result result;
    ResultMatcher resultMatcher;
    LadderGameData ladderGameData;
    List<Line> lines;

    @BeforeEach
    void setUp() {
        allResult = Arrays.asList(1, 2, 3);
        person = new Person(Arrays.asList("pobi", "brown", "woni"));
        result = new Result(Arrays.asList("꽝", "5000", "꽝"));
        ladderGameData = new LadderGameData(person, result);
        lines = Arrays.asList(new Line(Arrays.asList(false, false, false, false)));
        resultMatcher = new ResultMatcher(new Ladder(lines), ladderGameData);
    }

    @Test
    void 생성자확인() {
        assertThat(resultMatcher).isEqualTo(new ResultMatcher(new Ladder(lines), ladderGameData));
    }

    @Test
    void 결과_출력() {
        assertThat(resultMatcher.getResult("woni")).isEqualTo("꽝");
        assertThat(resultMatcher.getResult("all")).isEqualTo("pobi : 꽝\nbrown : 5000\nwoni : 꽝\n");
    }
}
