package com.woowacourse.ladder.domain;

import java.util.List;

public class LadderResult<T> {
    private final List<T> participants;

    public LadderResult(List<T> participants) {
        this.participants = participants;
    }

    public T get(int index) {
        return participants.get(index);
    }

    public int indexOf(T participant) {
        return participants.indexOf(participant);
    }

    public String matchResult(List<String> result, T pobi) {
        return result.get(indexOf(pobi));
    }
}
