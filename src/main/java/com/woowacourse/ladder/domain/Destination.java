package com.woowacourse.ladder.domain;

import java.util.Objects;
import java.util.Optional;

public class Destination {
    private static final int LENGTH_LIMIT = 5;

    private final String destination;

    public Destination(String destination) {
        Optional<String> maybeDestination = Optional.of(destination);
        this.destination = maybeDestination
            .map(String::trim)
            .filter(this::checkIfEmpty)
            .filter(this::checkIfOverLength)
            .orElseThrow(IllegalArgumentException::new);
    }

    private boolean checkIfEmpty(String s) {
        return !s.isEmpty();
    }

    private boolean checkIfOverLength(String s) {
        return s.length() <= LENGTH_LIMIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination);
    }

    @Override
    public String toString() {
        return destination;
    }
}
