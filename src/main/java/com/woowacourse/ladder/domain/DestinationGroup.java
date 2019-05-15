package com.woowacourse.ladder.domain;

import java.util.List;

public class DestinationGroup<T> {
    private final List<T> destinations;

    public DestinationGroup(List<T> destinations) {
        this.destinations = destinations;
    }

    public T get(int index) {
        return destinations.get(index);
    }
}
