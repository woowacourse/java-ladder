package com.woowacourse.ladder.domain;

public class MatchPair {
    private final String participant;
    private final String destination;

    public MatchPair(final String participant, final String destination) {
        this.participant = participant;
        this.destination = destination;
    }

    public String getParticipant() {
        return participant;
    }

    public String getDestination() {
        return destination;
    }
}
