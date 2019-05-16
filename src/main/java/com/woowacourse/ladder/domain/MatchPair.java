package com.woowacourse.ladder.domain;

import java.util.Objects;

public class MatchPair<P, D> {
    private final P participant;
    private final D destination;

    public MatchPair(P participant, D destination) {
        this.participant = participant;
        this.destination = destination;
    }

    public P getParticipant() {
        return participant;
    }

    public D getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchPair<?, ?> matchPair = (MatchPair<?, ?>) o;
        return Objects.equals(participant, matchPair.participant) &&
            Objects.equals(destination, matchPair.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant, destination);
    }

    @Override
    public String toString() {
        return String.format("MatchPair { participant: '%s', destination: '%s' }", participant, destination);
    }
}
