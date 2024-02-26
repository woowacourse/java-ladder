package controller;

import domain.Ladder;
import domain.Participants;
import exception.controller.LadderGameExceptionMessage;
import utils.RandomStepGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Participants participants;

    public void play() {
        try {
            run();
        } catch (StackOverflowError e) {
            System.out.println(LadderGameExceptionMessage.EXIT.getExceptionMessage());
        }
    }

    private void run() {
        participants = recruitParticipants();
        Ladder ladder = makeLadder();
        outputView.printResult(participants, ladder);
    }

    private Participants recruitParticipants() {
        try {
            List<String> names = inputView.readNames();
            return new Participants(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return recruitParticipants();
        }
    }

    private Ladder makeLadder() {
        try {
            int height = inputView.readHeight();
            return new Ladder(height, participants.getParticipantsCount(), new RandomStepGenerator());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadder();
        }
    }
}
