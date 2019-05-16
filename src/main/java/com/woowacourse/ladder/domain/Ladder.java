package com.woowacourse.ladder.domain;

import com.woowacourse.ladder.interfaces.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Ladder<P, D> {
    private List<P> participants;
    private List<D> destinations;
    private LadderResult<P, D> result;
    private List<LadderRow<P>> rows;

    public Ladder(List<P> participants, List<D> destinations, int height, BooleanGenerator booleanGenerator) {
        if (participants.size() != destinations.size()) {
            throw new IllegalArgumentException("Size of participants and destination list is not same");
        }

        rows = new ArrayList<>();
        this.participants = participants;
        this.destinations = destinations;
        createRowsAndExlore(height, booleanGenerator);
    }

    private void createRowsAndExlore(int height, BooleanGenerator booleanGenerator) {
        // height 만큼의 Row 생성
        for (int i = 0; i < height; i++) {
            // 각 Row는 n(name) - 1 만큼의 Boolean 리스트를 가짐
            rows.add(new LadderRow<>(participants.size() - 1, booleanGenerator));
        }

        // 결과 생성
        explore(new ParticipantGroup<>(participants), new DestinationGroup<>(destinations));
    }

    private void explore(ParticipantGroup<P> participants, DestinationGroup<D> destinations) {
        ParticipantGroup<P> result = participants;
        for (LadderRow<P> row : rows) {
            result = row.swapNames(result);
        }
        this.result = new LadderResult<>(result, destinations);
    }

    public LadderResult<P, D> getResult() {
        return result;
    }

    public void forEachRows(Consumer<LadderRow<P>> consumer) {
        rows.forEach(consumer);
    }

    public void forEachParticipants(Consumer<P> consumer) {
        participants.forEach(consumer);
    }

    public void forEachDestinations(Consumer<D> consumer) {
        destinations.forEach(consumer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderRow row : rows) {
            sb.append(row).append('\n');
        }
        return sb.toString();
    }
}
