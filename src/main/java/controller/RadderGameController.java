package controller;

import domain.Map;
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
        Map map = generateMap(participants, booleanGenerator);
        showMap(participants, map);
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

    private Map generateMap(Participants participants, BooleanGenerator booleanGenerator) {
        try {
            String height = inputView.enterHeight();
            return new Map(height, participants.getCount(), booleanGenerator);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return generateMap(participants, booleanGenerator);
        }
    }

    private void showMap(Participants participants, Map map) {
        outputView.printMap(participants, map);
    }
}
