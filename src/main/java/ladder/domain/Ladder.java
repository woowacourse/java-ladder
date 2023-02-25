package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ladder.util.BooleanGenerator;

public class Ladder {
    private final List<FootBars> ladder;

    public Ladder(List<FootBars> ladder) {
        this.ladder = ladder;
    }

    public void createLadder(int numberOfPeople, BooleanGenerator generator) {
        do {
            addFootBars(ladder, numberOfPeople, generator);
        }
        while (!hasAnyFootBar(ladder));
    }

    private void addFootBars(List<FootBars> ladder, int numberOfPeople, BooleanGenerator generator) {
        for (int i = 0; i < ladder.size(); i++) {
            FootBars footBars = new FootBars(new ArrayList<>());
            footBars.createFootBars(generator, numberOfPeople);
            ladder.set(i, footBars);
        }
    }

    private boolean hasAnyFootBar(List<FootBars> ladder) {
        return ladder.stream().anyMatch(this::hasFootBar);
    }

    private boolean hasFootBar(FootBars footBars) {
        return footBars.getFootBars().stream().anyMatch(condition -> condition == Boolean.TRUE);
    }

    public List<FootBars> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
