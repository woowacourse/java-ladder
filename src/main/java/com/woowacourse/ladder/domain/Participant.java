package com.woowacourse.ladder.domain;

import java.util.Objects;
import java.util.Optional;

public class Participant {
    private static final String PRESERVED_NAME = "all";
    private static final int LENGTH_LIMIT = 5;

    private final String name;

    Participant(String name) {
        Optional<String> maybeName = Optional.of(name);
        this.name = maybeName
            .map(String::trim)
            .filter(this::checkIfEmpty)
            .filter(this::checkIfPreservedName)
            .filter(this::checkIfOverLength)
            .orElseThrow(IllegalArgumentException::new);
    }

    private boolean checkIfEmpty(String s) {
        return !s.isEmpty();
    }

    private boolean checkIfPreservedName(String s) {
        return !PRESERVED_NAME.equals(s.toLowerCase());
    }

    private boolean checkIfOverLength(String s) {
        return s.length() <= LENGTH_LIMIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
