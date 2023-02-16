package ladder.controller;

import java.util.function.Function;
import java.util.function.Supplier;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
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
        final Players players = retry(Players::new, inputView::readPlayerNames);
        final Height height = retry(Height::new, inputView::readHeight);
        final Ladder ladder = new Ladder(lineGenerator, players.numberOfPlayers(), height);
        outputView.printLadderClimbing(players, ladder);
    }

    private <T, R> R retry(final Function<T, R> function, final Supplier<T> supplier) {
        try {
            return function.apply(supplier.get());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return retry(function, supplier);
        }
    }
}
