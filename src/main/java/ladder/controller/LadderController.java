package ladder.controller;

import java.util.function.Function;
import java.util.function.Supplier;

import ladder.domain.*;
import ladder.domain.generator.LineGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LineGenerator lineGenerator;

    public LadderController(final InputView inputView, final OutputView outputView, final LineGenerator lineGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lineGenerator = lineGenerator;
    }

    public void run() {
        final Players players = makePlayers();
        final Height height = makeHeight();
        final Gifts gifts = makeGifts(players.numberOfPlayers());

        final Ladder ladder = new Ladder(lineGenerator, players, height);
        outputView.printLadderResult(players, ladder, gifts);

        final Players resultPlayer = ladder.movePlayers(players);
        final Result result = makeResult(resultPlayer);
        outputView.printGameResult(resultPlayer, gifts, result);
    }

    private Players makePlayers() {
        try {
            return new Players(inputView.readPlayerNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }

        return makePlayers();
    }

    private Height makeHeight() {
        try {
            return new Height(inputView.readHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }

        return makeHeight();
    }

    private Gifts makeGifts(int numberOfPlayer) {
        try {
            return new Gifts(inputView.readGiftNames(), numberOfPlayer);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }

        return makeGifts(numberOfPlayer);
    }

    public Result makeResult(Players players) {
        try {
            return new Result(inputView.readResultCommand(), players);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }

        return makeResult(players);
    }
}
