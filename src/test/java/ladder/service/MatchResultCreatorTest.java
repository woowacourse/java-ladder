package ladder.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ladder.domain.FootBars;
import ladder.domain.Ladder;
import ladder.domain.MatchResults;
import ladder.domain.Names;
import ladder.domain.Results;
import ladder.domain.SearchCompletionChecker;
import ladder.util.TrueGenerator;

class MatchResultCreatorTest {
    Names names;
    Results results;
    Ladder ladder;
    MatchResults matchResults;
    SearchCompletionChecker checker;

    @BeforeEach
    void setUp() {
        String[] nameList = {"a", "b", "c", "d"};
        String[] resultList = {"1", "2", "3", "4"};

        names = new Names(Arrays.asList(nameList));
        results = new Results(Arrays.asList(resultList), 4);
    }

    @ParameterizedTest(name = "참여자와 실행 결과를 매칭한다. - 사다리 높이 1")
    @CsvSource(value = {"a,2", "b,1", "c,4", "d,3"})
    void matchingCalculatorTest1(String name, String result) {
        ladder = new Ladder(Arrays.asList(new FootBars[1]));
        ladder.createLadder(4, new TrueGenerator());
        MatchResultCreator matchResultCreator = new MatchResultCreator(ladder, names, results);
        matchResults = matchResultCreator.createMatchResult();
        checker = new SearchCompletionChecker(matchResults.getMatchResults(), new LinkedHashMap<>());
        assertThat(matchResultCreator.createMatchResult().findMatchResult(name, checker)).isEqualTo(result);
    }

    @ParameterizedTest(name = "참여자와 실행 결과를 매칭한다. - 사다리 높이2")
    @CsvSource(value = {"a,1", "b,2", "c,3", "d,4"})
    void matchingCalculatorTest2(String name, String result) {
        ladder = new Ladder(Arrays.asList(new FootBars[2]));
        ladder.createLadder(4, new TrueGenerator());
        MatchResultCreator matchResultCreator = new MatchResultCreator(ladder, names, results);
        matchResults = matchResultCreator.createMatchResult();
        checker = new SearchCompletionChecker(matchResults.getMatchResults(), new LinkedHashMap<>());
        assertThat(matchResultCreator.createMatchResult().findMatchResult(name, checker)).isEqualTo(result);
    }
}
