package controller;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderMaker;
import domain.player.Players;
import utils.Log;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LadderMaker ladderMaker = new LadderMaker();

    public void run() {
        Players players = getPlayers();
        int personCount = players.getPlayers().size();
        Height ladderHeight = getLadderHeight();

        Ladder ladder = new Ladder(ladderMaker.make(personCount, ladderHeight));

        showResult(players, ladder);
    }

    private Players getPlayers() {
        try {
            return new Players(inputView.readNames());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getPlayers();
        }
    }

    private Height getLadderHeight() {
        try {
            return new Height(inputView.readLadderHeight());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getLadderHeight();
        }
    }

    private void showResult(Players players, Ladder ladder) {
        outputView.showResultMessage();
        outputView.showPlayers(players.getPlayers());
        outputView.showLadder(ladder);
    }
}
