package controller;

import domain.Map;
import domain.Participants;
import util.RandomBooleanGenerator;
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

    public Map makeMap(InputView inputView, Participants participants) {
        try {
            String height = inputView.enterHeight();
            Map map = new Map(height, participants.getParticipantsName().size() - 1);
            map.generate(new RandomBooleanGenerator());
            return map;
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return makeMap(inputView, participants);
        }
    }
}
