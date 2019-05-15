package com.woowacourse.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResultQueryProcessor<D> {
    private final LadderResult<String, D> ladderResult;
    private final LadderResultQueryExecutor<String, D> queryExecutor;

    public LadderResultQueryProcessor(LadderResult<String, D> result, LadderResultQueryExecutor<String, D> queryExecutor) {
        this.ladderResult = result;
        this.queryExecutor = queryExecutor;
    }

    public void execute(String query) {
        query = query.trim();
        if (query.isEmpty()) {
            queryExecutor.onEmptyQuery();
            return;
        }

        List<String> participantNames = Arrays.asList(query.split(","));
        List<MatchPair<String, D>> pairs = participantNames.stream()
            .map(String::trim)
            .map(n -> new MatchPair<>(n, ladderResult.matchResult(n)))
            .collect(Collectors.toList());
        queryExecutor.printResult(pairs);
    }
}
