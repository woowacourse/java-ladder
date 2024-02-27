package domain.ladder;

import domain.booleanGenerator.BooleanGenerator;
import domain.player.Player;
import domain.player.Players;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRow {
    private final List<DirectionalRung> rungs;

    public LadderRow(BooleanGenerator booleanGenerator, int size) {
        rungs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            DirectionalRung ladderRung = findNextRung(booleanGenerator, getLastRung(), i, size);
            rungs.add(ladderRung);
        }
    }

    public void playRow(Players players) {
        for (int i = 0; i < rungs.size(); i++) {
            Player player = players.findPlayerByIndex(i);
            player.move(rungs.get(i));
        }
    }

    private DirectionalRung findNextRung(final BooleanGenerator booleanGenerator, final DirectionalRung lastRung,
                                         final int currentIndex, final int size) {
        if (lastRung == DirectionalRung.RIGHT) {
            return DirectionalRung.LEFT;
        }
        if (currentIndex == size - 1) {
            return DirectionalRung.MID;
        }
        return DirectionalRung.findRung(booleanGenerator.generate());
    }

    private DirectionalRung getLastRung() {
        if (!rungs.isEmpty()) {
            return rungs.get(rungs.size() - 1);
        }
        return DirectionalRung.MID;
    }

    public List<DirectionalRung> getRungs() {
        return Collections.unmodifiableList(this.rungs);
    }
}
