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
        ladderPlayers = Players.from(readPlayerNames());

        LadderSize ladderSize = new LadderSize(readLadderHeight(), ladderPlayers.getSize());
        ladder = Ladder.of(ladderSize);
    }

    private List<String> readPlayerNames(){
        return InputView.inputPlayerNames();
    }

    private int readLadderHeight() {
        return InputView.inputLadderHeight();
    }

    public void showLadder() {
        OutputView.printResultDescription();
        OutputView.printPlayerNames(ladderPlayers.getPlayerNames());
        OutputView.printLadder(ladder.toLineDtoList());
    }
}
