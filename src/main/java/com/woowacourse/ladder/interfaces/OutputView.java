package com.woowacourse.ladder.interfaces;

import com.woowacourse.ladder.domain.LadderState;
import com.woowacourse.ladder.domain.MatchPair;

import java.util.List;

public interface OutputView {
    void printLadder(LadderState ladderState, List<String> participants, List<String> destinations);
    void printResult(List<MatchPair> pairs);
    void printError(String message);
}
