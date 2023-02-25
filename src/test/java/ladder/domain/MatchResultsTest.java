package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatchResultsTest {

    private MatchResults matchResults;
    private SearchCompletionChecker checker;

    @BeforeEach
    void setUp() {
        Name name1 = new Name("a");
        Name name2 = new Name("b");
        Result result1 = new Result("1");
        Result result2 = new Result("2");

        LinkedHashMap<Name, Result> map = new LinkedHashMap<>();
        map.put(name1, result1);
        map.put(name2, result2);
        matchResults = new MatchResults(map);
        checker = new SearchCompletionChecker(matchResults.getMatchResults(), new LinkedHashMap<>());
    }

    @ParameterizedTest(name = "사다리 실행 결과를 검색한다.")
    @CsvSource(value = {"a,1", "b,2"})
    void matchingSuccessTest(String str1, String str2) {
        assertThat(matchResults.findMatchResult(str1, checker)).isEqualTo(str2);
    }

    @Test
    @DisplayName("참여자의 이름이 아닌 이름으로 검색할 때 예외 처리한다.")
    void matchingFailTest() {
        assertThatThrownBy(() -> matchResults.findMatchResult("1", checker));
    }
}
