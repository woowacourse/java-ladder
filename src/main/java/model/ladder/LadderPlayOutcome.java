package model.ladder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import model.player.Player;
import model.prize.Prize;

public class LadderPlayOutcome {
    private final LinkedHashMap<Player, Prize> outcome;

    public LadderPlayOutcome(final LinkedHashMap<Player, Prize> outcome) {
        this.outcome = outcome;
    }

    public Map<Player, Prize> getOutcome() {
        return Collections.unmodifiableMap(outcome);
    }
}
