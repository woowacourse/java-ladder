package laddergame.controller;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.LadderForm;
import laddergame.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

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
        final Participants participants = repeatAndPrintCause(this::getParticipants);
        final Height height = repeatAndPrintCause(this::getHeight);

        final Ladder ladder = new Ladder(participants, height);

        final List<Line> lines = ladder.createLines(booleanGenerator);
        outputView.printResult(LadderForm.joinUnitsFrom(participants.getNames(), lines));
    }

    private Participants getParticipants() {
        final List<Name> names = inputView.readNames()
                .stream()
                .map(Name::new)
                .collect(Collectors.toList());
        return new Participants(names);
    }

    private Height getHeight() {
        return new Height(inputView.readHeight());
    }
}
