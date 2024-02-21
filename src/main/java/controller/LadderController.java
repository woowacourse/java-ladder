package controller;

import java.util.List;
import model.Ladder;
import model.Participants;
import view.InputView;

public class LadderController {
    InputView inputView;

    public LadderController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Participants participants = prepareParticipants();
        Ladder ladder = prepareLadder(participants);
    }

    private Participants prepareParticipants() {
        List<String> names = inputView.requestParticipantsName();
        return new Participants(names);
    }

    private Ladder prepareLadder(Participants participants) {
        int ladderHeight = inputView.requestLadderHeight();
        int numberOfParticipants = participants.getParticipantsSize();
        return new Ladder(ladderHeight, numberOfParticipants);
    }
}
