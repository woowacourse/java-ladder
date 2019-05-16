package com.woowacourse.ladder.domain;

import java.util.List;

class DestinationGroup {
    private final List<String> destinations;

    DestinationGroup(List<String> destinations) {
        this.destinations = destinations;
    }

    String get(int index) {
        return destinations.get(index);
    }
}
