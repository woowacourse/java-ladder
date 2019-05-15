package com.woowacourse.ladder.interfaces;

import java.util.List;

public interface InputView {
    List<String> promptNames();
    List<String> promptDestinations();
    List<String> promptNamesToQuery();
    int promptLadderHeight();
}
