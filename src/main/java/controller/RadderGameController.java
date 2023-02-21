package controller;

import domain.Ladder;
import domain.Participants;
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

    public void play(BooleanGenerator booleanGenerator) {
        Participants participants = makeParticipants();
        Ladder ladder = generateLadder(participants, booleanGenerator);
        showLadder(participants, ladder);
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

    private void showLadder(Participants participants, Ladder ladder) {
        outputView.printLadder(participants, ladder);
    }
}
