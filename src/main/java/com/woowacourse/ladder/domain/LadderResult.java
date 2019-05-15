package com.woowacourse.ladder.domain;

import java.util.List;

public class LadderResult<P, D> {
    private final List<P> participants;
    private final DestinationGroup<D> destinationGroup;

    public LadderResult(List<P> participants, List<D> destinations) {
        this.participants = participants;
        this.destinationGroup = new DestinationGroup<>(destinations);
    }

    public MatchPair<P, D> matchResult(P participant) {
        int idx = indexOf(participant);
        if (idx == -1) {
            throw new IllegalArgumentException(String.format("Participant not found: '%s'", participant));
        }
        return new MatchPair<>(participant, destinationGroup.get(idx));
    }

    public boolean hasMatchResult(P participant) {
        return indexOf(participant) > -1;
    }

    private int indexOf(P participant) {
        return participants.indexOf(participant);
    }
}
