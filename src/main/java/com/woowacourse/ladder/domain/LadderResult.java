package com.woowacourse.ladder.domain;

import java.util.List;

public class LadderResult<P, D> {
    private final ParticipantGroup<P> participants;
    private final DestinationGroup<D> destinationGroup;

    public LadderResult(ParticipantGroup<P> participants, DestinationGroup<D> destinations) {
        this.participants = participants;
        this.destinationGroup = destinations;
    }

    public MatchPair<P, D> matchResult(P participant) {
        int idx = participants.indexOf(participant);
        if (idx == -1) {
            throw new IllegalArgumentException(String.format("Participant not found: '%s'", participant));
        }
        return new MatchPair<>(participant, destinationGroup.get(idx));
    }

    public boolean hasMatchResult(P participant) {
        return participants.indexOf(participant) > -1;
    }
}
