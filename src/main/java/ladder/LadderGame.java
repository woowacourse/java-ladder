package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.HashMap;
import java.util.LinkedHashMap;


class LadderGame {
    void start(PlayerGroup players, Ladder ladder, ResultItems resultItems) {
        HashMap<Player, LadderItem> ladderingResult = getAllResult(players, ladder, resultItems);

        OutputView.showPlayersAndLadder(players, ladder, resultItems);
        show(ladderingResult);
    }

    private void show(HashMap<Player, LadderItem> ladderingResult) {
        try {
            String playerName = InputView.inputPlayerNameToShowResult();
            OutputView.showResultOf(playerName, ladderingResult);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
        }
        show(ladderingResult);
    }

    private HashMap<Player, LadderItem> getAllResult(PlayerGroup players, Ladder ladder, ResultItems resultItems) {
        HashMap<Player, LadderItem> ladderingResult = new LinkedHashMap<>();
        int resultPosition;

        for (int position = 0; position < players.size(); position++) {
            resultPosition = ladder.answerResultPositionOf(position);
            ladderingResult.put(players.getPlayerAtPositionOf(position), resultItems.getResultItemAtPositionOf(resultPosition));
        }
        return ladderingResult;
    }
}
