package com.woowacourse.ladder.domain;

import com.woowacourse.ladder.InputValidator;

import java.util.List;

public class ResultItems {
    private final List<String> results;

    public ResultItems(final List<String> results, PlayerList playerList) {
        if (!InputValidator.isValidDestinationsInput(results) || results.size() != playerList.getSize()) {
            throw new IllegalArgumentException("올바른 결과를 입력해 주세요. ");
        }
        this.results = results;
    }

    public List<String> getResults() {
        return results;
    }
}
