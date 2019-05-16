package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ParticipantGroup {
    private final List<String> participants;

    ParticipantGroup(List<String> participants) {
        this.participants = participants;
    }

    ParticipantGroup swap(int x, int y) {
        List<String> newParticipants = new ArrayList<>(participants);
        Collections.swap(newParticipants, x, y);

        return new ParticipantGroup(newParticipants);
    }

    int indexOf(String participant) {
        return participants.indexOf(participant);
    }
}
