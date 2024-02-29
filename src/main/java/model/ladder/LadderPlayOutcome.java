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

    public Prize get(Player player) {
        if (!outcome.containsKey(player)) {
            throw new IllegalArgumentException("게임에 등록되지 않은 참여자입니다.");
        }
        return outcome.get(player);
    }

    public Map<Player, Prize> getOutcome() {
        return Collections.unmodifiableMap(outcome);
    }
}
