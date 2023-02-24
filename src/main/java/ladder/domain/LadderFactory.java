package ladder.domain;

import java.util.Arrays;
import java.util.List;

import ladder.util.BooleanGenerator;

public class LadderFactory {
    public static Ladder newLadder(int numberOfPeople, int ladderHeight, BooleanGenerator generator) {
        List<FootBars> ladder = Arrays.asList(new FootBars[ladderHeight]);
        do {
            addFootBars(ladder, numberOfPeople, generator);
        }
        while (!hasAnyFootBar(ladder));
        return new Ladder(ladder);
    }

    private static void addFootBars(List<FootBars> ladder, int numberOfPeople, BooleanGenerator generator) {
        ladder.replaceAll(ignored -> FootBarsFactory.newFootBars(generator, numberOfPeople));
    }

    private static boolean hasAnyFootBar(List<FootBars> ladder) {
        return ladder.stream().anyMatch(LadderFactory::hasFootBar);
    }

    private static boolean hasFootBar(FootBars footBars) {
        return footBars.getFootBars().stream().anyMatch(condition -> condition == Boolean.TRUE);
    }
}
