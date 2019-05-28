package com.woowacourse.ladder.domain;

public class ResultQuery {
    private final String resultQuery;

    public ResultQuery(final String resultQuery) {
        this.resultQuery = resultQuery;
    }

    public boolean isAll(String string) {
        return this.resultQuery.equals(string.toLowerCase());
    }

    @Override
    public String toString() {
        return resultQuery;
    }
}
