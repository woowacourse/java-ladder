package controller;

import domain.Ladder;
import domain.LadderResults;
import domain.Participants;
import java.util.Map;
import util.BooleanGenerator;
import view.InputView;
import view.OutputView;

public class RadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void ready(BooleanGenerator booleanGenerator) {
        Participants participants = makeParticipants();
        Ladder ladder = generateLadder(participants, booleanGenerator);
        LadderResults ladderResults = makeLadderResults();
        showGameMap(participants, ladder, ladderResults);
    }

    private Participants makeParticipants() {
        try {
            String participantsName = inputView.enterParticipantsName();
            return new Participants(participantsName);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return makeParticipants();
        }
    }

    private LadderResults makeLadderResults() {
        try {
            String participantsName = inputView.enterLadderResult();
            return new LadderResults(participantsName);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return makeLadderResults();
        }
    }

    private Ladder generateLadder(Participants participants, BooleanGenerator booleanGenerator) {
        try {
            final String height = inputView.enterHeight();
            final int lineWeight = participants.getCount() - 1;
            return new Ladder(height, lineWeight, booleanGenerator);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return generateLadder(participants, booleanGenerator);
        }
    }

    private void showGameMap(Participants participants, Ladder ladder, LadderResults ladderResults) {
        outputView.printGameMap(participants, ladder, ladderResults);
    }
}
