package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ladder.util.TrueGenerator;

class MatcherTest {
    Names names;
    Results results;
    Ladder ladder;

    @BeforeEach
    void setUp() {
        String[] nameList = {"a", "b", "c", "d"};
        String[] resultList = {"1", "2", "3", "4"};

        names = new Names(Arrays.asList(nameList));
        results = new Results(Arrays.asList(resultList), 4);
        ladder = new Ladder();
    }

    @ParameterizedTest(name = "참여자와 실행 결과를 매칭한다. - 사다리 높이 1")
    @CsvSource(value = {"a,2", "b,1", "c,4", "d,3"})
    void matchingCalculatorTest1(String name, String result) {
        ladder.drawLine(4, 1, new TrueGenerator());

        Matcher matcher = new Matcher(ladder, names, results);
        assertThat(matcher.match().findMatchResult(name)).isEqualTo(result);
    }

    @ParameterizedTest(name = "참여자와 실행 결과를 매칭한다. - 사다리 높이2")
    @CsvSource(value = {"a,1", "b,2", "c,3", "d,4"})
    void matchingCalculatorTest2(String name, String result) {
        ladder.drawLine(4, 2, new TrueGenerator());

        Matcher matcher = new Matcher(ladder, names, results);
        assertThat(matcher.match().findMatchResult(name)).isEqualTo(result);
    }
}
