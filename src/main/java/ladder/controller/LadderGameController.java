package ladder.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import ladder.domain.BooleanGenerator;
import ladder.domain.Height;
import ladder.domain.Items;
import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.domain.Line;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    private final BooleanGenerator booleanGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(
            final BooleanGenerator booleanGenerator,
            final InputView inputView,
            final OutputView outputView
    ) {
        this.booleanGenerator = booleanGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final LadderGame ladderGame = initialize();
        printLadderResult(ladderGame);
        final LadderGameResult ladderGameResult = ladderGame.play();
        printLadderGameResult(ladderGameResult);
    }

    private LadderGame initialize() {
        final Players players = repeatUntilGetValidInput(() -> Players.from(inputView.readPlayerNames()));
        final Items items = repeatUntilGetValidInput(() -> Items.from(inputView.readItemNames(), players.count()));
        final Height height = repeatUntilGetValidInput(() -> new Height(inputView.readLadderHeight()));

        return LadderGame.initialize(players, booleanGenerator, height, items);
    }

    private <T> T repeatUntilGetValidInput(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeatUntilGetValidInput(inputReader);
        }
    }

    private void printLadderResult(final LadderGame ladderGame) {
        final List<String> players = ladderGame.getPlayers();
        final List<Line> ladder = ladderGame.getLadder();
        final List<String> items = ladderGame.getItems();

        outputView.printLadderResult(players, ladder, items);
    }

    private void printLadderGameResult(final LadderGameResult ladderGameResult) {
        LadderGameCommand command = LadderGameCommand.SINGLE;
        while (command.isContinued()) {
            final Map<String, String> result = repeatUntilGetValidInput(() -> getLadderGameResult(ladderGameResult));
            command = LadderGameCommand.from(result.size());
            outputView.printLadderGameResult(result);
        }
    }

    private Map<String, String> getLadderGameResult(final LadderGameResult ladderGameResult) {
        final String name = inputView.readPlayerName();
        return ladderGameResult.get(name);
    }

    enum LadderGameCommand {
        ALL,
        SINGLE;

        private static final int SINGLE_RESULT_SIZE = 1;

        public static LadderGameCommand from(final int size) {
            if (size == SINGLE_RESULT_SIZE) {
                return SINGLE;
            }
            return ALL;
        }

        public boolean isContinued() {
            return this == SINGLE;
        }
    }
}
