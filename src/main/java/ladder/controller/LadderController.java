package ladder.controller;

import ladder.domain.*;
import ladder.domain.generator.LineGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.function.Supplier;

public class LadderController {

    private static final String MAX_ATTEMPT_REACHED_ERROR_MESSAGE = "최대 시도 횟수에 도달했습니다. 프로그램을 종료합니다.";

    private final InputView inputView;
    private final OutputView outputView;
    private final LineGenerator lineGenerator;

    public LadderController(final InputView inputView, final OutputView outputView, final LineGenerator lineGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lineGenerator = lineGenerator;
    }

    public void run() throws IllegalArgumentException {
        final Players players = retry(() -> new Players(inputView.readPlayerNames()));
        final Gifts gifts = retry(() -> new Gifts(inputView.readGiftNames(), players.numberOfPlayers()));
        final Height height = retry(() -> new Height(inputView.readHeight()));

        final Ladder ladder = new Ladder(lineGenerator, players, height);
        outputView.printLadderResult(players, ladder, gifts);

        final Players resultPlayer = ladder.movePlayers(players);
        final Result result = retry(() -> new Result(inputView.readResultCommand(), players));
        outputView.printGameResult(resultPlayer, gifts, result);
    }

    private <T> T retry(final Supplier<T> supplier) {
        for (int count = 0; count < 5; count++) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }

        throw new IllegalArgumentException(MAX_ATTEMPT_REACHED_ERROR_MESSAGE);
    }
}
