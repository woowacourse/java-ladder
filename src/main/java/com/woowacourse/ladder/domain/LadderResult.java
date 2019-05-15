package com.woowacourse.ladder.domain;

import java.util.List;

public class LadderResult<P, D> {
    private final List<P> participants;
    private final DestinationGroup<D> destinationGroup;

    public LadderResult(List<P> participants, List<D> destinations) {
        this.participants = participants;
        this.destinationGroup = new DestinationGroup<>(destinations);
    }

    public D matchResult(P participant) {
        int idx = indexOf(participant);
        if (idx == -1) {
            throw new IllegalArgumentException(String.format("Participant not found: '%s'", participant));
        }
        return destinationGroup.get(idx);
    }

    private int indexOf(P participant) {
        return participants.indexOf(participant);
    }
}
