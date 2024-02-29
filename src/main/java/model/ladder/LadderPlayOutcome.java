package model.ladder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.player.Player;
import model.prize.Prize;

public class LadderPlayOutcome {
    private static final String NOT_EXIST_PLAYER = "게임에 등록되지 않은 참여자입니다.";
    private final LinkedHashMap<Player, Prize> outcome;

    public LadderPlayOutcome(final LinkedHashMap<Player, Prize> outcome) {
        this.outcome = outcome;
    }

    public Prize get(Player player) {
        if (!outcome.containsKey(player)) {
            throw new IllegalArgumentException(NOT_EXIST_PLAYER);
        }
        return outcome.get(player);
    }

    public Map<Player, Prize> getOutcome() {
        return Collections.unmodifiableMap(outcome);
    }

    public List<LadderPlayOutcomeState> getOutcomeStates() {
        return outcome.entrySet().stream()
                .map(entry -> LadderPlayOutcomeState.from(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
