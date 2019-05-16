package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParticipantGroup<T> {
    private final List<T> participants;

    public ParticipantGroup(List<T> participants) {
        this.participants = participants;
    }

    public ParticipantGroup<T> swap(int x, int y) {
        List<T> newParticipants = new ArrayList<>(participants);
        Collections.swap(newParticipants, x, y);

        return new ParticipantGroup<>(newParticipants);
    }

    public int indexOf(T participant) {
        return participants.indexOf(participant);
    }
}
