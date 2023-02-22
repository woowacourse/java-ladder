package laddergame.controller;

import java.util.List;
import java.util.function.Consumer;
import laddergame.domain.BooleanGenerator;
import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.LadderGame;
import laddergame.domain.LadderResult;
import laddergame.domain.Line;
import laddergame.domain.NamesWithMatchedResult;
import laddergame.domain.PersonalNames;
import laddergame.domain.Width;
import laddergame.utils.RetryUtils;
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
        final PersonalNames names = RetryUtils.retryOnRuntimeExceptionWithMessage(
                () -> new PersonalNames(inputView.readNames()));
        final LadderResult ladderResult = RetryUtils.retryOnRuntimeExceptionWithMessage(
                () -> LadderResult.of(names, inputView.readResults()));

        final Height ladderHeight = RetryUtils.retryOnRuntimeExceptionWithMessage(
                () -> new Height(inputView.readHeight()));
        final Ladder ladder = new Ladder(new Width(names.getSize()), ladderHeight, booleanGenerator);

        final List<Line> lines = ladder.getLines();
        outputView.printLadderForm(ladderFormGenerator.generate(names, ladderResult, lines));

        final LadderGame ladderGame = new LadderGame(names, ladderResult);
        NamesWithMatchedResult result = ladderGame.moveAndGetResult(ladder);
        retryOnRuntimeExceptionWithMessage(result, this::printResultWhileCommandIsNotAll);
    }

    public void printResultWhileCommandIsNotAll(NamesWithMatchedResult namesWithMatchedResult) {
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

    public void retryOnRuntimeExceptionWithMessage(NamesWithMatchedResult t,
                                                   Consumer<NamesWithMatchedResult> consumer) {
        while (true) {
            try {
                consumer.accept(t);
                return;
            } catch (RuntimeException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        }
    }
}
