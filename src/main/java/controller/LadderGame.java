package controller;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.Players;
import domain.ladder.RandomBridgeGenerator;
import domain.ladder.Width;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        final Players players = new Players(inputView.readNames());
        final Height height = new Height(inputView.readHeight());

        final Ladder ladder = Ladder.createByStrategy(
                RandomBridgeGenerator.getInstance(),
                height,
                Width.from(players));

        printGameResult(players, ladder);
    }

    private void printGameResult(final Players players, final Ladder ladder) {
        outputView.printResultMessage();
        outputView.printPlayers(players.getNames());
        outputView.printLadder(ladder.getLadder());
    }
}
