package controller;

import domain.Map;
import domain.Participants;
import util.BooleanGenerator;
import view.InputView;
import view.OutputView;

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

    public Map makeMap(InputView inputView, Participants participants, BooleanGenerator booleanGenerator) {
        try {
            String height = inputView.enterHeight();
            Map map = new Map(height, participants.getParticipantCount());
            map.generate(booleanGenerator);
            return map;
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return makeMap(inputView, participants, booleanGenerator);
        }
    }

    public void showMap(OutputView outputView, Participants participants, Map map) {
        outputView.printMap(participants, map);
    }
}
