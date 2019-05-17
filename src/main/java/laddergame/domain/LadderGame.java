package laddergame.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    public static LadderGameResult startGame(Tags members, Ladder ladder, Tags prizes) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < members.size(); i++) {
            result.put(members.getTagName(i), prizes.getTagName(ladder.takeLadder(i)));
        }
        return new LadderGameResult(result);
    }
}
