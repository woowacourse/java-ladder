package ladder.controller;

import java.util.function.Function;
import java.util.function.Supplier;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.generator.LadderGenerator;
import ladder.domain.generator.LineGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGenerator ladderGenerator;

    public LadderController(final InputView inputView, final OutputView outputView,
                            final LadderGenerator ladderGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGenerator = ladderGenerator;
    }

    public void run() {
        final Players players = generate(inputView::readPlayerNames, Players::new);
        final Height height = generate(inputView::readHeight, Height::new);
        final Ladder ladder = ladderGenerator.generate(new LineGenerator(), players, height);
        outputView.printLadderResult(players, ladder);
    }

    private <T, R> R generate(final Supplier<T> supplier, final Function<T, R> function) {
        try {
            return function.apply(supplier.get());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return generate(supplier, function);
        }
    }
}
