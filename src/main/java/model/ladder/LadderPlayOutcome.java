package model.ladder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import model.player.Player;

public class LadderPlayOutcome {
    private final LinkedHashMap<Player, LadderResultContent> outcome;

    public LadderPlayOutcome(final LinkedHashMap<Player, LadderResultContent> outcome) {
        this.outcome = outcome;
    }

    public Map<Player, LadderResultContent> getOutcome() {
        return Collections.unmodifiableMap(outcome);
    }
}
