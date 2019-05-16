package com.woowacourse.ladder.domain;

public class LadderResult {
    private final ParticipantGroup participants;
    private final DestinationGroup destinationGroup;

    LadderResult(ParticipantGroup participants, DestinationGroup destinations) {
        this.participants = participants;
        this.destinationGroup = destinations;
    }

    public MatchPair matchResult(String participant) {
        int idx = participants.indexOf(participant);
        if (idx == -1) {
            throw new IllegalArgumentException(String.format("Participant not found: '%s'", participant));
        }
        return new MatchPair(participant, destinationGroup.get(idx));
    }

    public boolean hasMatchResult(String participant) {
        return participants.indexOf(participant) > -1;
    }
}
