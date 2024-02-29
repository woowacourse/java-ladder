package model.game;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.player.Player;
import model.prize.Prize;

public class GameResult {
    private static final String NOT_EXIST_PLAYER = "게임에 등록되지 않은 참여자입니다.";
    private final LinkedHashMap<Player, Prize> result;

    public GameResult(final LinkedHashMap<Player, Prize> result) {
        this.result = result;
    }

    public Prize get(Player player) {
        if (!result.containsKey(player)) {
            throw new IllegalArgumentException(NOT_EXIST_PLAYER);
        }
        return result.get(player);
    }

    public Map<Player, Prize> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public List<GameResultState> captureResultStates() {
        return result.entrySet().stream()
                .map(entry -> GameResultState.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
