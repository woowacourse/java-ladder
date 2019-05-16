package com.woowacourse.ladder.interfaces;

import com.woowacourse.ladder.domain.Ladder;
import com.woowacourse.ladder.domain.MatchPair;

import java.util.List;

public interface OutputView {
    void printLadder(Ladder<String, String> ladder);
    void printResult(List<MatchPair<String, String>> pairs);
    void printError(String message);
}
