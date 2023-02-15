package controller;

import domain.Ladder;
import domain.Participants;
import util.BooleanGenerator;
import view.input.InputView;
import view.output.OutputView;

public class RadderGameController {

    public Participants makeParticipants(InputView inputView) {
        try {
            String participantsName = inputView.enterParticipantsName();
            return new Participants(participantsName);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return makeParticipants(inputView);
        }
    }

    public Ladder makeLadder(InputView inputView, Participants participants, BooleanGenerator booleanGenerator) {
        try {
            String height = inputView.enterHeight();
            Ladder ladder = new Ladder(height, participants.getParticipantCount());
            ladder.generate(booleanGenerator);
            return ladder;
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return makeLadder(inputView, participants, booleanGenerator);
        }
    }

    public void showLadder(OutputView outputView, Participants participants, Ladder ladder) {
        outputView.printMap(participants, ladder);
    }
}
