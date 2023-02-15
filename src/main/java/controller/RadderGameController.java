package controller;

import domain.Participants;
import view.InputView;

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
}
