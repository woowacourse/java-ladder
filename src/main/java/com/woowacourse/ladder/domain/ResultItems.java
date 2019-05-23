package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultItems {
    private final List<String> results;

    public ResultItems(final List<String> results) {
        this.results = new ArrayList<>();
        this.results.addAll(results);
    }

    public List<String> getResults() {
        List<String> results = new ArrayList<>();
        results.addAll(this.results);
        return results;
    }

    public String getResult(int index) {
        return results.get(index);
    }
}
