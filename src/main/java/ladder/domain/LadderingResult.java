package ladder.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LadderingResult {
    private HashMap<Player, LadderItem> ladderingResult;

    public LadderingResult(HashMap<Player, LadderItem> ladderingResult) {
        this.ladderingResult = ladderingResult;
    }

    public HashMap<Player, LadderItem> findResultOf(String playerName) {
        validateNotNull(playerName);
        if (playerName.equals("all")) {
            return ladderingResult;
        }

        validateContainmentOf(playerName);
        return resultOf(playerName);
    }


    private void validateNotNull(String playerName) {
        if (playerName.equals(null)) {
            throw new IllegalArgumentException("결과를 보고싶은 플레이어 이름으로 null은 입력할 수 없습니다.");
        }
    }

    private void validateContainmentOf(String playerName) {
        if (!ladderingResult.containsKey(new Player(playerName))) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }
    }

    private HashMap<Player, LadderItem> resultOf(String playerName) {
        HashMap<Player, LadderItem> foundResult = new LinkedHashMap<>();
        Player findingPlayer = new Player(playerName);

        foundResult.put(findingPlayer, ladderingResult.get(findingPlayer));
        return foundResult;
    }
}
