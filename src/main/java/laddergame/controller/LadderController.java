package laddergame.controller;

import java.util.List;
import java.util.function.Supplier;
import laddergame.domain.LadderResult;
import laddergame.domain.PersonalNames;
import laddergame.domain.game.GameResult;
import laddergame.domain.game.LadderGame;
import laddergame.domain.ladder.Height;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Width;
import laddergame.domain.ladder.line.BooleanGenerator;
import laddergame.domain.ladder.line.LadderLinesGenerator;
import laddergame.domain.ladder.line.Line;
import laddergame.view.InputView;
import laddergame.view.LadderFormGenerator;
import laddergame.view.OutputView;

public class LadderController {
    public static final int RETRY_LIMIT = 5;

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
        final PersonalNames names = createPersonalNames();
        final LadderResult ladderResult = createLadderResult(names);
        final Width ladderWidth = new Width(names.getSize());
        final Height ladderHeight = createHeight();

        final Ladder ladder = makeLadder(ladderWidth, ladderHeight);

        printLadder(names, ladderResult, ladder);
        playGame(names, ladderResult, ladder);
    }

    private Ladder makeLadder(Width ladderWidth, Height ladderHeight) {
        final LadderLinesGenerator ladderLinesGenerator = new LadderLinesGenerator(booleanGenerator);
        final List<Line> lines = ladderLinesGenerator.createLines(ladderWidth, ladderHeight);
        return new Ladder(ladderWidth, ladderHeight, lines);
    }

    private void playGame(PersonalNames names, LadderResult ladderResult, Ladder ladder) {
        final LadderGame ladderGame = new LadderGame(names, ladderResult);
        final GameResult result = ladderGame.moveAndGetResult(ladder);
        searchResultItemByNameFrom(result);
    }

    private void printLadder(PersonalNames names, LadderResult ladderResult, Ladder ladder) {
        final List<Line> lines = ladder.getLines();
        outputView.printLadderForm(ladderFormGenerator.generate(names, ladderResult, lines));
    }

    private PersonalNames createPersonalNames() {
        return createInstance(() -> new PersonalNames(inputView.readNames()), RETRY_LIMIT);
    }

    private LadderResult createLadderResult(PersonalNames names) {
        return createInstance(() -> LadderResult.of(names, inputView.readResults()), RETRY_LIMIT);
    }

    private Height createHeight() {
        return createInstance(() -> new Height(inputView.readHeight()), RETRY_LIMIT);
    }

    private <T> T createInstance(Supplier<T> supplier, int tryCount) {
        while (tryCount-- > 0) {
            try {
                return supplier.get();
            } catch (RuntimeException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        }
        throw new IllegalStateException("재시도 횟수를 넘었습니다.");
    }

    private void searchResultItemByNameFrom(GameResult t) {
        int count = 0;
        while (count++ < RETRY_LIMIT) {
            try {
                printResultForName(t);
                return;
            } catch (RuntimeException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        }
        throw new IllegalStateException("재시도 횟수를 넘었습니다.");
    }

    private void printResultForName(GameResult gameResult) {
        int count = 0;
        while (count++ < RETRY_LIMIT) {
            String name = inputView.readNameToCheckResult();
            if (isAll(name)) {
                outputView.printTotalResult(gameResult);
                break;
            }
            outputView.printResult(gameResult.searchBy(name));
        }
        throw new IllegalStateException("재시도 횟수를 넘었습니다.");
    }

    private static boolean isAll(String name) {
        return name.equals("all");
    }
}
