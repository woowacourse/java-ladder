package com.woowacourse.ladder.domain;

import com.woowacourse.ladder.interfaces.BooleanGenerator;

import java.util.List;

public class LadderBuilder<P, D> {
    private List<P> participants;
    private List<D> destinations;
    private BooleanGenerator booleanGenerator;
    private int height;

    public LadderBuilder() {
        height = -1;
    }

    public LadderBuilder<P, D> withParticipants(List<P> participants) {
        this.participants = participants;
        return this;
    }

    public LadderBuilder<P, D> withDestinations(List<D> destinations) {
        this.destinations = destinations;
        return this;
    }

    public LadderBuilder<P, D> withGenerator(BooleanGenerator generator) {
        this.booleanGenerator = generator;
        return this;
    }

    public LadderBuilder<P, D> withHeight(int height) {
        this.height = height;
        return this;
    }

    public Ladder<P, D> build() {
        if (participants == null ||
        destinations == null ||
        height == -1 ||
        booleanGenerator == null) {
            throw new IllegalStateException("Ladder builder has missed argument(s)");
        }

        return new Ladder<P, D>(participants, destinations, height, booleanGenerator);
    }
}
