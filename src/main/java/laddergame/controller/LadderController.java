package laddergame.controller;

import laddergame.LadderForm;
import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

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
        final List<Person> people = inputView.readNames()
                .stream()
                .map(Person::new)
                .collect(Collectors.toList());
        final Participants participants = new Participants(people);

        final Height height = new Height(inputView.readHeight());
        final Ladder ladder = new Ladder(participants, height);

        final List<Line> lines = ladder.createLines(booleanGenerator);
        outputView.printResult(LadderForm.joinUnitsFrom(participants.getNames(), lines));
    }
}
