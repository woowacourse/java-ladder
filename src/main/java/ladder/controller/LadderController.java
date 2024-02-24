package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderSize;
import ladder.model.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {
    private Players ladderPlayers;
    private Ladder ladder;

    public void makeLadder(){
        ladderPlayers = Players.from(InputView.inputPlayerNames());

        List<String> ladderResult = InputView.inputLadderResult();

        LadderSize ladderSize = new LadderSize(InputView.inputLadderHeight(), ladderPlayers.getSize());
        ladder = Ladder.of(ladderSize);
    }

    public void showLadder() {
        OutputView.printResultDescription();
        OutputView.printPlayerNames(ladderPlayers.getPlayerNames());
        OutputView.printLadder(ladder.toLineDtoList());
    }

    public void showResult() {
        String resultPlayer = InputView.inputResultPlayer();
    }
}
