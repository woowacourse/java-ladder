package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderGamePlayers;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    LadderGamePlayers players;
    Ladder ladder;

    public void run() {
        players = new LadderGamePlayers(InputView.makeLadderPlayers());
        ladder = new Ladder(players, InputView.makeLadderHeight());

        OutputView.showLadderGame(players.getAlignedNames(), ladder);
    }


}
