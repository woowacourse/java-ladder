package com.woowacourse.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DestinationGroup {

    private final List<Destination> destinations;

    public DestinationGroup(String s) {
        List<Destination> sanitized = Stream.of(s.split(","))
            .map(Destination::new)
            .collect(Collectors.toList());

        if (sanitized.isEmpty()) {
            throw new IllegalArgumentException();
        }
        destinations = sanitized;
    }

    public Destination get(int index) {
        return destinations.get(index);
    }

    public void forEachDestinations(Consumer<Destination> destinationsConsumer) {
        destinations.forEach(destinationsConsumer);
    }

    public int size() {
        return destinations.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DestinationGroup that = (DestinationGroup) o;
        return destinations.equals(that.destinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinations);
    }
}
