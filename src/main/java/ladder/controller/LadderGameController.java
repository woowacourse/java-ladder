package ladder.controller;

import java.util.function.Supplier;
import ladder.domain.Height;
import ladder.domain.Items;
import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.domain.Players;
import ladder.util.BooleanGenerator;
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
        outputView.printLadderResult(ladderGame);
        final LadderGameResult ladderGameResult = ladderGame.play();
        printLadderGameResult(ladderGameResult);
    }

    private LadderGame initialize() {
        final Players players = repeatUntilGetValidInput(() -> Players.from(inputView.readPlayerNames()));
        final Items items = repeatUntilGetValidInput(() -> Items.of(inputView.readItemNames(), players.count()));
        final Height height = repeatUntilGetValidInput(() -> new Height(inputView.readLadderHeight()));

        return LadderGame.initialize(players, booleanGenerator, height, items);
    }

    private <T> T repeatUntilGetValidInput(final Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeatUntilGetValidInput(inputReader);
        }
    }

    private void printLadderGameResult(final LadderGameResult ladderGameResult) {
        LadderGameCommand command = LadderGameCommand.SINGLE;
        while (command.isContinued()) {
            final String name = repeatUntilGetValidInput(() -> getValidPlayerName(ladderGameResult));
            command = LadderGameCommand.from(name);
            outputView.printLadderGameResult(ladderGameResult, name);
        }
    }

    private String getValidPlayerName(final LadderGameResult ladderGameResult) {
        final String name = inputView.readPlayerName();
        ladderGameResult.validatePlayerName(name);
        return name;
    }

    private enum LadderGameCommand {
        MULTIPLE,
        SINGLE;

        private static final String MULTIPLE_RESULT_RESERVED_NAME = "all";

        public static LadderGameCommand from(final String name) {
            if (MULTIPLE_RESULT_RESERVED_NAME.equals(name)) {
                return MULTIPLE;
            }
            return SINGLE;
        }

        public boolean isContinued() {
            return this == SINGLE;
        }
    }
}
