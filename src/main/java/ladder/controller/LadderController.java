package ladder.controller;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Prizes;
import ladder.domain.Retry;
import ladder.domain.generator.RandomDirectionGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Players players = generate(inputView::readPlayerNames, Players::new);
        final Prizes prizes = readResults(players);
        final Height height = generate(inputView::readHeight, Height::new);
        final Ladder ladder = Ladder.of(new RandomDirectionGenerator(), players, height);
        outputView.printLadderResult(players, ladder, prizes);
    }

    private <T, R> R generate(final Supplier<T> supplier, final Function<T, R> function) {
        try {
            return function.apply(supplier.get());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return generate(supplier, function);
        }
    }

    private Prizes readResults(final Players players) {
        final Retry retry = new Retry(5);
        while (retry.isPossible()) {
            try {
                final List<String> names = inputView.readResultNames();
                final Prizes prizes = Prizes.from(names);
                validateSameSize(players, prizes);
                return prizes;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                retry.decrease();
            }
        }
        throw new IllegalStateException("재입력 횟수를 초과하였습니다.");
    }

    private void validateSameSize(final Players players, final Prizes prizes) {
        if (players.size() != prizes.size()) {
            throw new IllegalArgumentException(
                    "실행 결과 개수는 플레이어 수와 동일해야 합니다. 플레이어 수: " + players.size()
                            + ", 실행 결과 개수: " + prizes.size());
        }
    }
}
