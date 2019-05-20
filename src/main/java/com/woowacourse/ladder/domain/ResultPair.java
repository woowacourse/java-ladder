package com.woowacourse.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * 사다리 참가자와 결과 쌍으로 이루어진 Map을 갖는 객체
 * 일반 Map이기 때문에 순서를 보장하지 않음.
 */
public class ResultPair {

    private final Map<Participant, Destination> pairs;

    public ResultPair() {
        pairs = new HashMap<>();
    }

    public void addPair(Participant participant, Destination destination) {
        pairs.put(participant, destination);
    }

    public void forEachPair(BiConsumer<Participant, Destination> consumer) {
        pairs.forEach(consumer);
    }

    public int size() {
        return pairs.size();
    }
}
