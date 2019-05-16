package laddergame.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    public static LadderGameResult startGame(Members members, Ladder ladder, Prizes prizes) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < members.size(); i++) {
            result.put(members.getMember(i), prizes.getPrize(ladder.takeLadder(i)));
        }
        return new LadderGameResult(result);
    }
}
