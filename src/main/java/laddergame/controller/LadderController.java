package laddergame.controller;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.LadderForm;
import laddergame.view.LadderMatchForm;
import laddergame.view.OutputView;

import java.util.Map;

import static laddergame.utils.ExceptionTemplate.repeatAndPrintCause;

public class LadderController {
    private static final String FIND_ALL_MATCH_RESULTS_COMMAND = "all";
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
        final Results results = repeatAndPrintCause(() -> new Results(inputView.readResults(), participants.getNames()));
        final Height height = repeatAndPrintCause(() -> new Height(inputView.readHeight()));
        final Width width = new Width(participants.getSize() - 1);
        final LineCreator lineCreator = new LineCreator(booleanGenerator);
        final Ladder ladder = new Ladder(lineCreator.createLines(width, height));
        final Lines findLines = ladder.getLines();

        outputView.printResult(LadderForm.joinUnitsFrom(participants.getNameValues(), findLines.getLines(), results.getResults()));
        runLadderMatch(ladder, participants, results);
    }

    private void runLadderMatch(final Ladder ladder, final Participants participants, final Results results) {
        final LadderMatch ladderMatch = new LadderMatch(ladder, participants, results);
        String command = "";
        while (!command.equals(FIND_ALL_MATCH_RESULTS_COMMAND)) {
            command = inputView.readName();
            final Map<Name, Result> matchResults = ladderMatch.getLadderMatchResults(command);
            outputView.printMatchResult(LadderMatchForm.joinUnitsFrom(matchResults));
        }
    }
}
