package ladder.controller;

import ladder.domain.GameResults;
import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.PlayerNames;
import ladder.dto.LadderStatus;
import ladder.util.ConsoleReader;
import ladder.util.RandomBooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class LadderGameMachine {
    private static final ConsoleReader CONSOLE = new ConsoleReader();

    public void run() {
        PlayerNames playerNames = initNames();
        GameResults gameResults = initGameResults();
        LadderHeight ladderHeight = initLadderHeight();
        Ladder ladder = initLadder(
                new RandomBooleanGenerator(),
                ladderHeight,
                playerNames
        );
        OutputView.printLadderResult(LadderStatus.of(playerNames, ladder, gameResults));
    }

    private PlayerNames initNames() {
        try {
            List<String> input = InputView.readStringsWithDelimiter(CONSOLE, "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            return PlayerNames.of(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initNames();
        }
    }

    private GameResults initGameResults() {
        try {
            List<String> input = InputView.readStringsWithDelimiter(CONSOLE, "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            return GameResults.of(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initGameResults();
        }
    }

    private LadderHeight initLadderHeight() {
        try {
            int input = InputView.readLadderHeight(CONSOLE);
            return new LadderHeight(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initLadderHeight();
        }
    }

    private Ladder initLadder(final Supplier<Boolean> generator, final LadderHeight ladderHeight, final PlayerNames playerNames) {
        return Ladder.of(generator, ladderHeight, playerNames.getPlayerCount());
    }
}
