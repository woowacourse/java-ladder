package controller;

import java.util.List;
import model.Participants;
import view.InputView;

public class LadderController {
    InputView inputView;

    public LadderController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Participants participants = prepareParticipants();
    }

    private Participants prepareParticipants() {
        List<String> names = inputView.requestParticipantsName();
        return new Participants(names);
    }
}
