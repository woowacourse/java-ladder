package laddergame.controller;

import static laddergame.utils.RetryUtils.retryOnRuntimeExceptionWithMessage;

import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.BooleanGenerator;
import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Name;
import laddergame.domain.Participants;
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
        final Participants participants = retryOnRuntimeExceptionWithMessage(() -> new Participants(readNames()));
        final Width ladderWidth = new Width(participants.getSize());
        final Height ladderHeight = retryOnRuntimeExceptionWithMessage(() -> new Height(inputView.readHeight()));
        final Ladder ladder = new Ladder(ladderWidth, ladderHeight, booleanGenerator);

        final List<Line> lines = ladder.getLines();
        outputView.printResult(ladderFormGenerator.generate(participants, lines));
    }

    private List<Name> readNames() {
        return inputView.readNames()
                .stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }
}
