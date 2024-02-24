package ladder.controller;

import ladder.model.Bars;
import ladder.model.Ladder;
import ladder.model.LadderSize;
import ladder.model.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {
    private Players ladderPlayers;
    private Ladder ladder;
    private List<String> ladderResult;

    public void makeLadder(){
        ladderPlayers = Players.from(InputView.inputPlayerNames());

        ladderResult = InputView.inputLadderResult();

        LadderSize ladderSize = new LadderSize(InputView.inputLadderHeight(), ladderPlayers.getSize());
        ladder = Ladder.of(ladderSize);
    }

    public void showLadder() {
        OutputView.printLadderDescription();
        OutputView.printPlayerNames(ladderPlayers.getPlayerNames());
        OutputView.printLadder(ladder.toLineDtoList());
    }

    public void showResult() {
        String questionedPlayer = InputView.inputQuestionedPlayer();

        Bars bars = Bars.from(ladder.findBars());
        List<String> changedLadderResult = bars.calculateChangedLadderResult(ladderResult);

        OutputView.printLadderResultDescription();
        OutputView.printLadderResult(questionedPlayer, ladderPlayers.getPlayerNames(), changedLadderResult);
    }
}
