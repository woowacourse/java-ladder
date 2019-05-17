package com.woowacourse.ladder.domain;

import java.util.List;

public class LadderResult {
    private final List<String> participants;
    private final List<String> destinations;

    public LadderResult(List<String> participants, List<String> destinations) {
        this.participants = participants;
        this.destinations = destinations;
    }

    public MatchPair matchParticipant(String participant) {
        int idx = participants.indexOf(participant);
        assertParticipantExists(participant);
        return new MatchPair(participant, destinations.get(idx));
    }

    private void assertParticipantExists(String participant) {
        if (participants.indexOf(participant) == - 1) {
            throw new IllegalArgumentException(String.format("Participant match not found: '%s'", participant));
        }
    }

    public boolean hasMatchParticipant(String pobi) {
        return participants.contains(pobi);
    }
}
