package laddergame.controller;

import java.util.List;
import java.util.function.Supplier;
import laddergame.domain.BooleanGenerator;
import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.LadderGame;
import laddergame.domain.LadderResult;
import laddergame.domain.Line;
import laddergame.domain.NamesWithMatchedResult;
import laddergame.domain.PersonalNames;
import laddergame.domain.Width;
import laddergame.view.InputView;
import laddergame.view.LadderFormGenerator;
import laddergame.view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;
    private final LadderFormGenerator ladderFormGenerator = new LadderFormGenerator();

    public LadderController(final InputView inputView,
                            final OutputView outputView,
                            final BooleanGenerator booleanGenerator
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        final PersonalNames names = retryOnInvalidInputWithAlert(
                () -> new PersonalNames(inputView.readNames()));
        final LadderResult ladderResult = retryOnInvalidInputWithAlert(
                () -> LadderResult.of(names, inputView.readResults()));
        final Height ladderHeight = retryOnInvalidInputWithAlert(
                () -> new Height(inputView.readHeight()));
        final Ladder ladder = new Ladder(new Width(names.getSize()), ladderHeight, booleanGenerator);

        showGeneratedLadder(names, ladderResult, ladder);
        playGame(names, ladderResult, ladder);
    }

    private void playGame(PersonalNames names, LadderResult ladderResult, Ladder ladder) {
        final LadderGame ladderGame = new LadderGame(names, ladderResult);
        final NamesWithMatchedResult result = ladderGame.moveAndGetResult(ladder);
        searchResultItemByNameFrom(result);
    }

    private void showGeneratedLadder(PersonalNames names, LadderResult ladderResult, Ladder ladder) {
        final List<Line> lines = ladder.getLines();
        outputView.printLadderForm(ladderFormGenerator.generate(names, ladderResult, lines));
    }

    private <T> T retryOnInvalidInputWithAlert(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (RuntimeException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void searchResultItemByNameFrom(NamesWithMatchedResult t) {
        while (true) {
            try {
                printResultForName(t);
                return;
            } catch (RuntimeException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void printResultForName(NamesWithMatchedResult namesWithMatchedResult) {
        while (true) {
            String name = inputView.readNameToCheckResult();
            if (isAll(name)) {
                outputView.printTotalResult(namesWithMatchedResult);
                break;
            }
            outputView.printResult(namesWithMatchedResult.searchBy(name));
        }
    }

    private static boolean isAll(String name) {
        return name.equals("all");
    }
}
