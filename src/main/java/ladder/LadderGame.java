package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.HashMap;
import java.util.LinkedHashMap;


class LadderGame {
    void start(PlayerGroup players, Ladder ladder, ResultItems resultItems) {
        LadderingResult ladderingResult = createAllLadderingResult(players, ladder, resultItems);

        OutputView.showPlayersAndLadder(players, ladder, resultItems);
        show(ladderingResult);
    }

    private void show(LadderingResult ladderingResult) {
        try {
            String playerName = InputView.inputPlayerNameToShowResult();
            OutputView.showResultOf(playerName, ladderingResult);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
        }
        show(ladderingResult);
    }

    private LadderingResult createAllLadderingResult(PlayerGroup players, Ladder ladder, ResultItems resultItems) {
        HashMap<Player, LadderItem> ladderingResult = new LinkedHashMap<>();
        int resultPosition;

        for (int position = 0; position < players.size(); position++) {
            resultPosition = ladder.answerResultPositionOf(position);
            ladderingResult.put(players.getPlayerAtPositionOf(position), resultItems.getResultItemAtPositionOf(resultPosition));
        }
        return new LadderingResult(ladderingResult);
    }
}
