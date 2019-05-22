package com.woowacourse.laddergame.domain;

import com.woowacourse.laddergame.util.NaturalNumber;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    Result get(NaturalNumber resultNo) {
        return results.get(resultNo.convertIndex());
    }

    public int size() {
        return results.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Result result : results) {
            sb.append(result.toString());
        }
        return sb.toString();
    }
}
