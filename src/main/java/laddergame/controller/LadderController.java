package laddergame.controller;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.LadderForm;
import laddergame.view.OutputView;

import java.util.List;

import static laddergame.utils.ExceptionTemplate.repeatAndPrintCause;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderController(final InputView inputView,
                            final OutputView outputView,
                            final BooleanGenerator booleanGenerator
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        final Participants participants = repeatAndPrintCause(() -> new Participants(inputView.readNames()));
        final Height height = repeatAndPrintCause(() -> new Height(inputView.readHeight()));

        final Ladder ladder = new Ladder(participants, height);

        final List<Line> lines = ladder.createLines(booleanGenerator);
        outputView.printResult(LadderForm.joinUnitsFrom(participants.getNames(), lines));
    }
}
