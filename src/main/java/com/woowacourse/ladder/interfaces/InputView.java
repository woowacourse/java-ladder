package com.woowacourse.ladder.interfaces;

import java.util.List;

public interface InputView {
    List<String> promptNames();
    List<String> promptExpectedResult();
    List<String> promptNameToQuery();
    int promptLadderHeight();
}
