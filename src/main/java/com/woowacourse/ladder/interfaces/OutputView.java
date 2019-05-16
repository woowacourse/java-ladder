package com.woowacourse.ladder.interfaces;

import com.woowacourse.ladder.domain.Ladder;
import com.woowacourse.ladder.domain.MatchPair;

import java.util.List;

public interface OutputView {
    void printLadder(Ladder ladder, List<String> participants, List<String> destinations);
    void printResult(List<MatchPair> pairs);
    void printError(String message);
}
