package ladder.domain;

import java.util.Arrays;
import java.util.List;

import ladder.util.BooleanGenerator;

public class LadderMaker {
    public static Ladder makeLadder(int numberOfPeople, int ladderHeight, BooleanGenerator generator) {
        List<FootBars> ladder = Arrays.asList(new FootBars[ladderHeight]);
        do {
            addLine(ladder, numberOfPeople, ladderHeight, generator);
        }
        while (hasNoLine(ladder));
        return new Ladder(ladder);
    }

    private static void addLine(List<FootBars> ladder, int numberOfPeople, int ladderHeight,
        BooleanGenerator generator) {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.set(i, FootBarsMaker.makeFootBars(generator, numberOfPeople));
        }
    }

    private static boolean hasNoLine(List<FootBars> ladder) {
        return ladder.stream().noneMatch(LadderMaker::hasLine);
    }

    private static boolean hasLine(FootBars footBars) {
        return footBars.getFootBars().stream().anyMatch(condition -> condition == Boolean.TRUE);
    }
}
