package controller;

import domain.Height;
import domain.Map;
import domain.Participants;
import domain.Weight;
import util.BooleanGenerator;
import view.input.InputView;
import view.output.OutputView;

public class RadderGameController {

    public void play(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        Participants participants = makeParticipants(inputView);
        Map map = generateMap(inputView, participants, booleanGenerator);
        showMap(outputView, participants, map);
    }

    private Participants makeParticipants(InputView inputView) {
        try {
            String participantNames = inputView.enterParticipantNames();
            return new Participants(participantNames);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return makeParticipants(inputView);
        }
    }

    private Map generateMap(InputView inputView, Participants participants, BooleanGenerator booleanGenerator) {
        try {
            Height height = new Height(inputView.enterHeight());
            Weight weight = new Weight(participants.getParticipantCount());
            return new Map(height, weight, booleanGenerator);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return generateMap(inputView, participants, booleanGenerator);
        }
    }

    private void showMap(OutputView outputView, Participants participants, Map map) {
        outputView.printMap(participants, map);
    }
}
