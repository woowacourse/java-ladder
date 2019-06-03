package ladder;

import ladder.domain.*;

import java.util.HashMap;
import java.util.LinkedHashMap;


class LadderGame {
    static LadderingResult start(PlayerGroup players, Ladder ladder, ResultItems resultItems) {
        HashMap<Player, LadderItem> ladderingResult = new LinkedHashMap<>();
        int resultPosition;

        for (int position = 0; position < players.size(); position++) {
            resultPosition = ladder.answerResultPositionOf(position);
            ladderingResult.put(players.getPlayerAtPositionOf(position), resultItems.getResultItemAtPositionOf(resultPosition));
        }
        return new LadderingResult(ladderingResult);
    }
}
