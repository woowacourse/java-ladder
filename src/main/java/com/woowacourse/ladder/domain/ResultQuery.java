package com.woowacourse.ladder.domain;

import com.woowacourse.ladder.InputValidator;

public class ResultQuery {
    private final String resultQuery;

    public ResultQuery(final String resultQuery, PlayerList playerList) {
        String result = resultQuery.trim();

        if ((InputValidator.isNotAll(result) && !playerList.getNames().contains(resultQuery))
                || !InputValidator.isNotEmptyString(result)) {
            throw new IllegalArgumentException();
        }

        this.resultQuery = resultQuery;
    }

    @Override
    public String toString() {
        return resultQuery;
    }
}
