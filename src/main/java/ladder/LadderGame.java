package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.HashMap;
import java.util.LinkedHashMap;


class LadderGame {
    void start(PlayerGroup players, Ladder ladder, ResultItems resultItems) {
        HashMap<Player, ResultItem> ladderingResult = getAllResult(players, ladder, resultItems);

        OutputView.showPlayersAndLadder(players, ladder, resultItems);

        System.out.println("\n실행 결과");
        show(ladderingResult);
    }

    private void show(HashMap<Player, ResultItem> ladderingResult) {
        try {
            String playerName = InputView.inputPlayerNameToShowResult();
            OutputView.showResultOf(playerName, ladderingResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        show(ladderingResult);
    }

    private HashMap<Player, ResultItem> getAllResult(PlayerGroup players, Ladder ladder, ResultItems resultItems) {
        HashMap<Player, ResultItem> ladderingResult = new LinkedHashMap<>();
        int resultPosition;

        for (int position = 0; position < players.size(); position++) {
            resultPosition = ladder.answerResultPositionOf(position);
            ladderingResult.put(players.getPlayerAtPositionOf(position), resultItems.getResultItemAtPositionOf(resultPosition));
        }
        return ladderingResult;
    }
}
