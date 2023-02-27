package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SearchCompletionCheckerTest {

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

    @Test
    @DisplayName("이름을 전부 검색했는지 여부를 반환한다. - 전부 검색한 경우(all 입력)")
    void isAllCheckedTrueAllTest() {
        matchResults.findMatchResult("all", checker);
        assertTrue(checker.isAllChecked());
    }

    @Test
    @DisplayName("이름을 전부 검색했는지 여부를 반환한다. - 전부 검색한 경우(각 원소를 각자 입력)")
    void isAllCheckedTrueEachTest() {
        matchResults.findMatchResult("a", checker);
        matchResults.findMatchResult("b", checker);
        assertTrue(checker.isAllChecked());
    }

    @Test
    @DisplayName("이름을 전부 검색했는지 여부를 반환한다. - 전부 검색하지 않은 경우")
    void isAllCheckedFalseTest() {
        matchResults.findMatchResult("a", checker);
        assertFalse(checker.isAllChecked());
    }
}
