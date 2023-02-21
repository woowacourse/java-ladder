package ladder.controller;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Results;
import ladder.domain.Retry;
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
        final Results results = readResults(players);
        final Height height = generate(inputView::readHeight, Height::new);
        final Ladder ladder = ladderGenerator.generate(new LineGenerator(), players, height);
        outputView.printLadderResult(players, ladder, results);
        final String target = inputView.readTarget();
    }

    private <T, R> R generate(final Supplier<T> supplier, final Function<T, R> function) {
        try {
            return function.apply(supplier.get());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return generate(supplier, function);
        }
    }

    private Results readResults(final Players players) {
        final Retry retry = new Retry(5);
        while (retry.isPossible()) {
            try {
                final List<String> names = inputView.readResultNames();
                final Results results = Results.from(names);
                validateSameSize(players, results);
                return results;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                retry.decrease();
            }
        }
        throw new IllegalStateException("재입력 횟수를 초과하였습니다.");
    }

    private void validateSameSize(final Players players, final Results results) {
        if (players.size() != results.size()) {
            throw new IllegalArgumentException(
                    "실행 결과 개수는 플레이어 수와 동일해야 합니다. 플레이어 수: " + players.size()
                            + ", 실행 결과 개수: " + results.size());
        }
    }
}
