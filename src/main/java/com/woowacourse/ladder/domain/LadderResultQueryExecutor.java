package com.woowacourse.ladder.domain;

import java.util.List;

public interface LadderResultQueryExecutor<P, D> {
    void printResult(List<MatchPair<P, D>> pairs);
    void onEmptyQuery();
}
