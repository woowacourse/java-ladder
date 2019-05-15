package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class ParticipantGroup<T> {
    private final List<T> participants;

    public ParticipantGroup(List<T> participants) {
        this.participants = participants;
    }

    public ParticipantGroup<T> swap(int x, int y) {
        List<T> newParticipants = new ArrayList<>(participants);
        T t = newParticipants.get(x);
        participants.set(x, newParticipants.get(y));
        participants.set(y, t);

        return new ParticipantGroup<>(newParticipants);
    }
}
