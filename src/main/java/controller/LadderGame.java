package controller;

import domain.Height;
import domain.Ladder;
import domain.Players;
import service.LadderMaker;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        final Players players = new Players(inputView.readNames());
        final Height height = new Height(inputView.readHeight());

        final LadderMaker ladderMaker = new LadderMaker();
        final Ladder ladder = ladderMaker.createLadder(players.count(), height.getHeight());

        printGameResult(players, ladder);
    }

    private void printGameResult(final Players players, final Ladder ladder) {
        outputView.printResultMessage();
        outputView.printPlayers(players.getNames());
        outputView.printLadder(ladder.getLines());
    }
}
