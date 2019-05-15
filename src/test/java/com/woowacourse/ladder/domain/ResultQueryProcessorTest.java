package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultQueryProcessorTest {

    @Test
    void testQueryMultipleResults() {
        LadderResult<String, String> ladderResult =
            new LadderResult<>(Arrays.asList("pobi", "crong", "honux"), Arrays.asList("2등", "3등", "1등"));
        LadderResultQueryProcessor<String> queryProcessor = new LadderResultQueryProcessor<>(ladderResult,
            new LadderResultQueryExecutor<String, String>() {
                @Override
                public void printResult(List<MatchPair<String, String>> matchPairs) {
                    assertThat(matchPairs).isEqualTo(Arrays.asList(new MatchPair<>("pobi", "2등"),
                        new MatchPair<>("honux", "1등")));
                }
                @Override
                public void onEmptyQuery() {
                    throw new IllegalStateException("It can't be happened");
                }
            });
        queryProcessor.execute("pobi, honux");
    }

    @Test
    void testOnEmptyQuery() {
        LadderResult<String, String> ladderResult =
            new LadderResult<>(Arrays.asList("pobi", "crong", "honux"), Arrays.asList("2등", "3등", "1등"));
        LadderResultQueryProcessor<String> queryProcessor = new LadderResultQueryProcessor<>(ladderResult,
            new LadderResultQueryExecutor<String, String>() {
                @Override
                public void printResult(List<MatchPair<String, String>> matchPairs) {
                    throw new IllegalStateException("It can't be happened");
                }

                @Override
                public void onEmptyQuery() {
                    assertThat(1).isEqualTo(1);
                }
            });
        queryProcessor.execute("");
    }
}
