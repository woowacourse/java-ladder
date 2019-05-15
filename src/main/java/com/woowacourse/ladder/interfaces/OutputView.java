package com.woowacourse.ladder.interfaces;

import com.woowacourse.ladder.domain.Ladder;
import com.woowacourse.ladder.domain.LadderResult;

import java.util.List;

public interface OutputView {
    void printLadder(Ladder<String> ladder);
    void printSingleResult(String result);
    void printMultipleResult(LadderResult<String> ActualResult, List<String> expectedResults, List<String> namesToPrint);
}
