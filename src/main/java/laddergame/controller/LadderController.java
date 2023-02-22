package laddergame.controller;

import static laddergame.utils.RetryUtils.retryOnRuntimeExceptionWithMessage;

import java.util.List;
import java.util.Map;
import laddergame.domain.BooleanGenerator;
import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.LadderGame;
import laddergame.domain.LadderResult;
import laddergame.domain.Line;
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
        final PersonalNames names = retryOnRuntimeExceptionWithMessage(() -> new PersonalNames(inputView.readNames()));
        final LadderResult ladderResult = retryOnRuntimeExceptionWithMessage(
                () -> LadderResult.of(names, inputView.readResults()));

        final Height ladderHeight = retryOnRuntimeExceptionWithMessage(() -> new Height(inputView.readHeight()));
        final Ladder ladder = new Ladder(new Width(names.getSize()), ladderHeight, booleanGenerator);

        final List<Line> lines = ladder.getLines();
        outputView.printResult(ladderFormGenerator.generate(names, lines));

        final LadderGame ladderGame = new LadderGame(names, ladderResult);
        Map<String, String> result = ladderGame.moveAndGetResult(ladder);

    }

    public void 보고싶은사람결과보여주고끝내기() {
        
    }
}
